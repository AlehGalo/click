package com.corejsf;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.webapp.UIComponentELTag;

public class ChartTag extends UIComponentELTag {
   private ValueExpression width;
   private ValueExpression height;
   private ValueExpression title;
   private ValueExpression names;
   private ValueExpression values;
   
   public void setWidth(ValueExpression newValue) { width = newValue; }
   public void setHeight(ValueExpression newValue) { height = newValue; }
   public void setTitle(ValueExpression newValue) { title = newValue; }
   public void setNames(ValueExpression newValue) { names = newValue; }
   public void setValues(ValueExpression newValue) { values = newValue; }
   
   public void setProperties(UIComponent component) { 
      super.setProperties(component); 
      component.setValueExpression("width", width);
      component.setValueExpression("height", height);
      component.setValueExpression("title", title);
      component.setValueExpression("names", names);
      component.setValueExpression("values", values);
   }
   
   public void release() {
      super.release();
      width = null;
      height = null;
      title = null;
      names = null;
      values = null;
   }   
   
   public String getRendererType() { return "com.corejsf.Chart"; } 
   public String getComponentType() { return "com.corejsf.Chart"; }  
}
