<%-- This file is statically included with the JSP
     include directive by accountWizard.jsp. --%>

<%-- ACCOUNT NAME --%>

<h:outputLabel for="bankAccountName" value="#{msgs.bankAccountNamePrompt}"/>
<h:panelGroup>
   <h:inputText id="bankAccountName"
              size="15"
             value="#{dialog.data.bankAccountName}"
           onfocus="activatefield(this);"
            onblur="deactivatefield(this);"
        styleClass="input"/>
   <h:message for="bankAccountName" styleClass="errors"/>
</h:panelGroup>

<%-- BANK KEY --%>

<h:outputLabel for="bankKey" value="#{msgs.bankKeyPrompt}"/>
<h:panelGroup>
   <h:inputText id="bankKey"
              size="10"
             value="#{dialog.data.bankKey}"
           onfocus="activatefield(this);"
            onblur="deactivatefield(this);"
        styleClass="input"/>
   <h:message for="bankKey" styleClass="errors"/>
</h:panelGroup>

<%-- ACCOUNT NUMBER --%>

<h:outputLabel for="bankAccountNumber" value="#{msgs.bankAccountNumberPrompt}"/>
<h:panelGroup>
   <h:inputText id="bankAccountNumber"
              size="20"
             value="#{dialog.data.bankAccountNumber}"
           onfocus="activatefield(this);"
            onblur="deactivatefield(this);"
        styleClass="input"/>
   <h:message for="bankAccountNumber" styleClass="errors"/>
</h:panelGroup>