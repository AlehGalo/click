<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<f:view>
    <f:loadBundle basename="com.corejsf.messages" var="msgs"/>
    <html>
      <head>
          <link href="styles.css" type="text/css" rel="stylesheet"/>
          <title>Shale Web flow</title>
      </head>
      <body>
        <h:form>
            <h:commandLink action="dialog:Payment">
                <h:outputText value="#{msgs.payBillPrompt}"/>
            </h:commandLink>
        </h:form>
      </body>
    </html>
</f:view>
