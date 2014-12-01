package com.corejsf;

public class ZipcodeDatabase {
    public static String getCityAndState(String zip) {
        if ("97402".equals(zip))
            return "Eugene,Oregon";
        else if ("80132".equals(zip))
            return "Monument,Colorado";
        else
            return null;
    }
}
