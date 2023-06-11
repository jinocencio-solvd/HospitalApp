package com.laba.utils.xml.jaxb;

import static com.laba.utils.AppConfig.xmlOutputDir;

import com.sun.xml.txw2.output.IndentingXMLStreamWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class JAXBUtil {

    public static void marshallManyXmlOut(List<?> objList) {
        Class<?> objClass = objList.get(0).getClass();
        try {
            String path = xmlOutputDir + objClass.getSimpleName() + ".xml";
            OutputStream outPath = new FileOutputStream(path);
            String parentTagName = objClass.getSimpleName().toLowerCase() + "_parent";

            JAXBContext context = JAXBContext.newInstance(objClass);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);

            XMLOutputFactory xof = XMLOutputFactory.newFactory();
            XMLStreamWriter xsw = new IndentingXMLStreamWriter(
                xof.createXMLStreamWriter(outPath, "UTF-8"));

            xsw.writeStartDocument("UTF-8", "1.0");
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

    public static void marshallOneXmlOut(Object obj) {
        try {
            Class<?> objClass = obj.getClass();
            JAXBContext context = JAXBContext.newInstance(objClass);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            String path = xmlOutputDir + objClass.getSimpleName() + ".xml";
            marshaller.marshal(obj, new File(path));
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
