package com.corejsf;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.faces.model.SelectItem;

public class RegisterForm {
   enum Education { HIGH_SCHOOL, BACHELOR, MASTER, DOCTOR };

   private String name;
   private boolean contactMe;
   private Integer[] bestDaysToContact;
   private Integer yearOfBirth;
   private String[] colors;
   private String[] languages;
   private Education education;

   // PROPERTY: name
   public String getName() {
      return name;
   }
   public void setName(String newValue) {
      name = newValue;
   }

   // PROPERTY: contactMe
   public boolean getContactMe() {
      return contactMe;
   }
   public void setContactMe(boolean newValue) {
      contactMe = newValue;
   }

   // PROPERTY: bestDaysToContact
   public Integer[] getBestDaysToContact() {
      return bestDaysToContact;
   }
   public void setBestDaysToContact(Integer[] newValue) {
      bestDaysToContact = newValue;
   }

   // PROPERTY: yearOfBirth
   public Integer getYearOfBirth() {
      return yearOfBirth;
   }
   public void setYearOfBirth(Integer newValue) {
      yearOfBirth = newValue;
   }

   // PROPERTY: colors
   public String[] getColors() {
      return colors;
   }
   public void setColors(String[] newValue) {
      colors = newValue;
   }

   // PROPERTY: languages
   public String[] getLanguages() {
      return languages;
   }
   public void setLanguages(String[] newValue) {
      languages = newValue;
   }

   // PROPERTY: education
   public Education getEducation() {
      return education;
   }
   
   public void setEducation(Education newValue) {
      education = newValue;
   }

   // PROPERTY: yearItems
   public Collection<SelectItem> getYearItems() {
      return birthYears;
   }

   // PROPERTY: daysOfTheWeekItems
   public SelectItem[] getDaysOfTheWeekItems() {
      return daysOfTheWeek;
   }

   // PROPERTY: languageItems
   public Map<String, Object> getLanguageItems() {
      return languageItems;
   }
   
   // PROPERTY: colorItems
   public SelectItem[] getColorItems() {
      return colorItems;
   }
   
   // PROPERTY: educationItems
   public SelectItem[] getEducationItems() {
      return educationItems;
   }
   
   // PROPERTY: bestDaysConcatenated
   public String getBestDaysConcatenated() {
      return concatenate(bestDaysToContact);
   }

   // PROPERTY: languagesConcatenated
   public String getLanguagesConcatenated() {
      return concatenate(languages);
   }

   // PROPERTY: colorsConcatenated
   public String getColorsConcatenated() {
      return concatenate(colors);
   }

   private static String concatenate(Object[] values) {
      if (values == null)
         return "";
      StringBuilder r = new StringBuilder();
      for (Object value : values) {
         if (r.length()> 0)
            r.append(',');
         r.append(value.toString());
      }
      return r.toString();
   }

   private static SelectItem[] colorItems = {
      new SelectItem("Red"),
      new SelectItem("Blue"),
      new SelectItem("Yellow"),
      new SelectItem("Green"),
      new SelectItem("Orange") 
   };

   private static SelectItem[] educationItems = {
      new SelectItem(Education.HIGH_SCHOOL, "High School"),
      new SelectItem(Education.BACHELOR, "Bachelor's"),
      new SelectItem(Education.MASTER, "Master's"),
      new SelectItem(Education.DOCTOR, "Doctorate") };

   private static Map<String, Object> languageItems; 
   static {
      languageItems = new LinkedHashMap<String, Object>();
      languageItems.put("English", "en"); // item, value
      languageItems.put("French", "fr");
      languageItems.put("Russian", "ru");            
      languageItems.put("Italian", "it");            
      languageItems.put("Spanish", "es");            
   }
   
   private static Collection<SelectItem> birthYears;
   static {
      birthYears = new ArrayList<SelectItem>();
      for (int i = 1900; i < 2000; ++i) {
         birthYears.add(new SelectItem(i));
      }            
   }
   
   private static SelectItem[] daysOfTheWeek;
   static {
      DateFormatSymbols symbols = new DateFormatSymbols();
      String[] weekdays = symbols.getWeekdays();
      daysOfTheWeek = new SelectItem[7];
      for (int i = Calendar.SUNDAY; i <= Calendar.SATURDAY; i++) {
         daysOfTheWeek[i - 1] = new SelectItem(new Integer(i), weekdays[i]);
      }      
   }
}
