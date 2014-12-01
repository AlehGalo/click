package com.corejsf;

import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

public class Util {
    public static PrintWriter getResponseWriter(FacesContext fc) {
        PrintWriter writer = null;
        try {
            writer = getResponse(fc).getWriter();
        }
        catch (java.io.IOException ex) {
            ex.printStackTrace();
        }
        return writer;
    }

    public static UIComponent findComponent(FacesContext fc, String clientId) {
        return fc.getViewRoot().findComponent(clientId);
    }

    public static String getRequestParam(FacesContext fc, String name) {
        Map<String, String> requestParams = fc.getExternalContext()
             .getRequestParameterMap();
        return (String)requestParams.get(name);
    }

    public static HttpServletResponse getResponse(FacesContext fc) {
        return (HttpServletResponse)fc.getExternalContext()
                                      .getResponse();
    }
}
