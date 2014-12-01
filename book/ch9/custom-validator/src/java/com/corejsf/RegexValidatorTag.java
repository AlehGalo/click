package com.corejsf;

import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.webapp.ValidatorELTag;
import javax.servlet.jsp.JspException;

public class RegexValidatorTag extends ValidatorELTag {
   private ValueExpression expression;
   private ValueExpression errorSummary;
   private ValueExpression errorDetail;

   public void setExpression(ValueExpression newValue) { 
      expression = newValue;
   } 

   public void setErrorSummary(ValueExpression newValue) { 
      errorSummary = newValue;
   } 

   public void setErrorDetail(ValueExpression newValue) { 
      errorDetail = newValue;
   } 

   public Validator createValidator() throws JspException {
      RegexValidator validator = new RegexValidator();
      ELContext elContext = FacesContext.getCurrentInstance().getELContext();      
      
      validator.setExpression((String) expression.getValue(elContext));
      if (errorSummary != null)
         validator.setErrorSummary((String) errorSummary.getValue(elContext));
      if (errorDetail != null)
         validator.setErrorDetail((String) errorDetail.getValue(elContext));

      return validator;
   }

   public void release() {
      expression = null;
      errorSummary = null;
      errorDetail = null;
   }
 }
