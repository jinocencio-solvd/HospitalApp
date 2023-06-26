package com.laba.utils;

import static org.testng.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
        assertEquals("(a, b, c, d, e)", StringUtil.formatCollectionsString(set));
    }

    @Test
    public void testFormatListString2() {
        List<String> list = new ArrayList<>();
        for (char i = 'a'; i <= 'e'; i++) {
            list.add(String.valueOf(i));
        }
        assertEquals("(a, b, c, d, e)", StringUtil.formatCollectionsString(list));
    }
}
