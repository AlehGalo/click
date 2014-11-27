package com.alfa.click.tag.taglib;

import com.alfa.click.tag.components.FormComponent;

import javax.faces.component.UIComponent;
import javax.faces.webapp.UIComponentELTag;

/**
 * @author Aleh
 */
public class FormTag extends UIComponentELTag {

    /**
     *
     */
    private String mode;

    @Override
    public String getComponentType() {
        return "com.alfa.click.tag.FormComponent";
    }

    @Override
    public String getRendererType() {
        return "com.alfa.click.tag.FormRenderer";
    }

    @Override
    public void release() {
        super.release();
        this.mode = null;
    }

    @Override
    protected void setProperties(final UIComponent component) {
        super.setProperties(component);

        FormComponent form = (FormComponent) component;

        if (mode != null) {
            // if (!alt.isLiteralText()) {
            // area.setValueExpression("alt", alt);
            // } else {
            // area.setAlt(alt.getExpressionString());
            // }
//            form.setValueExpression("mode", mode);
            form.getAttributes().put("mode", mode);
        }
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }


}