package com.laba.utils;

import static org.testng.Assert.*;

import com.laba.utils.xml.XMLParser;
import java.io.File;
import java.util.List;
import java.util.Map;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class XMLParserTest {

    private static String xmlFilePath;

    @BeforeMethod
    public void setUp() {
        xmlFilePath = "src/main/resources/xml/hospital.xml";
    }

    @Test
    public void testDomParseToMap() {
        File xmlFile = new File(xmlFilePath);
        Map<String, List<Map<String, String>>> XMLMap = XMLParser.domParseToMap(xmlFile);
        assertEquals(XMLMap.size(), 15);
        assertEquals(XMLMap.get("persons").get(0).get("first_name"), "Michael");
        assertEquals(XMLMap.get("persons").get(0).get("last_name"), "Scott");
    }

    @Test
    public void testDomParseElementToMap() {
        File xmlFile = new File(xmlFilePath);
        List<Map<String, String>> personsList = XMLParser.domParseElementToList(xmlFile, "person");
        assertEquals(personsList.size(), 19);
        assertEquals(personsList.get(5).get("first_name"), "Dwight");
        assertEquals(personsList.get(5).get("last_name"), "Schrute");
    }
}