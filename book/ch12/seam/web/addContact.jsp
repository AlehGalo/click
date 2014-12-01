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
        <p><div class="heading"><h:outputText value="Add a contact to the address book"
                    styleClass="headingText"/></div>
        <h:form>
            <h:messages/>

            <h:panelGrid columns="2">
                <h:outputText value="Name"/>
                <h:panelGroup>
                    <h:inputText id="name"
                              value="#{contact.name}"
                               size="20"/>
                    <h:message for="name"/>
                </h:panelGroup>

                <h:outputText value="Street Address"/>
                <h:panelGroup>
                    <h:inputText id="streetAddress"
                              value="#{contact.streetAddress}"
                               size="25"/>
                    <h:message for="streetAddress"/>
                </h:panelGroup>

                <h:outputText value="City"/>
                <h:panelGroup>
                    <h:inputText id="city"
                              value="#{contact.city}"
                               size="15"/>
                    <h:message for="city"/>
                </h:panelGroup>

                <h:outputText value="State"/>
                <h:panelGroup>
                    <h:inputText id="state"
                              value="#{contact.state}"
                               size="12"/>
                    <h:message for="state"/>
                </h:panelGroup>

                <h:outputText value="Country"/>
                <h:panelGroup>
                    <h:inputText id="country"
                              value="#{contact.country}"
                               size="12"/>
                    <h:message for="country"/>
                </h:panelGroup>

                <h:outputText value=""/>
                <h:commandButton value="Add contact"
                                action="#{addressBook.addToBook}"/>
            </h:panelGrid>
        </h:form>
      </body>
    </html>
</f:view>