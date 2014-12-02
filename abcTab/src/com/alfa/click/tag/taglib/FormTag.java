package com.alfa.click.tag.taglib;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.webapp.UIComponentELTag;

/**
 * @author Aleh
 */
public class FormTag extends UIComponentELTag {

	/**
     *
     */
	private ValueExpression mode;

	/**
	 * 
	 */
	private ValueExpression paramid;

	/**
	 * 
	 */
	private ValueExpression label;

	/**
	 * 
	 */
	private ValueExpression value;

	/**
	 * 
	 */
	private ValueExpression hint;

	/**
	 * 
	 */
	private ValueExpression type;

	@Override
	public void release() {
		super.release();
		this.mode = null;
		this.paramid = null;
		this.label = null;
		this.value = null;
		this.hint = null;
		this.type = null;
	}

	@Override
	protected void setProperties(final UIComponent component) {
		super.setProperties(component);
		component.setValueExpression("mode", mode);
		component.setValueExpression("paramid", paramid);
		component.setValueExpression("label", label);
		component.setValueExpression("value", value);
		component.setValueExpression("hint", hint);
		component.setValueExpression("type", type);
	}

	/**
	 * @return
	 */
	public ValueExpression getMode() {
		return mode;
	}

	/**
	 * @param mode
	 */
	public void setMode(final ValueExpression mode) {
		this.mode = mode;
	}

	/**
	 * @return the paramid
	 */
	public final ValueExpression getParamid() {
		return paramid;
	}

	/**
	 * @param paramid
	 *            the paramid to set
	 */
	public final void setParamid(final ValueExpression paramid) {
		this.paramid = paramid;
	}

	/**
	 * @return the label
	 */
	public final ValueExpression getLabel() {
		return label;
	}

	/**
	 * @param label
	 *            the label to set
	 */
	public final void setLabel(final ValueExpression label) {
		this.label = label;
	}

	/**
	 * @return the value
	 */
	public final ValueExpression getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public final void setValue(final ValueExpression value) {
		this.value = value;
	}

	/**
	 * @return the hint
	 */
	public final ValueExpression getHint() {
		return hint;
	}

	/**
	 * @param hint
	 *            the hint to set
	 */
	public final void setHint(final ValueExpression hint) {
		this.hint = hint;
	}

	/**
	 * @return the type
	 */
	public final ValueExpression getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public final void setType(final ValueExpression type) {
		this.type = type;
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