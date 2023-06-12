package com.laba.utils.json;

import static com.laba.utils.AppConfig.jsonOutputDir;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.FileWriter;
import java.io.IOException;

public class JacksonUtil {
    private static final String OUTPUT_DIR = jsonOutputDir;
    private static final String FILE_EXTENSION_JSON = ".json";


    public static void toJsonFile(Object obj, String filename){
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
