<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<f:view>
    <html>
      <head><title>Show Backing Bean</title></head>
      <body>
        <h:form>
            <h:panelGrid columns="1">
                <h:outputText value="Zip code: #{bb.zip}"/>
                <h:outputText value="City:     #{bb.city}"/>
                <h:outputText value="State:    #{bb.state}"/>
            </h:panelGrid>
        </h:form>
      </body>
    </html>
</f:view>