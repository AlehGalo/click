<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<f:view>
    <html>
      <head>
          <link href="styles.css" type="text/css" rel="stylesheet"/>
          <title>Address Book</title>
      </head>
      <body>
        <p><div class="heading"><h:outputText value="Edit a contact"
                    styleClass="headingText"/></div>
        <h:form>
            <h:messages/>

            <h:panelGrid columns="2">
                <h:outputText value="Name"/>
                <h:outputText id="name"
                          value="#{selectedContact.name}"/>

                <h:outputText value="Street Address"/>
                <h:panelGroup>
                    <h:inputText id="streetAddress"
                              value="#{selectedContact.streetAddress}"
                               size="25"/>
                    <h:message for="streetAddress"/>
                </h:panelGroup>

                <h:outputText value="City"/>
                <h:panelGroup>
                    <h:inputText id="city"
                              value="#{selectedContact.city}"
                               size="15"/>
                    <h:message for="city"/>
                </h:panelGroup>

                <h:outputText value="State"/>
                <h:panelGroup>
                    <h:inputText id="state"
                              value="#{selectedContact.state}"
                               size="12"/>
                    <h:message for="state"/>
                </h:panelGroup>

                <h:outputText value="Country"/>
                <h:panelGroup>
                    <h:inputText id="country"
                              value="#{selectedContact.country}"
                               size="12"/>
                    <h:message for="country"/>
                </h:panelGroup>

                <h:outputText value=""/>
                <h:panelGroup>
                    <h:commandButton value="Save edits"
                                    action="#{addressBook.edit}"/>
                    <h:commandButton value="Cancel"
                                 immediate="true"
                                    action="cancel"/>
                </h:panelGroup>
            </h:panelGrid>
        </h:form>
      </body>
    </html>
</f:view>