package com.laba.utils;

import static com.laba.utils.AppConfig.EXPORT_OUT_DIR;

import com.laba.enums.FileType;
import com.sun.xml.txw2.output.IndentingXMLStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;

public class MyBatisUtil {

    public static final String OUT_DIR = EXPORT_OUT_DIR + "/xml/mybatis_mappers/";
    private static final Charset XML_CHARSET = StandardCharsets.UTF_8;
    private static final String docDeclaration = "<!DOCTYPE mapper \n\t\t PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \n\t\t \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">";


    public static void generateXml(Map<String, String> modelMap) {
        try {
            String filepath =
                OUT_DIR + modelMap.get("type").toLowerCase() + FileType.XML.getExtension();
            OutputStream outPath = new FileOutputStream(filepath);

            XMLOutputFactory xof = XMLOutputFactory.newFactory();
            IndentingXMLStreamWriter xsw = new IndentingXMLStreamWriter(
                xof.createXMLStreamWriter(outPath, XML_CHARSET.name()));

            // Enable indentation and formatting
            xsw.setIndentStep("    ");

            // Start writing XML
            xsw.writeStartDocument(XML_CHARSET.name(), "1.0");
            xsw.writeDTD(docDeclaration);
            xsw.writeCharacters("\n\n");

            xsw.writeStartElement("mapper");
            xsw.writeAttribute("namespace", modelMap.get("namespace"));

            xsw.writeStartElement("resultMap");
            xsw.writeAttribute("id", modelMap.get("type") + "ResultMap");
            xsw.writeAttribute("type", modelMap.get("type"));
            xsw.writeAttribute("autoMapping", "false");
            for (String key : modelMap.keySet()) {
                String delimiter = "field_";
                if (key.startsWith(delimiter)) {
                    String field = key.replaceAll(delimiter, "");
                    xsw.writeEmptyElement("result");
                    xsw.writeAttribute("property", field);
                    xsw.writeAttribute("column", modelMap.get(key));
                }
            }

            xsw.writeEndElement();
            xsw.writeEndElement();

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
        String model = "person";
        Map<String, String> modelMap = dbMap.get(model);
        generateXml(modelMap);
    }

}
