<%-- This file is statically included with the JSP
     include directive by wizard.jsp. --%>

<%-- NAME --%>

<h:outputLabel for="name" value="#{msgs.namePrompt}"/>
<h:panelGroup>
   <h:inputText id="name"
              size="30"
               value="#{dialog.data.name}"
           onkeyup="nameChanged(this.value);"
            onblur="nameChanged('clear'); deactivatefield(this);"
           onfocus="activatefield(this);"
        styleClass="input"/>
   <h:outputText id="nameMessage" style="visible: false;"/>
</h:panelGroup>

<%-- STREET ADDRESS --%>

<h:outputLabel for="streetAddress" value="#{msgs.streetAddressPrompt}"/>
<h:panelGroup>
   <h:inputText id="streetAddress"
              size="35"
             value="#{dialog.data.streetAddress}"
           onfocus="activatefield(this);"
            onblur="deactivatefield(this);"
        styleClass="input"/>
   <h:message for="streetAddress" styleClass="errors"/>
</h:panelGroup>

<%-- CITY --%>

<h:outputLabel for="city" value="#{msgs.cityPrompt}"/>
<h:panelGroup>
	<h:inputText id="city"
               size="20"
	          value="#{dialog.data.city}"
	        onfocus="activatefield(this);"
	         onblur="deactivatefield(this);"
	     styleClass="input"/>
   <h:message for="city" styleClass="errors"/>
</h:panelGroup>

<%-- STATE --%>

<h:outputLabel for="state" value="#{msgs.statePrompt}"/>
<h:panelGroup>
	<h:inputText id="state"
               size="20"
	          value="#{dialog.data.state}"
	        onfocus="activatefield(this);"
	         onblur="deactivatefield(this);"
	     styleClass="input"/>
   <h:message for="state" styleClass="errors"/>
</h:panelGroup>

<%-- ZIP --%>

<h:outputLabel for="zip" value="#{msgs.zipPrompt}"/>
<h:panelGroup>
	<h:inputText id="zip"
               size="5"
              value="#{dialog.data.zip}"
	        onfocus="activatefield(this);"
	         onblur="deactivatefield(this);"
	     styleClass="input"/>
   <h:message for="zip" styleClass="errors"/>
</h:panelGroup>
