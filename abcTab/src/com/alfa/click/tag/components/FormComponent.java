/**
 *
 */
package com.alfa.click.tag.components;

import java.io.IOException;

import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;

import com.alfa.click.webservice.server.ModeType;

/**
 * @author Aleh
 */
public class FormComponent extends UIOutput {

	/**
	 * 
	 */
	private ModeType modeType;

	/**
	 * <p>
	 * Synthesize and return an {@link } bean for this hotspot, if there is no
	 * <code>valueRef</code> property on this component.
	 * </p>
	 */
	@Override
	public Object getValue() {
		if (super.getValue() == null) {
			setValue(ModeType.SIMPLE);
		}

		return (super.getValue());
	}

	// ----------------------------------------------------- StateHolder Methods

	/**
	 * <p>
	 * Return the state to be saved for this component.
	 * </p>
	 * 
	 * @param context
	 *            <code>FacesContext</code> for the current request
	 */
	@Override
	public Object saveState(final FacesContext context) {
		Object[] values = new Object[5];
		values[0] = super.saveState(context);
		values[1] = modeType;
		return (values);
	}

	/**
	 * <p>
	 * Restore the state for this component.
	 * </p>
	 * 
	 * @param context
	 *            <code>FacesContext</code> for the current request
	 * @param state
	 *            State to be restored
	 * @throws IOException
	 *             if an input/output error occurs
	 */
	@Override
	public void restoreState(final FacesContext context, final Object state) {
		Object[] values = (Object[]) state;
		super.restoreState(context, values[0]);
		modeType = (ModeType) values[1];
	}

	/*
	 * ========================================Do not modify
	 * section========================================
	 */

	@Override
	public String getFamily() {
		return "com.alfa.click.widget.Form";
	}
}