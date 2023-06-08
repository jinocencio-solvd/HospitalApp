package com.laba.utils;

import static org.testng.Assert.*;

import java.util.HashSet;
import java.util.Set;
import org.testng.annotations.Test;

public class StringUtilTest {

    @Test
    public void testSnakeToCamelConcat() {
        assertEquals(StringUtil.getGetterOrSetterString("get", "col_name"), "getColName");
        assertEquals(StringUtil.getGetterOrSetterString("set", "col_name"), "setColName");
        assertEquals(StringUtil.getGetterOrSetterString("get", "Id"), "getId");
        assertEquals(StringUtil.getGetterOrSetterString("set", "Id"), "setId");
    }

    @Test
    public void testFormatKeySetString() {
        Set<String> set = new HashSet<>();
        for (char i = 'a'; i <= 'e'; i++) {
            set.add(String.valueOf(i));
        }
        assertEquals("(a, b, c, d, e)", StringUtil.formatKeySetString(set));
    }
}
