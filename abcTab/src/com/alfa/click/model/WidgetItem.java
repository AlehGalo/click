/**
 * 
 */
package com.alfa.click.model;

import java.io.Serializable;
import java.math.BigInteger;

import com.alfa.click.webservice.server.ModeType;
import com.alfa.click.webservice.server.SelectItem;
import com.alfa.click.webservice.server.WidgetType;

/**
 * @author Aleh
 * 
 */
public class WidgetItem implements Serializable {

	/**
	 * Default serial version id.
	 */
	private static final long serialVersionUID = 1L;

	protected BigInteger paramid;

	protected WidgetType type;

	protected SelectItem selectItems;

	protected String defaultValue;

	protected String label;

	protected ModeType mode;

	protected String hint;

	/**
	 * 
	 */
	public WidgetItem() {
		// TODO Auto-generated constructor stub
	}

}
