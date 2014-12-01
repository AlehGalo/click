package com.corejsf;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.webapp.UIComponentELTag;

public class ValidatorScriptTag extends UIComponentELTag { 
   private ValueExpression functionName;
   
   // PROPERTY: functionName
   public void setFunctionName(ValueExpression newValue) { functionName = newValue; }

   public void setProperties(UIComponent component) { 
      super.setProperties(component); 
      
      component.setValueExpression("functionName", functionName);      
   } 

   public void release() {
      functionName = null;
   }

   public String getRendererType() { return null; } 
   public String getComponentType() { return "com.corejsf.ValidatorScript"; }  
}
