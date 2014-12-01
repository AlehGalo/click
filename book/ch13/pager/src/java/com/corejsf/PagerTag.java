package com.corejsf;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.webapp.UIComponentELTag;

public class PagerTag extends UIComponentELTag {
   private ValueExpression showpages;
   private ValueExpression dataTableId;
   private ValueExpression styleClass;
   private ValueExpression selectedStyleClass; 
   
   public String getRendererType() { return "com.corejsf.Pager"; } 
   public String getComponentType() { return "javax.faces.Output"; } 
   
   public void setShowpages(ValueExpression newValue) { showpages = newValue; }
   public void setDataTableId(ValueExpression newValue) { dataTableId = newValue; }  
   public void setStyleClass(ValueExpression newValue) { styleClass = newValue; }
   public void setSelectedStyleClass(ValueExpression newValue) { 
      selectedStyleClass = newValue; 
   }
   
   public void setProperties(UIComponent component) { 
      super.setProperties(component); 
      if (component == null) return;
      component.setValueExpression("showpages", showpages);
      component.setValueExpression("dataTableId", dataTableId);
      component.setValueExpression("styleClass", styleClass);
      component.setValueExpression("selectedStyleClass", selectedStyleClass);
   }
   
   public void release() {
      super.release();
      showpages = null;
      dataTableId = null;
      styleClass = null;
      selectedStyleClass = null;
   }   
}
