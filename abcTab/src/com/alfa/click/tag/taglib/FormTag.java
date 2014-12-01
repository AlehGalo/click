package com.alfa.click.tag.taglib;

import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.webapp.UIComponentELTag;

import com.alfa.click.webservice.server.ModeType;

/**
 * @author Aleh
 */
public class FormTag extends UIComponentELTag {

	/**
     *
     */
	private ValueExpression mode;

	@Override
	public void release() {
		super.release();
		this.mode = null;
	}

	@Override
	protected void setProperties(final UIComponent component) {
		super.setProperties(component);
		component.setValueExpression("mode", mode);
	}

	public ValueExpression getMode() {
		return mode;
	}

	public void setMode(ValueExpression mode) {
		this.mode = mode;
	}

	/*
	 * ========================================Do not modify
	 * section========================================
	 */

	@Override
	public String getComponentType() {
		return "com.alfa.click.tag.FormComponent";
	}

	@Override
	public String getRendererType() {
		return "com.alfa.click.tag.FormRenderer";
	}
}