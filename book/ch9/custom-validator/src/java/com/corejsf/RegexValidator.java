package com.corejsf;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class RegexValidator implements Validator, Serializable {
   private String expression;
   private Pattern pattern;
   private String errorSummary;
   private String errorDetail;

   public void validate(FacesContext context, UIComponent component, 
         Object value) {
      if (value == null) return;
      if (pattern == null) return;
      if(!pattern.matcher(value.toString()).matches()) {
         Object[] params = new Object[] { expression, value };
         Locale locale = context.getViewRoot().getLocale();
         FacesMessage message = com.corejsf.util.Messages.getMessage(
               "com.corejsf.messages", "badRegex", params);
         if (errorSummary != null)
            message.setSummary(
                  new MessageFormat(errorSummary, locale).format(params));
         if (errorDetail != null)
            message.setDetail(
                  new MessageFormat(errorDetail, locale).format(params));
         throw new ValidatorException(message);
      }
   }

   // PROPERTY: expression
   public void setExpression(String newValue) {
      expression = newValue;
      pattern = Pattern.compile(expression);
   }

   // PROPERTY: errorSummary
   public void setErrorSummary(String newValue) {
      errorSummary = newValue;
   }
   
   // PROPERTY: errorDetail
   public void setErrorDetail(String newValue) {
      errorDetail = newValue;
   }
}
