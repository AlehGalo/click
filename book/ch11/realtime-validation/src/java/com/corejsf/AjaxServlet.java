package com.corejsf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import java.io.IOException;

public class AjaxServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException {
        response.setContentType("text/plain");
        response.setHeader("Cache-Control", "no-cache");
        response.setStatus(HttpServletResponse.SC_OK);

        response.getWriter().write(
           getResponseForZip(request.getParameter("zip")));
    }

    private String getResponseForZip(String zip) {
        return "97402".equals(zip) ? "Eugene, Oregon" : "NO DATA, NO DATA";
    }
}
