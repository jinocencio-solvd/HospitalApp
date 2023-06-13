package com.laba.utils;

import com.laba.utils.xml.XMLParser;
import java.io.File;
import java.util.List;
import java.util.Map;

public class AppUtils {

    public static final String DB_XML_PATH = "src/main/resources/XML/hospital.xml";

    public static Map<String, List<Map<String, String>>> getHospitalDbMapFromXml() {
        return XMLParser.domParseToMap(new File(DB_XML_PATH));
    }
}
