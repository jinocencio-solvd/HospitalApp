package com.laba.utils;

import java.util.HashMap;
import java.util.Map;

public class DbMapper {

    private static String interfaceLoc = "com/laba/interfaces/daos/";

    private static Map<String, String> personPropColMap = new HashMap<>(Map.of(
        "type", "Person",
        "namespace", interfaceLoc + "IPersonDAO",
        "field_firstName", "first_name",
        "field_lastName", "last_name",
        "field_dob", "dob"
    ));

    public static Map<String, Map<String, String>> getPropertyColumnMap(){
        Map<String, Map<String, String>> propColMap = new HashMap<>();
        propColMap.put("person", personPropColMap);
        return propColMap;
    }
}
