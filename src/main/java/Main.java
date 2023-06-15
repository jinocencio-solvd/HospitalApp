import com.laba.models.Patient;
import com.laba.models.Person;
import com.laba.services.MedicalRecordService;
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
        JAXBUtil.marshallOneXmlOut(p1, "Person.xml");

        // call unmarshall method
        String filepath = JAXBUtil.JAXB_OUT_DIR + "Person.xml";
        Person p1Unmarshalled = (Person) JAXBUtil.unmarshallOne(Person.class, filepath);
        Object p1Unmarshalled2 = JAXBUtil.unmarshallOne(Person.class, filepath);

        // test
        if (p1.equals(p1Unmarshalled) && p1.equals(p1Unmarshalled2)) {
            LOG.info("There's a new sheriff here in these offices and his name is me. -"
                + p1Unmarshalled.getFirstName() + " " + p1.getLastName());
        }
    }

    public static void xmlOperationsDemo() {
        String xmlFilePath = "src/main/resources/xml/hospital.xml";
        String xsdFilePath = "src/main/resources/xml/hospitalschema.xsd";
        File xmlFile = new File(xmlFilePath);
        File xsdFile = new File(xsdFilePath);
        testXMLAndXSDParserValidator(xmlFile, xsdFile);
        testJaxb();
    }

    public static void processPatientMedicalRecords() {
        Patient patient = new Patient(1, 1);
        MedicalRecordService medicalRecordService = new MedicalRecordService();

        Runnable dbToXmlOut = () -> {
            medicalRecordService.getXmlPatientMedicalRecords(patient);
            // --> out to export/xml/patient_records/medical_record_patientId_1.xml
        };

        Runnable xmlSerializeToJson = () -> {
            String demoFilePath = "export/xml/patient_records/medical_record_patientId_1.xml";
            medicalRecordService.getJsonPatientMedicalRecordsFromXml(patient, demoFilePath);
            // --> out to export/patient_medical_record_patientId_1.json
        };

        dbToXmlOut.run();
        xmlSerializeToJson.run();
    }


    public static void main(String[] args) {
        processPatientMedicalRecords();
    }
}
