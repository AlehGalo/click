/**
 * 
 */
package com.alfa.click.service;

import java.io.Serializable;
import java.math.BigInteger;

import com.alfa.click.webservice.server.Widget;

/**
 * @author Aleh
 * 
 */
public class WidgetController implements Serializable {

	/**
	 * Default serial version id.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * If of the widget provided in the request.
	 */
	private int widgetId;

	/**
	 * 
	 */
	private WidgetService widgetService;

	/**
	 * @param widgetService
	 *            the widgetService to set
	 */
	public final void setWidgetService(final WidgetService widgetService) {
		this.widgetService = widgetService;
	}

	/**
	 * @return the widget
	 */
	public final Widget getWidget() {
		return widgetService.getWidget(BigInteger.valueOf(widgetId));
	}

	/**
	 * @return the widgetId
	 */
	public final int getWidgetId() {
		return widgetId;
	}

	/**
	 * @param widgetId
	 *            the widgetId to set
	 */
	public final void setWidgetId(final int widgetId) {
		this.widgetId = widgetId;
	}
}
