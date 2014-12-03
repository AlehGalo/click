/**
 * 
 */
package com.alfa.click.webservice.server;

import java.net.MalformedURLException;
import java.net.URL;

import com.alfa.click.webservice.server.WidgetServiceService;

/**
 * @author Aleh
 * 
 */
public class WebServiceClient {

	public static void main(final String args[]) throws MalformedURLException {
		WidgetServiceService service = new WidgetServiceService(new URL(
				"http://localhost:8080/widget/WidgetService?wsdl"));
		System.out.println(service.getWidgetServicePort().getWidgets().getWidget().size());
	}

}
