/**
 * 
 */
package com.alfa.click.service;

import static com.alfa.click.JNDIConstants.WEB_SERVICE_URL;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.alfa.click.webservice.server.Widget;
import com.alfa.click.webservice.server.WidgetServiceService;

/**
 * @author Aleh
 * 
 */
public class WebServiceFacade implements Serializable {

	/**
	 * Default serial version id.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @return
	 */
	public List<Widget> getWidgetList() {
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
