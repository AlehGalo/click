<%-- This file is statically included with the JSP
     include directive by accountWizard.jsp. --%>

<%-- ACCOUNT NAME --%>

<h:outputLabel for="recipient" value="#{msgs.recipientPrompt}"/>
<h:panelGroup>
   <h:inputText id="recipient"
              size="15"
             value="#{dialog.data.recipient}"
           onfocus="activatefield(this);"
            onblur="deactivatefield(this);"
        styleClass="input"/>
   <h:message for="recipient" styleClass="errors"/>
</h:panelGroup>

<%-- BANK KEY --%>

<h:outputLabel for="recipientTelephone"
             value="#{msgs.recipientTelephonePrompt}"/>
<h:panelGroup>
   <h:inputText id="recipientTelephone"
              size="10"
             value="#{dialog.data.recipientTelephone}"
           onfocus="activatefield(this);"
            onblur="deactivatefield(this);"
        styleClass="input"/>
   <h:message for="recipientTelephone" styleClass="errors"/>
</h:panelGroup>

<%-- ACCOUNT NUMBER --%>

<h:outputLabel for="recipientEmail"
             value="#{msgs.recipientEmailPrompt}"/>
<h:panelGroup>
   <h:inputText id="recipientEmail"
              size="20"
             value="#{dialog.data.recipientEmail}"
           onfocus="activatefield(this);"
            onblur="deactivatefield(this);"
        styleClass="input"/>
   <h:message for="recipientEmail" styleClass="errors"/>
</h:panelGroup>