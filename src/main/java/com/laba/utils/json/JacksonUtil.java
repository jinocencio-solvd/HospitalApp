package com.laba.utils.json;

import static com.laba.utils.AppConfig.jsonOutputDir;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.laba.utils.AppUtils;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JacksonUtil {

    private static final String OUTPUT_DIR = jsonOutputDir;
    private static final String FILE_EXTENSION_JSON = ".json";
    private static Map<String, List<Map<String, String>>> hospitalDbMap = AppUtils.getHospitalDbMapFromXml();

    public static void dbMapToJson(String filename) {
        if (!filename.endsWith(FILE_EXTENSION_JSON)) {
            filename += FILE_EXTENSION_JSON;
        }
        ObjectMapper om = new ObjectMapper();
        om.enable(SerializationFeature.INDENT_OUTPUT);
        om.createObjectNode();
        ObjectNode rootNode = om.createObjectNode();
        ObjectNode dbJson = om.valueToTree(hospitalDbMap);
        rootNode.set("hospital", dbJson);
        try {
            om.writeValue(new File(OUTPUT_DIR + filename), rootNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void toJsonFile(Object obj, String filename) {
        if (!filename.endsWith(FILE_EXTENSION_JSON)) {
            filename += FILE_EXTENSION_JSON;
        }
        String jsonString = toJsonString(obj);
        try (FileWriter fileWriter = new FileWriter(OUTPUT_DIR + filename)) {
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

    public static String toJsonString(Object obj, ObjectMapper objectMapper) {
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
