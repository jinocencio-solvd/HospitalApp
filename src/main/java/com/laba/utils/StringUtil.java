package com.laba.utils;

import java.util.Collection;
import java.util.Set;
import org.apache.commons.text.CaseUtils;

public class StringUtil {

    private static String snakeCaseToCamelCase(String snakeStr) {
        return CaseUtils.toCamelCase(snakeStr, true, '_');
    }

    public static String getGetterOrSetterString(String getOrSet, String columnName) {
        return getOrSet + snakeCaseToCamelCase(columnName);
    }

    public static String formatCollectionsString(Collection<String> keySet) {
        return keySet.toString()
            .replace("[", "(")
            .replace("]", ")");
    }

    public static String convertToMyBatisPlaceholder(String input) {
        return "#{" + input + "}";
    }

    public static String camelToSnakeCase(String camelStr) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < camelStr.length(); i++) {
            char currentChar = camelStr.charAt(i);
            if (Character.isUpperCase(currentChar)) {
                if (i > 0) {
                    result.append('_');
                }
                result.append(Character.toLowerCase(currentChar));
            } else {
                result.append(currentChar);
            }
        }
        return result.toString();
    }
}
