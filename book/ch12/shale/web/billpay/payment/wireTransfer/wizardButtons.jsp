<%-- This file is dynamically included with the JSP
     include tag by accountWizard.jsp --%>

<%@ include file="/taglibs.jsp" %>

<h:panelGrid columns="1" styleClass="wizardButtonPanel">
   <h:panelGroup>
   	<h:commandButton id="next" 
   	              value="#{msgs.nextButtonText}" 
                 action="next"
   			 styleClass="wizardButton"
               disabled="#{not dialog.data.page.nextButtonEnabled}"/>

   	<h:commandButton id="previous"
   	              value="#{msgs.previousButtonText}" 
                 action="previous"
   			 styleClass="wizardButton"
               disabled="#{not dialog.data.page.previousButtonEnabled}"/>
					 
   	<h:commandButton id="cancel" immediate="true"
   	              value="#{msgs.cancelButtonText}" 
                 action="cancel"
   			 styleClass="wizardButton"
               disabled="#{not dialog.data.page.cancelButtonEnabled}"/>
					 
   	<h:commandButton id="finish"
   	              value="#{msgs.finishButtonText}"
                 action="finish"
   			 styleClass="wizardButton"
               disabled="#{not dialog.data.page.finishButtonEnabled}"/>
   </h:panelGroup>
</h:panelGrid>
