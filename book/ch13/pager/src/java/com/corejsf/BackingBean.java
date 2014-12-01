package com.corejsf;

public class BackingBean {
   private String[] data = java.util.TimeZone.getAvailableIDs();
   public String[] getData() { return data; }
   
   public boolean getDummy() { return false; }
   public void setDummy(boolean b) {} 
}
