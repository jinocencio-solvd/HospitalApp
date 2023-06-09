package com.laba.utils;

import static org.testng.Assert.*;

import java.io.File;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class XMLParserTest {
    private static String xmlFilePath;

    @BeforeMethod
    public void setUp() {
        xmlFilePath = "src/main/resources/XML/hospital.xml";
    }

    @Test
    public void testDomParser() {
        File xmlFile = new File(xmlFilePath);
        XMLParser.domParserToLogger(xmlFile);
    }

    @Test
    public void testDomParserByElement() {
        File xmlFile = new File(xmlFilePath);
        XMLParser.domParserByElementToLogger(xmlFile, "person");
    }
}