package com.corejsf;

public class ZipCodeDirectory {
    public String getCityAndStateForZip(String zip) {
        return "97402".equals(zip) ? "Eugene,Oregon" : "NO DATA,NO DATA";
    }
}
