package com.corejsf;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.webapp.UIComponentELTag;

public class UploadTag extends UIComponentELTag { 
   private ValueExpression value;
   private ValueExpression target;
   
   public String getRendererType() { return "com.corejsf.Upload"; } 
   public String getComponentType() { return "com.corejsf.Upload"; }  
   
   public void setValue(ValueExpression newValue) { value = newValue; }
   public void setTarget(ValueExpression newValue) { target = newValue; } 
   
   public void setProperties(UIComponent component) { 
      super.setProperties(component); 
      component.setValueExpression("target", target);
      component.setValueExpression("value", value);
   } 

   public void release() {
      super.release();
      value = null;
      target = null;
   }
}
