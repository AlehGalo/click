package com.corejsf;

import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.webapp.ValidatorELTag;
import javax.servlet.jsp.JspException;

public class CreditCardValidatorTag extends ValidatorELTag {
   private ValueExpression message;
   private ValueExpression arg;

   public void setMessage(ValueExpression newValue) { 
      message = newValue;
   } 

   public void setArg(ValueExpression newValue) { 
      arg = newValue;
   } 
   
   public Validator createValidator() throws JspException {
      CreditCardValidator validator = new CreditCardValidator();
      ELContext elContext = FacesContext.getCurrentInstance().getELContext();      
      
      validator.setMessage((String) message.getValue(elContext));
      validator.setArg((String) arg.getValue(elContext));

      return validator;
   }

   public void release() {
      message = null;
      arg = null;
   }
}
