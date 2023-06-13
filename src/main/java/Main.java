import static com.laba.utils.AppConfig.xmlOutputDir;

import com.laba.models.Patient;
import com.laba.models.Person;
import com.laba.utils.HospitalUtils;
import com.laba.utils.xml.XMLParser;
import com.laba.utils.xml.XMLValidator;
import com.laba.utils.xml.jaxb.JAXBUtil;
import java.io.File;
import java.sql.Date;
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

    public static void testJaxb() {
        // call marshall method
        Person p1 = new Person("Dwight", "Schrute", Date.valueOf("2000-01-01"));
        JAXBUtil.marshallOneXmlOut(p1, xmlOutputDir, "Person.xml");

        // call unmarshall method
        String path = xmlOutputDir + "Person.xml";
        File file = new File(path);
        Person p1Unmarshalled = (Person) JAXBUtil.unmarshallOne(Person.class, file);
        Object p1Unmarshalled2 = JAXBUtil.unmarshallOne(Person.class, file);

        // test
        if (p1.equals(p1Unmarshalled) && p1.equals(p1Unmarshalled2)) {
            LOG.info("There's a new sheriff here in these offices and his name is me. -"
                + p1Unmarshalled.getFirstName() + " " + p1.getLastName());
        }
    }

    public static void iter3iter4Demo() {
        String xmlFilePath = "src/main/resources/XML/hospital.xml";
        String xsdFilePath = "src/main/resources/XML/hospitalschema.xsd";
        File xmlFile = new File(xmlFilePath);
        File xsdFile = new File(xsdFilePath);
        testXMLAndXSDParserValidator(xmlFile, xsdFile);
        testJaxb();
    }

    public static void main(String[] args) {
        Patient patient = new Patient(1, 1);
        HospitalUtils.getXmlPatientMedicalRecords(patient);
        // --> out to export/patient_records/patient_medical_record_patientId_1.xml
        String demoFilePath = "export/patient_records/patient_medical_record_patientId_1.xml";
        HospitalUtils.getJsonPatientMedicalRecordsFromXml(patient, new File(demoFilePath));
        // --> out to export/patient_medical_record_patientId_1.json
    }
}
