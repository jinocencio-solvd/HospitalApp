import com.laba.utils.XMLParser;
import com.laba.utils.XMLValidator;
import java.io.File;

public class Main {

    public static void testDomParserToLogger(File xmlFile) {
        XMLParser.domParserToLogger(xmlFile);
    }

    public static void testDomParserByElementToLogger(File xmlFile, String elementName) {
        XMLParser.domParserByElementToLogger(xmlFile, elementName);
    }

    public static boolean testXMLValidator(File xmlFile, File xsdFile) {
        return XMLValidator.isValidXML(xmlFile, xsdFile);
    }

    public static void main(String[] args) {
        String xmlFilePath = "src/main/resources/XML/hospital.xml";
        String xsdFilePath = "src/main/resources/XML/hospitalschema.xsd";
        File xmlFile = new File(xmlFilePath);
        File xsdFile = new File(xsdFilePath);

        boolean isXmlValid = testXMLValidator(xmlFile, xsdFile);
        if(isXmlValid){
            testDomParserToLogger(xmlFile);
            testDomParserByElementToLogger(xmlFile, "medication");
            testDomParserByElementToLogger(xmlFile, "treatment");
            testDomParserByElementToLogger(xmlFile, "person");
        }
    }
}
