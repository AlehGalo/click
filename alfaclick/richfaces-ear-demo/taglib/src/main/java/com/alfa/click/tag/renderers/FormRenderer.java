/**
 *
 */
package com.alfa.click.tag.renderers;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.Renderer;

import org.slf4j.Logger;

import com.alfa.click.tag.components.FormComponent;

/**
 * @author Aleh
 */
public class FormRenderer extends Renderer {

	/**
	 * Logger.
	 */
	private static final Logger LOGGER = org.slf4j.LoggerFactory
			.getLogger(FormRenderer.class);

	// -------------------------------------------------------- Renderer Methods

	/**
	 * <p>
	 * No decoding is required.
	 * </p>
	 * 
	 * @param context
	 *            <code>FacesContext</code>for the current request
	 * @param component
	 *            <code>UIComponent</code> to be decoded
	 */
	@Override
	public void decode(final FacesContext context, final UIComponent component) {
		if ((context == null) || (component == null)) {
			throw new NullPointerException();
		}
	}

	/**
	 * <p>
	 * No begin encoding is required.
	 * </p>
	 * 
	 * @param context
	 *            <code>FacesContext</code>for the current request
	 * @param component
	 *            <code>UIComponent</code> to be decoded
	 */
	@Override
	public void encodeBegin(final FacesContext context,
			final UIComponent component) throws IOException {
		if ((context == null) || (component == null)) {
			throw new NullPointerException();
		}
	}

	/**
	 * <p>
	 * No children encoding is required.
	 * </p>
	 * 
	 * @param context
	 *            <code>FacesContext</code>for the current request
	 * @param component
	 *            <code>UIComponent</code> to be decoded
	 */
	@Override
	public void encodeChildren(final FacesContext context,
			final UIComponent component) throws IOException {
		if ((context == null) || (component == null)) {
			throw new NullPointerException();
		}
	}

	/**
	 * <p>
	 * Encode this component.
	 * </p>
	 * 
	 * @param context
	 *            <code>FacesContext</code>for the current request
	 * @param component
	 *            <code>UIComponent</code> to be decoded
	 */
	@Override
	public void encodeEnd(final FacesContext context,
			final UIComponent component) throws IOException {
		if ((context == null) || (component == null)) {
			throw new NullPointerException();
		}
		LOGGER.debug("Encooding started");
		FormComponent form = (FormComponent) component;

		ResponseWriter writer = context.getResponseWriter();
		// StringBuffer sb = null;

		writer.startElement("div", form);
		writer.startElement("h1", form);
		writer.write(form.getValue().toString());
		writer.endElement("h1");
		// writer.writeAttribute("alt", iarea.getAlt(), "alt");
		// writer.writeAttribute("coords", iarea.getCoords(), "coords");
		// writer.writeAttribute("shape", iarea.getShape(), "shape");
		// sb = new
		// StringBuffer("document.forms[0]['").append(targetImageId).append("'].src='");
		// sb.append(getURI(context, (String)
		// area.getAttributes().get("onmouseout")));
		// sb.append("'");
		// writer.writeAttribute("onmouseout", sb.toString(), "onmouseout");
		// sb = new
		// StringBuffer("document.forms[0]['").append(targetImageId).append("'].src='");
		// sb.append(getURI(context, (String)
		// area.getAttributes().get("onmouseover")));
		// sb.append("'");
		// writer.writeAttribute("onmouseover", sb.toString(), "onmouseover");
		// sb = new StringBuffer("document.forms[0]['");
		// sb.append(getName(context, area));
		// sb.append("'].value='");
		// sb.append(iarea.getAlt());
		// sb.append("'; document.forms[0].submit()");
		// writer.writeAttribute("onclick", sb.toString(), "value");
		writer.endElement("div");
	}

	// --------------------------------------------------------- Private Methods

	// /**
	// * <p>
	// * Return the calculated name for the hidden input field.
	// * </p>
	// *
	// * @param context
	// * Context for the current request
	// * @param component
	// * Component we are rendering
	// */
	// private String getName(final FacesContext context, UIComponent component)
	// {
	// while (component != null) {
	// if (component instanceof FormComponent) {
	// return (component.getId() + "_current");
	// }
	//
	// component = component.getParent();
	// }
	//
	// throw new IllegalArgumentException();
	// }
	//
	// /**
	// * <p>
	// * Return the path to be passed into JavaScript for the specified value.
	// * </p>
	// *
	// * @param context
	// * Context for the current request
	// * @param value
	// * Partial path to be (potentially) modified
	// */
	// private String getURI(final FacesContext context, final String value) {
	// if (value.startsWith("/")) {
	// return (context.getExternalContext().getRequestContextPath() + value);
	// } else {
	// return (value);
	// }
	// }
}
