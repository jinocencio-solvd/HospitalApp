package com.laba.utils;

import static org.testng.Assert.*;

import com.laba.utils.xml.XMLValidator;
import java.io.File;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class XMLValidatorTest {

    private static String xsdFilePath;
    private static String xmlFilePath;

    @BeforeMethod
    public void setUp() {
        xmlFilePath = "src/main/resources/XML/hospital.xml";
        xsdFilePath = "src/main/resources/XML/hospitalschema.xsd";
    }

    @Test
    public void testIsValidXML() {
        File xmlFile = new File(xmlFilePath);
        File xsdFile = new File(xsdFilePath);
        boolean xmlIsValid = XMLValidator.isValidXML(xmlFile, xsdFile);
        assertTrue(xmlIsValid);
    }
}