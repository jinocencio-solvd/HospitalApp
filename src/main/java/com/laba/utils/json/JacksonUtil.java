package com.laba.utils.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JacksonUtil {

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
