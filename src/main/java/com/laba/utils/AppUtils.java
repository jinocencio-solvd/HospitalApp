package com.laba.utils;

import com.laba.utils.xml.XMLParser;
import java.io.File;
import java.util.List;
import java.util.Map;

public class AppUtils {

    public static final String DB_XML_PATH = "src/main/resources/xml/hospital.xml";

    public static Map<String, List<Map<String, String>>> getHospitalDbMapFromXml() {
        return XMLParser.domParseToMap(new File(DB_XML_PATH));
    }

    public static void initializeDb() {
        if (AppConfig.ENVIRONMENT.equals("GH_WORKFLOW")) {
            SQLScriptExecutor.processSQLiteScript("create");
        }
        if (AppConfig.ENVIRONMENT.equals("DEVELOPMENT")) {
            SQLScriptExecutor.processMySqlScript("create");
        }
    }

    public static void populateDb(){
        if (AppConfig.ENVIRONMENT.equals("GH_WORKFLOW")) {
            SQLScriptExecutor.processSQLiteScript("create");
            SQLScriptExecutor.processSQLiteScript("insert");
        }
        if (AppConfig.ENVIRONMENT.equals("DEVELOPMENT")) {
            SQLScriptExecutor.processMySqlScript("create");
            SQLScriptExecutor.processMySqlScript("insert");
        }
    }
}
