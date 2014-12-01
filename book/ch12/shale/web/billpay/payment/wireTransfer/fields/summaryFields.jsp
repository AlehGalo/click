<h:outputText value="#{msgs.bankInformationHeading}" styleClass="summaryTitle"/>

<h:panelGrid columns="2">
    <h:outputText value="#{msgs.bankNamePrompt}"/>
    <h:outputText value="#{dialog.data.bankName}" styleClass="summaryOutput"/>

    <h:outputText value="#{msgs.streetAddressPrompt}"/>
    <h:outputText value="#{dialog.data.streetAddress}" styleClass="summaryOutput"/>

    <h:outputText value="#{msgs.cityPrompt}"/>
    <h:outputText value="#{dialog.data.city}" styleClass="summaryOutput"/>

    <h:outputText value="#{msgs.statePrompt}"/>
    <h:outputText value="#{dialog.data.state}" styleClass="summaryOutput"/>

    <h:outputText value="#{msgs.zipPrompt}"/>
    <h:outputText value="#{dialog.data.zip}" styleClass="summaryOutput"/>
</h:panelGrid>

<h:outputText value="#{msgs.accountInformationHeading}" styleClass="summaryTitle"/>

<h:panelGrid columns="2">
    <h:outputText value="#{msgs.bankAccountNamePrompt}"/>
    <h:outputText value="#{dialog.data.bankAccountName}" styleClass="summaryOutput"/>

    <h:outputText value="#{msgs.bankKeyPrompt}"/>
    <h:outputText value="#{dialog.data.bankKey}" styleClass="summaryOutput"/>

    <h:outputText value="#{msgs.bankAccountNumberPrompt}"/>
    <h:outputText value="#{dialog.data.bankAccountNumber}" styleClass="summaryOutput"/>
</h:panelGrid>


<h:outputText value="#{msgs.recipientInformationHeading}" styleClass="summaryTitle"/>

<h:panelGrid columns="2">
    <h:outputText value="#{msgs.recipientPrompt}"/>
    <h:outputText value="#{dialog.data.recipient}" styleClass="summaryOutput"/>

    <h:outputText value="#{msgs.recipientTelephonePrompt}"/>
    <h:outputText value="#{dialog.data.recipientTelephone}" styleClass="summaryOutput"/>

    <h:outputText value="#{msgs.recipientEmailPrompt}"/>
    <h:outputText value="#{dialog.data.recipientEmail}" styleClass="summaryOutput"/>
</h:panelGrid>