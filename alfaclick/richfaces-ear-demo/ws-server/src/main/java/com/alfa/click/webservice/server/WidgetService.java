/**
 * 
 */
package com.alfa.click.webservice.server;

import java.io.InputStream;
import java.util.Date;

import javax.jws.WebService;
import javax.xml.bind.JAXB;

import com.alfa.click.JNDIConstants;

/**
 * @author Aleh Web service endpoint implementation.
 */
@WebService(endpointInterface = "com.alfa.click.webservice.server.IWidgetService")
public class WidgetService implements IWidgetService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.alfa.click.service.IWidgetService#getWidgets()
	 */
	@Override
	public Widgets getWidgets() {
		System.out.println(">> getWidgets called " + new Date());
		InputStream stream = WidgetService.class
				.getResourceAsStream(JNDIConstants.SAMPLE_FILE_LOCATION);
		if (stream == null) {
			System.out.println("Resource was not found "
					+ JNDIConstants.SAMPLE_FILE_LOCATION);
			return new Widgets();
		}
		return JAXB.unmarshal(stream, Widgets.class);
	}
}
