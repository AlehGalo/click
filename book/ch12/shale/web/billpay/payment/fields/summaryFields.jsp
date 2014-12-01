<%-- This file is statically included with the JSP
     include directive by accountWizard.jsp. --%>

<h:outputText value="#{msgs.payeeHeading}" styleClass="summaryTitle"/>

<h:panelGrid columns="2">
    <h:outputText value="#{msgs.namePrompt}"/>
    <h:outputText value="#{dialog.data.name}"
             styleClass="summaryOutput"/>

    <h:outputText value="#{msgs.streetAddressPrompt}"/>
    <h:outputText value="#{dialog.data.streetAddress}"
             styleClass="summaryOutput"/>

    <h:outputText value="#{msgs.cityPrompt}"/>
    <h:outputText value="#{dialog.data.city}"
             styleClass="summaryOutput"/>

    <h:outputText value="#{msgs.statePrompt}"/>
    <h:outputText value="#{dialog.data.state}"
             styleClass="summaryOutput"/>

    <h:outputText value="#{msgs.zipPrompt}"/>
    <h:outputText value="#{dialog.data.zip}"
             styleClass="summaryOutput"/>
</h:panelGrid>

<h:outputText value="#{msgs.paymentMethodHeading}"
         styleClass="summaryTitle"/>

<h:panelGrid columns="2">
    <h:outputText value="#{msgs.paymentAmountPrompt}"/>
    <h:outputText value="#{dialog.data.paymentAmount}" styleClass="summaryOutput"/>

    <h:outputText value="#{msgs.paymentMethodPrompt}"/>
    <h:outputText value="#{dialog.data.paymentMethod}" styleClass="summaryOutput"/>
</h:panelGrid>
<h:outputText value="#{msgs.paymentScheduleHeading}"
         styleClass="summaryTitle"/>

<h:panelGrid columns="2">
    <h:outputText value="#{msgs.paymentSchedulePrompt}"/>
    <h:outputText value="#{dialog.data.paymentSchedule}"
             styleClass="summaryOutput"/>

    <h:outputText value="#{msgs.paymentMethodPrompt}"/>
    <h:outputText value="#{dialog.data.paymentMethod}" styleClass="summaryOutput"/>
</h:panelGrid>

<h:outputText value="#{msgs.bankInformationHeading}" styleClass="summaryTitle"/>

<h:panelGrid columns="2">
    <h:outputText value="#{msgs.bankNamePrompt}"/>
    <h:outputText value="#{dialog.data.transfer.bankName}" styleClass="summaryOutput"/>

    <h:outputText value="#{msgs.streetAddressPrompt}"/>
    <h:outputText value="#{dialog.data.transfer.streetAddress}" styleClass="summaryOutput"/>

    <h:outputText value="#{msgs.cityPrompt}"/>
    <h:outputText value="#{dialog.data.transfer.city}" styleClass="summaryOutput"/>

    <h:outputText value="#{msgs.statePrompt}"/>
    <h:outputText value="#{dialog.data.transfer.state}" styleClass="summaryOutput"/>

    <h:outputText value="#{msgs.zipPrompt}"/>
    <h:outputText value="#{dialog.data.transfer.zip}" styleClass="summaryOutput"/>
</h:panelGrid>

<h:outputText value="#{msgs.accountInformationHeading}" styleClass="summaryTitle"/>

<h:panelGrid columns="2">
    <h:outputText value="#{msgs.bankAccountNamePrompt}"/>
    <h:outputText value="#{dialog.data.transfer.bankAccountName}" styleClass="summaryOutput"/>

    <h:outputText value="#{msgs.bankKeyPrompt}"/>
    <h:outputText value="#{dialog.data.transfer.bankKey}" styleClass="summaryOutput"/>

    <h:outputText value="#{msgs.bankAccountNumberPrompt}"/>
    <h:outputText value="#{dialog.data.transfer.bankAccountNumber}" styleClass="summaryOutput"/>
</h:panelGrid>


<h:outputText value="#{msgs.recipientInformationHeading}" styleClass="summaryTitle"/>

<h:panelGrid columns="2">
    <h:outputText value="#{msgs.recipientPrompt}"/>
    <h:outputText value="#{dialog.data.transfer.recipient}" styleClass="summaryOutput"/>

    <h:outputText value="#{msgs.recipientTelephonePrompt}"/>
    <h:outputText value="#{dialog.data.transfer.recipientTelephone}" styleClass="summaryOutput"/>

    <h:outputText value="#{msgs.recipientEmailPrompt}"/>
    <h:outputText value="#{dialog.data.transfer.recipientEmail}" styleClass="summaryOutput"/>
</h:panelGrid>
