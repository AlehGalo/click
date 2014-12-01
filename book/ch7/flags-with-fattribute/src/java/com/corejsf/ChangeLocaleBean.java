package com.corejsf;

import java.util.Locale;
import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

public class ChangeLocaleBean {
   public void changeLocale(ActionEvent event) {
		UIComponent component = event.getComponent();
      String languageCode = getLanguageCode(component);
      FacesContext.getCurrentInstance()
			 .getViewRoot().setLocale(new Locale(languageCode));
   }
	private String getLanguageCode(UIComponent component) {
		Map<String, Object> attrs = component.getAttributes();
		return (String) attrs.get("languageCode");
   }
}
