package com.corejsf;

import java.io.IOException;
import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.Renderer;

public class ChartRenderer extends Renderer {
   private static final int DEFAULT_WIDTH = 200;
   private static final int DEFAULT_HEIGHT = 200;   
   
   public void encodeBegin(FacesContext context, UIComponent component) 
      throws IOException {
      if (!component.isRendered()) return;

      Map<String, Object> attributes = component.getAttributes();
      Integer width = (Integer) attributes.get("width");
      if (width == null) width = DEFAULT_WIDTH;
      Integer height = (Integer) attributes.get("height");
      if (height == null) height = DEFAULT_HEIGHT;
      String title = (String) attributes.get("title");
      if (title == null) title = "";
      String[] names = (String[]) attributes.get("names");
      double[] values = (double[]) attributes.get("values");
      if (names == null || values == null) return;

      ChartData data = new ChartData();
      data.setWidth(width);
      data.setHeight(height);
      data.setTitle(title);
      data.setNames(names);
      data.setValues(values);
      
      String id = component.getClientId(context);
      ExternalContext external 
            = FacesContext.getCurrentInstance().getExternalContext();
      Map<String, Object> session = external.getSessionMap();
      session.put(id, data);

      ResponseWriter writer = context.getResponseWriter();
      writer.startElement("img", component);
      
      writer.writeAttribute("width", width, null);
      writer.writeAttribute("height", height, null);
      String path = external.getRequestContextPath();
      writer.writeAttribute("src", path + "/BinaryServlet?id=" + id, null);
      writer.endElement("img");
      
      context.responseComplete();
   }
}
