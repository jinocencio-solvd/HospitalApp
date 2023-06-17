package com.laba.utils.mybatis;

import static com.laba.utils.AppConfig.EXPORT_OUT_DIR;

import com.laba.enums.FileType;
import com.laba.utils.StringUtil;
import com.sun.xml.txw2.output.IndentingXMLStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyBatisXmlMapperGenerator {

    private static final Logger LOG = LogManager.getLogger(MyBatisXmlMapperGenerator.class);

    private static final String OUT_DIR = EXPORT_OUT_DIR + "/xml/mybatis-mappers/";
    private static final Charset XML_CHARSET = StandardCharsets.UTF_8;
    private static final String typeDelimiter = DbMapper.modelLoc;
    private static final String fieldDelimiter = "field_";
    private static final String newLine = System.getProperty("line.separator");
    private static final String indentStep = " ".repeat(4);
    private static final String emptyString = "";

    public static void main(String[] args) {
        // TODO: XML file line endings need to be reconfigured by text editor for XML to be read
        //  by mybatis. Does not matter which type.
        Map<String, Map<String, String>> dbMap = DbMapper.getPropertyColumnMap();
        for (String model : dbMap.keySet()) {
            generateXml(dbMap.get(model));
        }
    }

    private static void generateXml(Map<String, String> modelMap) {
        try {
            String filename = modelMap.get("type").toLowerCase()
                .replace(typeDelimiter, emptyString) + "-mapper" + FileType.XML.getExtension();
            String filepath = OUT_DIR + filename;
            OutputStream outPath = new FileOutputStream(filepath);

            XMLOutputFactory xof = XMLOutputFactory.newFactory();
            IndentingXMLStreamWriter xsw = new IndentingXMLStreamWriter(
                xof.createXMLStreamWriter(outPath, XML_CHARSET.name()));
            xsw.setIndentStep(indentStep);

            generateDocumentDeclaration(xsw);
            generateMapperElement(xsw, modelMap);

            xsw.close();
            LOG.info("XML file created successfully.");
        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void generateMapperElement(IndentingXMLStreamWriter xsw,
        Map<String, String> modelMap) throws XMLStreamException {

        List<String> fieldList = modelMap.keySet()
            .stream()
            .filter(key -> key.startsWith(fieldDelimiter))
            .collect(Collectors.toList());

        List<String> colFormattedList = fieldList.stream()
            .map(modelMap::get)
            .collect(Collectors.toList());

        List<String> valFormattedList = fieldList.stream()
            .map(str -> str.replace(fieldDelimiter, emptyString))
            .map(StringUtil::convertToMyBatisPlaceholder)
            .collect(Collectors.toList());

        String resultMap = modelMap.get("type")
            .replace(fieldDelimiter, emptyString)
            .replace(typeDelimiter, emptyString)
            + "ResultMap";

        xsw.writeStartElement("mapper");
        xsw.writeAttribute("namespace", modelMap.get("namespace"));

        generateInsertElement(xsw, modelMap, colFormattedList, valFormattedList);
        generateUpdateElement(xsw, modelMap, colFormattedList, valFormattedList);
        generateDeleteElement(xsw, modelMap);
        generateResultMapElement(xsw, modelMap, fieldList, resultMap);
        generateSelectElement(xsw, modelMap, resultMap);
        generateSelectAllElement(xsw, modelMap, resultMap);

        xsw.writeEndElement(); // mapper
    }

    private static void generateDocumentDeclaration(IndentingXMLStreamWriter xsw)
        throws XMLStreamException {

        xsw.writeStartDocument(XML_CHARSET.name(), "1.0");
        xsw.writeDTD(
            "<!DOCTYPE mapper " + newLine + indentStep
                + " PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" "
                + newLine + indentStep.repeat(2)
                + "\"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">"
        );
        xsw.writeCharacters(newLine + newLine);
    }

    private static void generateResultMapElement(IndentingXMLStreamWriter xsw,
        Map<String, String> modelMap, List<String> fieldList, String resultMap)
        throws XMLStreamException {

        xsw.writeStartElement("resultMap");
        xsw.writeAttribute("id", resultMap);
        xsw.writeAttribute("type",
            modelMap.get("type").replace(typeDelimiter, emptyString));
        xsw.writeAttribute("autoMapping", "false");

        for (String key : fieldList) {
            String field = key.replaceAll(fieldDelimiter, emptyString);
            xsw.writeEmptyElement("result");
            xsw.writeAttribute("property", field);
            xsw.writeAttribute("column", modelMap.get(key));
        }
        xsw.writeEndElement(); // resultMap
    }

    private static void generateInsertElement(IndentingXMLStreamWriter xsw,
        Map<String, String> modelMap, List<String> colFormattedList, List<String> valFormattedList)
        throws XMLStreamException {

        String valFormatted = StringUtil.formatCollectionsString(valFormattedList);
        String colFormatted = StringUtil.formatCollectionsString(colFormattedList);

        xsw.writeStartElement("insert"); // insert tag
        xsw.writeAttribute("id", "save");
        xsw.writeAttribute("parameterType", modelMap.get("type"));
        xsw.writeCharacters(newLine + indentStep.repeat(2));
        xsw.writeCharacters(
            "INSERT INTO " + modelMap.get("table_name") + " " + colFormatted
                + newLine + indentStep.repeat(2) + " VALUES " + valFormatted);
        xsw.writeCharacters(newLine + indentStep);
        xsw.writeEndElement(); // insert
    }

    private static void generateUpdateElement(IndentingXMLStreamWriter xsw,
        Map<String, String> modelMap, List<String> colFormattedList, List<String> valFormattedList)
        throws XMLStreamException {

        List<String> colValList = IntStream.range(0, colFormattedList.size())
            .mapToObj(
                i -> colFormattedList.get(i) + " = " + valFormattedList.get(i)
            ).collect(Collectors.toList());
        String formattedColVal = String.join(", ", colValList);

        xsw.writeStartElement("update"); // update tag
        xsw.writeAttribute("id", "update");
        xsw.writeAttribute("parameterType", modelMap.get("type"));
        xsw.writeCharacters(newLine + indentStep.repeat(2));
        xsw.writeCharacters(
            "UPDATE " + modelMap.get("table_name")
                + newLine + indentStep.repeat(2) + " SET " + formattedColVal
                + newLine + indentStep.repeat(2) + " WHERE id = #{id}"
        );
        xsw.writeCharacters(newLine + indentStep);
        xsw.writeEndElement(); // update
    }

    private static void generateDeleteElement(IndentingXMLStreamWriter xsw,
        Map<String, String> modelMap)
        throws XMLStreamException {

        xsw.writeStartElement("delete"); // delete tag
        xsw.writeAttribute("id", "deleteById");
        xsw.writeAttribute("parameterType", "int");
        xsw.writeCharacters(newLine + indentStep.repeat(2));
        xsw.writeCharacters(
            "DELETE FROM " + modelMap.get("table_name") + " WHERE id = #{id}"
        );
        xsw.writeCharacters(newLine + indentStep);
        xsw.writeEndElement(); // delete
    }

    private static void generateSelectElement(IndentingXMLStreamWriter xsw,
        Map<String, String> modelMap, String resultMap) throws XMLStreamException {

        xsw.writeStartElement("select"); // select tag
        xsw.writeAttribute("id", "getById");
        xsw.writeAttribute("parameterType", "int");
        xsw.writeAttribute("resultMap", resultMap);
        xsw.writeCharacters(newLine + indentStep.repeat(2));
        xsw.writeCharacters(
            "SELECT * FROM " + modelMap.get("table_name") + " WHERE id = #{id}"
        );
        xsw.writeCharacters(newLine + indentStep);
        xsw.writeEndElement(); // select
    }

    private static void generateSelectAllElement(IndentingXMLStreamWriter xsw,
        Map<String, String> modelMap, String resultMap) throws XMLStreamException {

        xsw.writeStartElement("select"); // select all tag
        xsw.writeAttribute("id", "getAll");
        xsw.writeAttribute("resultMap", resultMap);
        xsw.writeCharacters(newLine + indentStep.repeat(2));
        xsw.writeCharacters(
            "SELECT * FROM " + modelMap.get("table_name")
        );
        xsw.writeCharacters(newLine + indentStep);
        xsw.writeEndElement(); // select all
    }
}
