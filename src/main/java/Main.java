import com.laba.utils.xml.XMLParser;
import com.laba.utils.xml.XMLValidator;
import java.io.File;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger LOG = LogManager.getLogger(Main.class);

    private static void testXMLAndXSDParserValidator(File xmlFile, File xsdFile) {
        if (XMLValidator.isValidXML(xmlFile, xsdFile)) {
            LOG.info("Validation Successful");

            Map<String, List<Map<String, String>>> XMLMap = XMLParser.domParseToMap(xmlFile);
            String name = XMLMap.get("persons").get(3).get("first_name") + " " +
                XMLMap.get("persons").get(3).get("last_name");

            List<Map<String, String>> personsList = XMLParser.domParseElementToList(xmlFile,
                "person");
            String name2 = personsList.get(5).get("first_name") + " " +
                personsList.get(5).get("last_name");

            if (!name.equals(name2) &&
                name.equals("Jim Halpert") &&
                name2.equals("Dwight Schrute")) {
                LOG.info("Identity theft is not a joke Jim!");
            } else {
                LOG.info("Go watch The Office");
            }
        } else {
            LOG.info("Validation Failed");
        }
    }

    public static void main(String[] args) {
        String xmlFilePath = "src/main/resources/XML/hospital.xml";
        String xsdFilePath = "src/main/resources/XML/hospitalschema.xsd";
        File xmlFile = new File(xmlFilePath);
        File xsdFile = new File(xsdFilePath);
        testXMLAndXSDParserValidator(xmlFile, xsdFile);
    }
}
