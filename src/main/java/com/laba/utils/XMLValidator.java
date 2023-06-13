package com.laba.utils;

import java.io.File;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

public class XMLValidator {

    private static final Logger LOG = LogManager.getLogger(XMLValidator.class);

    public static boolean isValidXML(File xmlFile, File xsdFile) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(xsdFile);
            Validator validator = schema.newValidator();

            validator.validate(new StreamSource(xmlFile));
            LOG.info(xmlFile.getName() + " validation successful");
            return true;
        } catch (IOException | SAXException e) {
            LOG.warn(
                xmlFile.getName() + " does not comply with the XSD schema " + xsdFile.getName());
            return false;
        }
    }
}