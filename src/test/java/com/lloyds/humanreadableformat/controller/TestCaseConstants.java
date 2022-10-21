package com.lloyds.humanreadableformat.controller;

import java.util.HashMap;
import java.util.Map;

public class TestCaseConstants {
    public static Map<String, String> tstMap;
    static {
        tstMap = new HashMap<>();
        tstMap.put("16:30","Half past four");
        tstMap.put("01:00","One o'clock");
        tstMap.put("02:00","Two o'clock");
        tstMap.put("13:00","One o'clock");
        tstMap.put("03:05","Five past three");
        tstMap.put("13:10","Ten past one");
        tstMap.put("13:25","Twenty-five past one");
        tstMap.put("13:30","Half past one");
        tstMap.put("13:35","Twenty-five to two");
        tstMap.put("13:55","Five to two");

    }

}
