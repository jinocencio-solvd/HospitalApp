import com.laba.enums.DaoType;
import com.laba.models.Appointment;
import com.laba.models.Patient;
import com.laba.models.Person;
import com.laba.models.Profession;
import com.laba.services.AppointmentService;
import com.laba.services.MedicalRecordService;
import com.laba.services.PatientService;
import com.laba.services.PersonService;
import com.laba.services.ProfessionService;
import com.laba.services.SpecializationService;
import com.laba.utils.AppUtils;
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

    public static void main(String[] args) {
        myBatisDemo();
    }

    public static void myBatisDemo() {
        AppUtils.populateDb();

        Runnable getPatientByPersonId = () -> {
            PatientService patientService = new PatientService(DaoType.MYBATIS);
            PersonService personService = new PersonService(DaoType.MYBATIS);
            Patient patient = patientService.getById(1);
            LOG.info(patient);

            Person futurePatient = new Person("p1Patient", "p1Last", Date.valueOf("2000-01-01"));
            personService.save(futurePatient);
            Patient newPatient = new Patient(null, 20);
            patientService.save(newPatient);
            LOG.info(patientService.getById(13));
        };

        Runnable myBatisAndJdbcDaoComparison = () -> {
            List<Person> personList = new PersonService(DaoType.JDBC).getAll();
            List<Person> personListMyBatis = new PersonService(DaoType.MYBATIS).getAll();
            LOG.info("Lists are equal: " + personList.equals(personListMyBatis));

            String spec1 = new SpecializationService(DaoType.JDBC).getById(1).getSpecialization();
            String spec1MyBatis = new SpecializationService(DaoType.MYBATIS).getById(1)
                .getSpecialization();
            LOG.info("Dao retrievals are equal: " + spec1MyBatis.equals(spec1));
        };

        Runnable updateProfession = () -> {
            ProfessionService psMyBatis = new ProfessionService(DaoType.MYBATIS);
            Profession prof1 = psMyBatis.getById(1);
            LOG.info("Retrieved: " + prof1); // Physician
            prof1.setProfession("Physician - Cardiologist");
            psMyBatis.update(prof1);
            LOG.info("Updated: " + prof1); // Physician - Cardiologist
        };

        Runnable getAppointmentsByPatientId = () -> {
            AppointmentService appointmentService = new AppointmentService(DaoType.MYBATIS);
            List<Appointment> listAptPatient1 = appointmentService.getAppointmentsByPatientId(1);
            LOG.info(listAptPatient1);
        };

        getAppointmentsByPatientId.run();
        getPatientByPersonId.run();
        myBatisAndJdbcDaoComparison.run();
        updateProfession.run();
    }

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
        MedicalRecordService medicalRecordService = new MedicalRecordService(DaoType.JDBC);

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
}
