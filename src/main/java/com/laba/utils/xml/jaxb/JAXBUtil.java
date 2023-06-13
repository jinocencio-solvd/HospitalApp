package com.laba.utils.xml.jaxb;

import static com.laba.utils.AppConfig.xmlOutputDir;

import com.sun.xml.txw2.output.IndentingXMLStreamWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JAXBUtil {

    private static final Logger LOG = LogManager.getLogger(JAXBUtil.class);
    private static final Charset XML_CHARSET = StandardCharsets.UTF_8;
    private static final String FILE_EXTENSION_XML = ".xml";

    public static void marshallManyXmlOut(List<?> objList) {
        Class<?> objClass = objList.get(0).getClass();
        try {
            String path = xmlOutputDir + objClass.getSimpleName() + FILE_EXTENSION_XML;
            OutputStream outPath = new FileOutputStream(path);
            String parentTagName = objClass.getSimpleName().toLowerCase() + "_container";

            JAXBContext context = JAXBContext.newInstance(objClass);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);

            XMLOutputFactory xof = XMLOutputFactory.newFactory();
            XMLStreamWriter xsw = new IndentingXMLStreamWriter(
                xof.createXMLStreamWriter(outPath, XML_CHARSET.name()));

            xsw.writeStartDocument(XML_CHARSET.name(), "1.0");
            xsw.writeStartElement(parentTagName);
            for (Object obj : objList) {
                marshaller.marshal(obj, xsw);
            }
            xsw.writeEndElement();
            xsw.writeEndDocument();
            xsw.close();
        } catch (JAXBException | FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private static boolean isDirectory(String pathDir) {
        Path dir = Paths.get(pathDir);
        return Files.isDirectory(dir);
    }

    public static void marshallOneXmlOut(Object obj, String outPutDir, String fileName) {
        if (!fileName.endsWith(FILE_EXTENSION_XML)) {
            fileName += FILE_EXTENSION_XML;
        }
        if (!isDirectory(outPutDir)) {
            LOG.error(outPutDir + " is not a directory.");
        }
        try {
            Class<?> objClass = obj.getClass();
            JAXBContext context = JAXBContext.newInstance(objClass);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(obj, new File(outPutDir + fileName));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static Object unmarshallOne(File file, Class<?> clazz) {
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller marshaller = context.createUnmarshaller();
            return marshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
