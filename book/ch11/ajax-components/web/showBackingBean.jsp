<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<f:view>
    <f:loadBundle basename="com.corejsf.messages" var="msgs"/>
    <html>
      <head><title>Show Backing Bean</title></head>
      <body>
        <h:form>
            <h:panelGrid columns="2">
                <h:outputText value="#{msgs.cityPrompt}"/>
                <h:outputText value="#{bb.city}"/>

                <h:outputText value="#{msgs.statePrompt}"/>
                <h:outputText value="#{bb.state}"/>

                <h:outputText value="#{msgs.zipPrompt}"/>
                <h:outputText value="#{bb.zip}"/>
            </h:panelGrid>
        </h:form>
      </body>
    </html>
</f:view>