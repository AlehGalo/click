<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<h:panelGrid columns="1" styleClass="wizardLinks">
    <h:panelGrid columns="5">
        <h:outputText value="#{msgs.payeeTabPrompt}"
                 styleClass="#{dialog.data.page.payeeStyle}"/>

        <h:outputText value="#{msgs.paymentMethodTabPrompt}"
                 styleClass="#{dialog.data.page.paymentMethodStyle}"/>

        <h:outputText value="#{msgs.paymentScheduleTabPrompt}"
                 styleClass="#{dialog.data.page.paymentScheduleStyle}"/>

        <h:outputText value="#{msgs.summaryTabPrompt}"
                 styleClass="#{dialog.data.page.summaryStyle}"/>
    </h:panelGrid>
</h:panelGrid>
