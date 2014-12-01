<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<h:panelGrid columns="1" styleClass="wizardLinks">
    <h:panelGrid columns="5">
        <h:outputText value="#{msgs.bankInformationTabPrompt}"
                 styleClass="#{dialog.data.page.bankInformationStyle}"/>

        <h:outputText value="#{msgs.accountInformationTabPrompt}"
                 styleClass="#{dialog.data.page.accountInformationStyle}"/>

        <h:outputText value="#{msgs.accountContactTabPrompt}"
                 styleClass="#{dialog.data.page.accountContactStyle}"/>

        <h:outputText value="#{msgs.summaryTabPrompt}"
                 styleClass="#{dialog.data.page.summaryStyle}"/>
    </h:panelGrid>
</h:panelGrid>
