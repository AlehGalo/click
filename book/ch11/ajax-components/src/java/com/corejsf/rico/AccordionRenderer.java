package com.corejsf.rico;

import javax.faces.render.Renderer;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.component.UIComponent;
import java.io.IOException;
import java.util.Map;

public class AccordionRenderer extends Renderer {
    private static String ONCE_PER_REQUEST_TOKEN =
        "com.corejsf.rico.ACCORDION_REQUEST_TOKEN";

    public void encodeBegin(FacesContext fc,
                          UIComponent component)
            throws IOException {
        ResponseWriter writer = fc.getResponseWriter();
        processScriptsOncePerRequest(fc, writer);
        writeEnclosingDiv(fc, component, writer);
    }
    public void encodeEnd(FacesContext fc,
                          UIComponent component)
            throws IOException {
        ResponseWriter writer = fc.getResponseWriter();
        finishEnclosingDiv(writer);
        encodeRicoJavaScript(component, writer);
    }
    private void finishEnclosingDiv(ResponseWriter writer)
        throws java.io.IOException {
        // Finish enclosing DIV started in encodeBegin()
        writer.write("</div>");
    }
    private void encodeRicoJavaScript(UIComponent component,
                                      ResponseWriter writer)
        throws java.io.IOException {
        // Write the JS that creates the Rico Accordian component
        Map accordionAttributes = component.getAttributes();
        String div = (String)accordionAttributes.get("name");

        writer.write("<script type='text/javascript'>");
        writer.write("new Rico.Accordion( $('" + div + "'), ");
        writeAccordionAttributes(writer, accordionAttributes);
        writer.write(");");
        writer.write("</script>");
    }
    public boolean getRendersChildren() {
        return false;
    }
    private void processScriptsOncePerRequest(FacesContext fc, ResponseWriter writer)
        throws java.io.IOException {
        // write the script for loading the Rico JS file
        if ( ! scriptsHaveBeenProcessed(fc) ) {           // only process
            writer.write("<script type='text/javascript'" // scripts once per request;
                                + "src='rico-script.jsf'>"
                        + "</script>");
        }
    }
    private void writeEnclosingDiv(FacesContext fc, UIComponent component,
                                   ResponseWriter writer)
        throws java.io.IOException {
        // The id of the DIV, specified in a JSP page
        // with a tag attribute, is significant: it's used
        // by encodeEnd() to wire the DIV to a Rico component
        Map attrs = component.getAttributes();
        String styleClass = (String)attrs.get("styleClass");

        writer.write("<div id='" + (String)attrs.get("name") + "'");

        if (styleClass != null) {
            writer.write(" class='" + styleClass + "' ");
        }
        writer.write(">");
    }
    private void writeAccordionAttributes(ResponseWriter writer,
                                          Map attrs) {
        try {
            // Add more Accordion's properties here.
            // See rico-1.1.2.js, line 179.
            writer.write(" { ");
            writer.write("   panelHeight: " + attrs.get("panelHeight"));
            writer.write(" } ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private boolean scriptsHaveBeenProcessed(FacesContext fc) {
        Map requestAttributes = fc.getExternalContext().getRequestMap();
        boolean processed = true;

        if ( ! requestAttributes.containsKey(ONCE_PER_REQUEST_TOKEN)) {
            processed = false;
            requestAttributes.put(ONCE_PER_REQUEST_TOKEN, "processed");
        }
        return processed;
    }
}
