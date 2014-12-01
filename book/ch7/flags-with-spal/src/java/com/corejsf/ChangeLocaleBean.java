package com.corejsf;

import java.util.Locale;
import javax.faces.context.FacesContext;

public class ChangeLocaleBean {
	private String languageCode;

   public String changeLocale() {
      FacesContext context = FacesContext.getCurrentInstance();
      context.getViewRoot().setLocale(new Locale(languageCode));
      return null;
   }
	public void setLanguageCode(String newValue) {
	   languageCode = newValue;
   }
}
