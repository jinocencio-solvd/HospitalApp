package com.laba.utils;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.parsers.DocumentBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLParser {

    private static final Logger LOG = LogManager.getLogger(ConnectionPool.class);

    public static void domParseToMap(File xmlFile) {
        // TODO: Implement recursive solution
    }

    public static void domParserToLogger(File xmlFile) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            Element rootElement = document.getDocumentElement();
            NodeList rootChildren = rootElement.getChildNodes();
            for (int i = 0; i < rootChildren.getLength(); i++) {
                Node rootChildNode = rootChildren.item(i);
                if (rootChildNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element rootChildElem = (Element) rootChildNode;
                    String rootChildElemName = rootChildElem.getNodeName();
                    LOG.info(rootChildElemName);

                    NodeList rootChildrenSubChildren = rootChildElem.getChildNodes();
                    for (int j = 0; j < rootChildrenSubChildren.getLength(); j++) {
                        Node subChildNode = rootChildrenSubChildren.item((j));
                        if (subChildNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element subChildElem = (Element) subChildNode;
                            String subChildElemName = subChildElem.getNodeName();
                            LOG.info(subChildElemName);

                            NodeList rootChildrenSubSubChildren = subChildElem.getChildNodes();
                            for (int k = 0; k < rootChildrenSubSubChildren.getLength(); k++) {
                                Node subSubChildNode = rootChildrenSubSubChildren.item((k));
                                if (subSubChildNode.getNodeType() == Node.ELEMENT_NODE) {
                                    Element subSubChildElem = (Element) subSubChildNode;
                                    String subSubChildElemName = subSubChildElem.getNodeName();
                                    String subSubChildElemValue = subSubChildElem.getTextContent();
                                    LOG.info(subSubChildElemName + " - " + subSubChildElemValue);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void domParserByElementToLogger(File xmlFile, String elementName) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            Element rootElement = document.getDocumentElement();
            NodeList children = rootElement.getElementsByTagName(elementName);
            for (int i = 0; i < children.getLength(); i++) {
                Node childNode = children.item(i);
                if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element childElement = (Element) childNode;
                    String childElementName = childElement.getNodeName();
                    LOG.info("Element Name: " + childElementName);

                    NodeList subElements = childElement.getElementsByTagName("*");
                    for (int j = 0; j < subElements.getLength(); j++) {
                        Element subElement = (Element) subElements.item(j);
                        String subElementName = subElement.getNodeName();
                        String subElementValue = subElement.getTextContent();
                        LOG.info(subElementName + " - " + subElementValue );
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}