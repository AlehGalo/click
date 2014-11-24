/**
 * 
 */
package com.alfa.click.service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.alfa.click.webservice.server.Widget;
import com.alfa.click.webservice.server.WidgetServiceService;

/**
 * @author Aleh
 * 
 */
@Named
@RequestScoped
public class WidgetService {

	/**
	 * Web service url.
	 */
	private final static String WEB_SERVICE_URL = "http://localhost:1111/widget/WidgetService?wsdl";

	/**
	 * @return list of widgets or an empty list.
	 */
	public List<Widget> getWidgets() {
		WidgetServiceService service;
		try {
			service = new WidgetServiceService(new URL(WEB_SERVICE_URL));
			return service.getWidgetServicePort().getWidgets().getWidget();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return new ArrayList<Widget>();
	}
}
