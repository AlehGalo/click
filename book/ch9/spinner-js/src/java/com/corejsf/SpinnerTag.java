package com.corejsf;

import javax.el.MethodExpression;
import javax.el.ValueExpression;
import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.event.MethodExpressionValueChangeListener;
import javax.faces.webapp.UIComponentELTag;

public class SpinnerTag extends UIComponentELTag {
   private ValueExpression minimum = null; 
   private ValueExpression maximum = null; 
   private ValueExpression size = null;
   private ValueExpression value = null;
   private MethodExpression valueChangeListener = null;
   
   public String getRendererType() { return "com.corejsf.Spinner"; }
   public String getComponentType() { return "com.corejsf.Spinner"; }

   public void setMinimum(ValueExpression newValue) { minimum = newValue; }
   public void setMaximum(ValueExpression newValue) { maximum = newValue; }
   public void setSize(ValueExpression newValue) { size = newValue; }
   public void setValue(ValueExpression newValue) { value = newValue; }
   public void setValueChangeListener(MethodExpression newValue)  { 
      valueChangeListener = newValue; 
   }

   public void setProperties(UIComponent component) {
      // always call the superclass method
      super.setProperties(component);
      
      component.setValueExpression("size", size);
      component.setValueExpression("minimum", minimum);
      component.setValueExpression("maximum", maximum);
      component.setValueExpression("value", value);
      if (valueChangeListener != null)
         ((EditableValueHolder) component).addValueChangeListener(
               new MethodExpressionValueChangeListener(valueChangeListener));
   }
   
   public void release() {
      // always call the superclass method
      super.release();

      minimum = null;
      maximum = null;
      size = null;
      value = null;
      valueChangeListener = null;
   }
}

