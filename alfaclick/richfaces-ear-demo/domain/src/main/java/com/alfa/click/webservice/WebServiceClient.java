/**
 * 
 */
package com.alfa.click.webservice;

import java.net.MalformedURLException;
import java.net.URL;

import com.alfa.click.JNDIConstants;
import com.alfa.click.webservice.server.WidgetServiceService;

/**
 * @author Aleh
 * 
 */
public class WebServiceClient {

	public static void main(final String args[]) throws MalformedURLException {
		WidgetServiceService service = new WidgetServiceService(new URL(
				JNDIConstants.WEB_SERVICE_URL));
		System.out.println(service.getWidgetServicePort().getWidgets().getWidget().size());
	}

}
