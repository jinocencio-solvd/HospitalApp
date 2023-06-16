package com.laba.utils;

import static com.laba.utils.AppConfig.EXPORT_OUT_DIR;

import com.laba.enums.FileType;
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

public class MyBatisUtil {

    private static final Logger LOG = LogManager.getLogger(MyBatisUtil.class);

    public static final String OUT_DIR = EXPORT_OUT_DIR + "/xml/mybatis_mappers/";
    private static final Charset XML_CHARSET = StandardCharsets.UTF_8;
    private static final String typeDelimiter = DbMapper.modelLoc;
    private static final String indentStep = " ".repeat(4);
    private static final String fieldDelimiter = "field_";

    public static void main(String[] args) {
        Map<String, Map<String, String>> dbMap = DbMapper.getPropertyColumnMap();
        for (String model : dbMap.keySet()) {
            generateXml(dbMap.get(model));
        }
    }

    public static void generateXml(Map<String, String> modelMap) {
        try {
            String filename = modelMap.get("type").toLowerCase()
                .replace(typeDelimiter, "") + "_mapper" + FileType.XML.getExtension();
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
            .map(str -> str.replace(fieldDelimiter, ""))
            .map(StringUtil::convertToMyBatisPlaceholder)
            .collect(Collectors.toList());
        
        xsw.writeStartElement("mapper");
        xsw.writeAttribute("namespace", modelMap.get("namespace"));
        
        generateResultMapElement(xsw, modelMap, fieldList);
        generateInsertElement(xsw, modelMap, colFormattedList, valFormattedList);
        generateUpdateElement(xsw, modelMap, colFormattedList, valFormattedList);
        generateDeleteElement(xsw, modelMap);
        generateSelectElement(xsw, modelMap);
        generateSelectAllElement(xsw, modelMap);

        xsw.writeEndElement(); // mapper
    }

    private static void generateDocumentDeclaration(IndentingXMLStreamWriter xsw)
        throws XMLStreamException {

        xsw.writeStartDocument(XML_CHARSET.name(), "1.0");
        xsw.writeDTD(
            "<!DOCTYPE mapper \n\t\t PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" "
                + "\n\t\t \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">"
        );
        xsw.writeCharacters("\n\n");
    }

    private static void generateResultMapElement(IndentingXMLStreamWriter xsw,
        Map<String, String> modelMap, List<String> fieldList) throws XMLStreamException {

        xsw.writeStartElement("resultMap");
        xsw.writeAttribute("id", modelMap.get("type") + "ResultMap");
        xsw.writeAttribute("type",
            modelMap.get("type").replace(typeDelimiter, ""));
        xsw.writeAttribute("autoMapping", "false");

        for (String key : fieldList) {
            String field = key.replaceAll(fieldDelimiter, "");
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
        xsw.writeCharacters("\n\t\t");
        xsw.writeCharacters(
            "INSERT INTO " + modelMap.get("table_name") + " " + colFormatted
                + "\n\t\t " + " VALUES " + valFormatted);
        xsw.writeCharacters("\n\t");
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
        xsw.writeCharacters("\n\t\t");
        xsw.writeCharacters(
            "UPDATE " + modelMap.get("table_name")
                + "\n\t\t SET " + formattedColVal
                + "\n\t\t WHERE id = #{id}"
        );
        xsw.writeCharacters("\n\t");
        xsw.writeEndElement(); // update
    }


    private static void generateDeleteElement(IndentingXMLStreamWriter xsw,
        Map<String, String> modelMap)
        throws XMLStreamException {

        xsw.writeStartElement("delete"); // delete tag
        xsw.writeAttribute("id", "deleteById");
        xsw.writeAttribute("parameterType", "int");
        xsw.writeCharacters("\n\t\t");
        xsw.writeCharacters(
            "DELETE FROM " + modelMap.get("table_name") + " WHERE id = #{id}"
        );
        xsw.writeCharacters("\n\t");
        xsw.writeEndElement(); // delete
    }

    private static void generateSelectElement(IndentingXMLStreamWriter xsw,
        Map<String, String> modelMap) throws XMLStreamException {

        xsw.writeStartElement("select"); // select tag
        xsw.writeAttribute("id", "getById");
        xsw.writeAttribute("parameterType", "int");
        xsw.writeCharacters("\n\t\t");
        xsw.writeCharacters(
            "SELECT * FROM " + modelMap.get("table_name") + " WHERE id = #{id}"
        );
        xsw.writeCharacters("\n\t");
        xsw.writeEndElement(); // select
    }

    private static void generateSelectAllElement(IndentingXMLStreamWriter xsw,
        Map<String, String> modelMap) throws XMLStreamException {

        xsw.writeStartElement("select"); // select all tag
        xsw.writeAttribute("id", "getAll");
        xsw.writeAttribute("resultMap",
            modelMap.get("type").replace(fieldDelimiter, "") + "ResultMap");
        xsw.writeCharacters("\n\t\t");
        xsw.writeCharacters(
            "SELECT * FROM " + modelMap.get("table_name")
        );
        xsw.writeCharacters("\n\t");
        xsw.writeEndElement(); // select all
    }
}
