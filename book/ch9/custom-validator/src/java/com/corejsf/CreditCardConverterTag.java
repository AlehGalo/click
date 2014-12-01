package com.corejsf;

import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.webapp.ConverterELTag;
import javax.servlet.jsp.JspException;

public class CreditCardConverterTag extends ConverterELTag {
   private ValueExpression separator;

   public void setSeparator(ValueExpression newValue) { 
      separator = newValue; 
   } 

   public Converter createConverter() throws JspException {
      CreditCardConverter converter = new CreditCardConverter();           
      ELContext elContext = FacesContext.getCurrentInstance().getELContext();      
      converter.setSeparator((String) separator.getValue(elContext));
      return converter;
   }

   public void release() {
      separator = null;
   }
}
