package com.alfa.click.service;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.collections.CollectionUtils;

import com.alfa.click.webservice.server.Widget;

/**
 * @author Aleh
 * 
 */
public class WidgetService implements Serializable {

	/**
	 * Default serial version id.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private WebServiceFacade webService;

	/**
	 * List of widgets.
	 */
	private List<Widget> widgetList;

	/**
	 * 
	 */
	private Map<BigInteger, Widget> mapCache;

	/**
	 * 
	 */
	@PostConstruct
	private void init() {
		initWidgetList();
		initCache();
	}

	/**
	 * 
	 */
	private void initWidgetList() {
		setWidgetList(webService.getWidgetList());
	}

	/**
	 * 
	 */
	private void initCache() {
		if (mapCache == null) {
			mapCache = new HashMap<BigInteger, Widget>();
		}
		mapCache.clear();
		if (!CollectionUtils.isEmpty(widgetList)) {
			for (Widget widget : widgetList) {
				mapCache.put(widget.getWidgetid(), widget);
			}
		}
	}

	/**
	 * @return the widgetList
	 */
	public final List<Widget> getWidgetList() {
		return widgetList;
	}

	/**
	 * @param widgetList
	 *            the widgetList to set
	 */
	public final void setWidgetList(final List<Widget> widgetList) {
		this.widgetList = widgetList;
	}

	/**
	 * 
	 */
	public void forceUpdate() {
		initWidgetList();
		initCache();
	}

	/**
	 * @param webService
	 *            the webService to set
	 */
	public final void setWebService(final WebServiceFacade webService) {
		this.webService = webService;
	}

	/**
	 * @param id
	 * @return
	 */
	public Widget getWidget(final BigInteger id) {
		return mapCache.get(id);
	}
}
