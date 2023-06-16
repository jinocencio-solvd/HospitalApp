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

public class MyBatisUtil {

    public static final String OUT_DIR = EXPORT_OUT_DIR + "/xml/mybatis_mappers/";
    private static final Charset XML_CHARSET = StandardCharsets.UTF_8;
    private static final String docDeclaration = "<!DOCTYPE mapper \n\t\t PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \n\t\t \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">";
    private static final String typeDelimiter = DbMapper.modelLoc;
    private static final String indentStep = " ".repeat(4);
    private static final String fieldDelimiter = "field_";

    public static void generateXml(Map<String, String> modelMap) {
        try {
            String filename = modelMap.get("type").toLowerCase()
                .replace(typeDelimiter, "") + "_mapper";
            String filepath = OUT_DIR + filename + FileType.XML.getExtension();
            OutputStream outPath = new FileOutputStream(filepath);

            XMLOutputFactory xof = XMLOutputFactory.newFactory();
            IndentingXMLStreamWriter xsw = new IndentingXMLStreamWriter(
                xof.createXMLStreamWriter(outPath, XML_CHARSET.name()));

            // Enable indentation and formatting
            xsw.setIndentStep(indentStep);

            // Start writing XML
            xsw.writeStartDocument(XML_CHARSET.name(), "1.0");
            xsw.writeDTD(docDeclaration);
            xsw.writeCharacters("\n\n");

            xsw.writeStartElement("mapper");
            xsw.writeAttribute("namespace", modelMap.get("namespace"));

            xsw.writeStartElement("resultMap");
            xsw.writeAttribute("id", modelMap.get("type") + "ResultMap");

            xsw.writeAttribute("type",
                modelMap.get("type").replace(typeDelimiter, ""));
            xsw.writeAttribute("autoMapping", "false");

            List<String> fieldList = modelMap.keySet()
                .stream()
                .filter(key -> key.startsWith(fieldDelimiter))
                .collect(Collectors.toList());
            for (String key : fieldList) {
                String field = key.replaceAll(fieldDelimiter, "");
                xsw.writeEmptyElement("result");
                xsw.writeAttribute("property", field);
                xsw.writeAttribute("column", modelMap.get(key));
            }
            xsw.writeEndElement(); // resultMap

            List<String> colFormattedList = fieldList.stream()
                .map(modelMap::get)
                .collect(Collectors.toList());
            String colFormatted = StringUtil.formatCollectionsString(colFormattedList);
            List<String> valFormattedList = fieldList.stream()
                .map(str -> str.replace(fieldDelimiter, ""))
                .map(StringUtil::convertToMyBatisPlaceholder)
                .collect(Collectors.toList());
            String valFormatted = StringUtil.formatCollectionsString(valFormattedList);

            // insert tag
            xsw.writeStartElement("insert");
            xsw.writeAttribute("id", "save");
            xsw.writeAttribute("parameterType", modelMap.get("type"));
            xsw.writeCharacters("\n\t\t");
            xsw.writeCharacters(
                "INSERT INTO " + modelMap.get("table_name") + " " + colFormatted
                    + "\n\t\t " + " VALUES " + valFormatted);
            xsw.writeCharacters("\n\t");
            xsw.writeEndElement(); // insert

            // update tag
            List<String> colValList = IntStream.range(0, colFormattedList.size())
                .mapToObj(i -> colFormattedList.get(i) + " = " + valFormattedList.get(i))
                .collect(Collectors.toList());
            String formattedColVal = String.join(", ", colValList);
            xsw.writeStartElement("update");
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

            // delete tag
            xsw.writeStartElement("delete");
            xsw.writeAttribute("id", "deleteById");
            xsw.writeAttribute("parameterType", "int");
            xsw.writeCharacters("\n\t\t");
            xsw.writeCharacters(
                "DELETE FROM " + modelMap.get("table_name") + " WHERE id = #{id}"
            );
            xsw.writeCharacters("\n\t");
            xsw.writeEndElement(); // update

            // select tag
            xsw.writeStartElement("select");
            xsw.writeAttribute("id", "getById");
            xsw.writeAttribute("parameterType", "int");
            xsw.writeCharacters("\n\t\t");
            xsw.writeCharacters(
                "SELECT * FROM " + modelMap.get("table_name") + " WHERE id = #{id}"
            );
            xsw.writeCharacters("\n\t");
            xsw.writeEndElement(); // select

            // select all tag
            xsw.writeStartElement("select");
            xsw.writeAttribute("id", "getAll");
            xsw.writeAttribute("resultMap",
                modelMap.get("type").replace(fieldDelimiter, "") + "ResultMap");
            xsw.writeCharacters("\n\t\t");
            xsw.writeCharacters(
                "SELECT * FROM " + modelMap.get("table_name")
            );
            xsw.writeCharacters("\n\t");
            xsw.writeEndElement(); // select all

            xsw.writeEndElement(); // mapper
            // End writing XML
            xsw.writeEndDocument();
            xsw.close();

            System.out.println("XML file created successfully.");
        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Map<String, Map<String, String>> dbMap = DbMapper.getPropertyColumnMap();
        for (String model : dbMap.keySet()) {
            generateXml(dbMap.get(model));
        }
    }

}
