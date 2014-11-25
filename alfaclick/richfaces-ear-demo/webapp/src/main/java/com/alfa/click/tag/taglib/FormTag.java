package com.alfa.click.tag.taglib;

import javax.faces.component.UIComponent;
import javax.faces.webapp.UIComponentELTag;

import com.alfa.click.tag.components.FormComponent;

/**
 * @author Aleh
 * 
 */
public class FormTag extends UIComponentELTag {

	/**
     * 
     */
	private javax.el.ValueExpression mode;

	/**
	 * @return the mode
	 */
	public final javax.el.ValueExpression getMode() {
		return mode;
	}

	/**
	 * @param mode
	 *            the mode to set
	 */
	public final void setMode(final javax.el.ValueExpression mode) {
		this.mode = mode;
	}

	@Override
	public String getComponentType() {
		return "FormString";
	}

	@Override
	public String getRendererType() {
		return "FormString";
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
			form.setValueExpression("mode", mode);
		}
	}
}