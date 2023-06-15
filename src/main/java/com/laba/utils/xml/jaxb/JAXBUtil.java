package com.laba.utils.xml.jaxb;

import static com.laba.utils.AppConfig.EXPORT_OUT_DIR;

import com.laba.enums.FileType;
import com.sun.xml.txw2.output.IndentingXMLStreamWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
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
    public static final String JAXB_OUT_DIR = EXPORT_OUT_DIR + "/xml/";

    private static String checkFilename(String filename) {
        if (!filename.endsWith(FileType.XML.getExtension())) {
            filename += FileType.XML.getExtension();
        }
        return filename;
    }

    public static void marshallManyXmlOut(List<?> objList, String filename) {
        filename = checkFilename(filename);
        Class<?> objClass = objList.get(0).getClass();
        try {
            String path = JAXB_OUT_DIR + filename;
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

    public static void marshallOneXmlOut(Object obj, String filename) {
        filename = checkFilename(filename);
        try {
            Class<?> objClass = obj.getClass();
            JAXBContext context = JAXBContext.newInstance(objClass);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            String filepath = JAXB_OUT_DIR + filename;
            marshaller.marshal(obj, new File(filepath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static Object unmarshallOne(Class<?> clazz, String filename) {
        filename = checkFilename(filename);
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller marshaller = context.createUnmarshaller();
            return marshaller.unmarshal(new File(filename));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
