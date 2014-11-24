/**
 * 
 */
package com.alfa.click.component;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.webapp.UIComponentELTag;

/**
 * @author Aleh
 * 
 */
public class WidgetPanelTag extends UIComponentELTag {

	/**
	 * 
	 */
	public static final String COMPONENT_TYPE = "com.alfa.click.component.UIWidgetPanelComponent";

	/**
	 * 
	 */
	public static final String RENDERER_TYPE = "com.alfa.click.component.renderer.WidgetPanelRenderer";

	/**
	 * 
	 */
	private ValueExpression mode;

	/**
	 * 
	 */
	private ValueExpression widget;

	/**
	 * 
	 */
	public WidgetPanelTag() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.faces.webapp.UIComponentTagBase#getComponentType()
	 */
	@Override
	public String getComponentType() {
//		return COMPONENT_TYPE;
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.faces.webapp.UIComponentTagBase#getRendererType()
	 */
	@Override
	public String getRendererType() {
//		return RENDERER_TYPE;
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.faces.webapp.UIComponentELTag#release()
	 */
	@Override
	public void release() {
		super.release();
		mode = null;
		widget = null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.faces.webapp.UIComponentELTag#setProperties(javax.faces.component
	 * .UIComponent)
	 */
	@Override
	protected void setProperties(final UIComponent component) {
		super.setProperties(component);
		processProperty(component, mode, WidgetPanelComponent.MODE_ATTRIBUTE_KEY);
		processProperty(component, widget, WidgetPanelComponent.WIDGET_ATTRIBUTE_KEY);
		// ((Shuffler) component).setShuffleListener(shuffleListener);
		// ((Shuffler) component).setShuffleProcessor(shuffleProcessor);
	}

	/**
	 * @param component
	 * @param property
	 * @param propertyName
	 */
	protected final void processProperty(final UIComponent component,
			final ValueExpression property, final String propertyName) {
		if (property != null) {
			if (property.isLiteralText()) {
				component.getAttributes().put(propertyName, property.getExpressionString());
			} else {
				component.setValueExpression(propertyName, property);
			}
		}
	}

	/**
	 * @return the mode
	 */
	public final ValueExpression getMode() {
		return mode;
	}

	/**
	 * @param mode
	 *            the mode to set
	 */
	public final void setMode(final ValueExpression mode) {
		this.mode = mode;
	}

	/**
	 * @return the widget
	 */
	public final ValueExpression getWidget() {
		return widget;
	}

	/**
	 * @param widget
	 *            the widget to set
	 */
	public final void setWidget(final ValueExpression widget) {
		this.widget = widget;
	}
}
