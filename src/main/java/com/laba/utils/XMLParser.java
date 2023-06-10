package com.laba.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLParser {

    private static final Logger LOG = LogManager.getLogger(XMLParser.class);

    private static Element getRootElement(File xmlFile) {
        Element rootElement = null;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            rootElement = document.getDocumentElement();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return rootElement;
    }

    public static Map<String, List<Map<String, String>>> domParseToMap(File xmlFile) {
        Map<String, List<Map<String, String>>> retMap = new HashMap<>();
        Element rootElement = getRootElement(xmlFile);
        NodeList rootChildren = rootElement.getChildNodes();
        for (int i = 0; i < rootChildren.getLength(); i++) {
            Node rootChildNode = rootChildren.item(i);
            if (rootChildNode.getNodeType() == Node.ELEMENT_NODE) {
                Element rootChildElem = (Element) rootChildNode;
                String rootChildElemName = rootChildElem.getNodeName();
                String rootChildSubChild = rootChildElem.getChildNodes().item(1).getNodeName();
                retMap.put(rootChildElemName, domParseElementToList(xmlFile, rootChildSubChild));
            }
        }
        return retMap;
    }

    public static List<Map<String, String>> domParseElementToList(File xmlFile,
        String elementName) {
        List<Map<String, String>> list = new ArrayList<>();
        Element rootElement = getRootElement(xmlFile);
        NodeList children = rootElement.getElementsByTagName(elementName);
        for (int i = 0; i < children.getLength(); i++) {
            Map<String, String> map = new HashMap<>();
            Node childNode = children.item(i);
            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                Element childElement = (Element) childNode;
                String childElementName = childElement.getNodeName();
                LOG.trace("Element Name: " + childElementName);

                NodeList subElements = childElement.getElementsByTagName("*");
                for (int j = 0; j < subElements.getLength(); j++) {
                    Element subElement = (Element) subElements.item(j);
                    String subElementName = subElement.getNodeName();
                    String subElementValue = subElement.getTextContent();
                    LOG.trace(subElementName + " - " + subElementValue);
                    map.put(subElementName, subElementValue);
                }
                list.add(map);
            }
        }
        return list;
    }
}