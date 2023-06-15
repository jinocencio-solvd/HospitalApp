package com.laba.utils.json;

import static com.laba.utils.AppConfig.EXPORT_OUT_DIR;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.laba.enums.FileType;
import com.laba.utils.AppUtils;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JacksonUtil {

    public static final String JACKSON_OUT_DIR = EXPORT_OUT_DIR + "/json/";

    private static String checkFilename(String filename) {
        if (!filename.endsWith(FileType.JSON.getExtension())) {
            filename += FileType.JSON.getExtension();
        }
        return filename;
    }

    public static void dbMapToJson(String filename) {
        Map<String, List<Map<String, String>>> hospitalDbMap = AppUtils.getHospitalDbMapFromXml();
        filename = checkFilename(filename);
        ObjectMapper om = new ObjectMapper();
        om.enable(SerializationFeature.INDENT_OUTPUT);
        om.createObjectNode();
        ObjectNode rootNode = om.createObjectNode();
        ObjectNode dbJson = om.valueToTree(hospitalDbMap);
        rootNode.set("hospital", dbJson);
        try {
            String filepath = JACKSON_OUT_DIR + filename;
            om.writeValue(new File(filepath), rootNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void toJsonFile(Object obj, String filename) {
        filename = checkFilename(filename);
        String jsonString = toJsonString(obj);
        String filepath = JACKSON_OUT_DIR + filename;
        try (FileWriter fileWriter = new FileWriter(filepath)) {
            fileWriter.write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String toJsonString(Object obj) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String jsonString = "{}";
        try {
            jsonString = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    public static <T> T fromJsonString(String json, T template) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            template = (T) objectMapper.readValue(json, template.getClass());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return template;
    }
}
