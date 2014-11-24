package com.alfa.click;

import javax.xml.ws.Endpoint;

import com.alfa.click.webservice.server.WidgetService;

/**
 * @author Aleh
 *
 */
public class EndpointPublisher {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		Endpoint.publish(JNDIConstants.WEB_SERVICE_URL, new WidgetService());
	}
}