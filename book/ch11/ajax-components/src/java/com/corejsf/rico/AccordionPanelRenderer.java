package com.corejsf.rico;

import javax.faces.render.Renderer;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.component.UIComponent;
import java.io.IOException;
import java.util.Map;

public class AccordionPanelRenderer extends Renderer {
    // For each panel, write out three DIVS that look like this:
    // <div>
    //
    //    <div>
    //       Item's label goes here
    //    </div>
    //
    //    <div>
    //       Included content (represented by the item's
    //       label) goes here
    //    </div>
    //
    // </div>
    public void encodeBegin(FacesContext fc,
                               UIComponent component)
            throws IOException {
        // heading and styleClass attributes come from the component
        Map<String, Object> attrs = component.getAttributes();
        String heading = (String)attrs.get("heading");
        String styleClass = (String)attrs.get("styleClass");

        // headerClass and contentClass attributes
        // come from the component's parent
        Map<String, Object> parentAttrs = component.getParent().getAttributes();
        String headerClass = (String)parentAttrs.get("headerClass");
        String contentClass = (String)parentAttrs.get("contentClass");

        ResponseWriter writer = fc.getResponseWriter();

        startEnclosingDiv(writer, styleClass); // DIV closed in encodeEnd()
        encodeHeaderDiv(writer, heading, headerClass); // DIV complete
        startContentDiv(writer, contentClass); // DIV closed in encodeEnd()
    }
    public void encodeEnd(FacesContext fc,
                          UIComponent component)
            throws IOException {
        ResponseWriter writer = fc.getResponseWriter();
        // Finish enclosing DIVs started in encodeBegin()
        writer.write("</div>"); // content DIV
        writer.write("</div>"); // enclosing DIV
    }
    public boolean getRendersChildren() {
        return false;
    }
    private void startEnclosingDiv(ResponseWriter writer,
                                   String cssClass)
        throws java.io.IOException {
        // Write out the opening tag for the enclosing div...
        writer.write("<div");
        if (cssClass != null)
           writer.write(" class='" + cssClass + "'");
        writer.write(">");
    }
    private void encodeHeaderDiv(ResponseWriter writer,
                                   String heading,
                                   String cssClass)
        throws java.io.IOException {
        // Write out the header div
        // (both opening and closing DIVs)...
        writer.write("<div");
        if (cssClass != null)
           writer.write(" class='" + cssClass + "'");
        writer.write(">");
        writer.write(heading);
        writer.write("</div>");
    }
    private void startContentDiv(ResponseWriter writer,
                                   String cssClass)
        throws java.io.IOException {
        // Write out the opening tag for the content div...
        writer.write("<div");
        if (cssClass != null)
           writer.write(" class='" + cssClass + "'");
        writer.write(">");
    }
}
