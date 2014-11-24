/**
 * 
 */
package com.alfa.click.component.renderer;

import java.io.IOException;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import com.alfa.click.component.WidgetPanelComponent;

/**
 * @author Aleh
 * 
 */
public class WidgetPanelRenderer extends BasicRenderer {

	@Override
	public void encodeBegin(final FacesContext context, final UIComponent component)
			throws IOException {
		super.encodeBegin(context, component);
		List<UIComponent> components = ((WidgetPanelComponent) component).getWidgets(context);
		for (UIComponent facet : components) {
			facet.encodeAll(context);
		}
	}
}