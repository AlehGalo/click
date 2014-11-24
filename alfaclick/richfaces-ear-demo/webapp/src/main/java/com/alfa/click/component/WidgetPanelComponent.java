/**
 * 
 */
package com.alfa.click.component;

import java.util.Collections;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;

import com.alfa.click.webservice.server.ModeType;

/**
 * @author Aleh
 * 
 */
public class WidgetPanelComponent extends UIComponentBase {

	/**
	 * 
	 */
	private static final String FAMILY = "alfa.custom.component";

	/**
	 * 
	 */
	public static final String MODE_ATTRIBUTE_KEY = "styleClass";

	/**
     * 
     */
	public static final String WIDGET_ATTRIBUTE_KEY = "facetOrder";

	@Override
	public Object saveState(final FacesContext facesContext) {
		Object values[] = new Object[5];
		values[0] = super.saveState(facesContext);
		values[1] = this.getAttributes().get(MODE_ATTRIBUTE_KEY);
		values[2] = this.getAttributes().get(WIDGET_ATTRIBUTE_KEY);
		// values[3] = this.shuffleListener;
		// values[4] = this.shuffleProcessor;
		return values;
	}

	@Override
	public void restoreState(final FacesContext facesContext, final Object state) {
		Object values[] = (Object[]) state;
		super.restoreState(facesContext, values[0]);
		this.getAttributes().put(MODE_ATTRIBUTE_KEY, values[1]);
		this.getAttributes().put(WIDGET_ATTRIBUTE_KEY, values[2]);
		// this.setShuffleListener((MethodExpression) values[3]);
		// this.setShuffleProcessor((MethodExpression) values[4]);

	}

	public List<UIComponent> getWidgets(final FacesContext facesContext) {
		ModeType mode = ModeType.valueOf((String) getAttributes().get(
				WidgetPanelComponent.MODE_ATTRIBUTE_KEY));
		UIComponent output = new HtmlOutputText();

		switch (mode) {
		case SIMPLE:
			((HtmlOutputText) output).setValue("Simple");
			break;
		default:
			((HtmlOutputText) output).setValue("Not simple Simple");
			break;
		}
		return Collections.singletonList(output);
		// List<Integer> facetIndexValues = new ArrayList<Integer>();
		// List<String> facetNames = new
		// ArrayList<String>(getFacets().keySet());
		// for (String facetName : facetNames) {
		// facetIndexValues.add(new Integer(facetName));
		// }
		// Collections.sort(facetIndexValues);
		//
		// // create the list of facets corrresponding to the sorted list of
		// facet
		// // index values
		// List<UIComponent> orderedFacets = new ArrayList();
		// for (Integer index : facetIndexValues) {
		// orderedFacets.add(getFacets().get(index.toString()));
		// }
		//
		// // depending on the value for the facetOrder attribute, we may need
		// to
		// // reorganize the orderedFacets list
		// String facetOrder = (String)
		// this.getAttributes().get(Shuffler.FACETORDER_ATTRIBUTE_KEY);
		// if ("reverse".equalsIgnoreCase(facetOrder)) {
		// Collections.reverse(orderedFacets);
		// } else if ("random".equalsIgnoreCase(facetOrder)) {
		// Collections.shuffle(orderedFacets);
		// } else if ("normal".equalsIgnoreCase(facetOrder)) {
		// // need to do nothing as with normal the order returned by
		// // getFacets() is the correct one
		//
		// }
		// // // if a shuffleProcessor is configured, we need to invoke it to
		// // provide
		// // // us with the list of facets in the order in which to render them
		// // // not that strictly speaking the shuffleProcessor can decide to
		// // leave
		// // // out certain facets for whatever reason
		// // if (shuffleProcessor != null) {
		// // try {
		// // Object[] args = { orderedFacets };
		// // orderedFacets = (List<UIComponent>) shuffleProcessor.invoke(
		// // facesContext.getELContext(), args);
		// // } catch (Exception e) {
		// // }
		// //
		// // }
		// return orderedFacets;
	}

	@Override
	public String getFamily() {
		return FAMILY;
	}

}
