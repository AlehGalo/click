<html>
   <%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
   <%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
   <%@ taglib uri="http://corejsf.com/spinner" prefix="corejsf" %>
   <f:view>
      <head>                  
         <link href="styles.css" rel="stylesheet" type="text/css"/>
         <title><h:outputText value="#{msgs.windowTitle}"/></title>
      </head>

      <body>
         <h:form>
            <h:outputText value="#{msgs.creditCardExpirationPrompt}" 
               styleClass="pageTitle"/>
            <p/>
            <h:panelGrid columns="3">
               <h:outputText value="#{msgs.monthPrompt}"/>
               <corejsf:spinner value="#{cardExpirationDate.month}" 
                  id="monthSpinner" minimum="1" maximum="12" size="3" 
                  valueChangeListener="#{cardExpirationDate.changeListener}"/>
               <h:message for="monthSpinner"/>
               <h:outputText value="#{msgs.yearPrompt}"/>
               <corejsf:spinner value="#{cardExpirationDate.year}" 
                  id="yearSpinner" minimum="1900" maximum="2100" size="5" 
                  valueChangeListener="#{cardExpirationDate.changeListener}"/>
               <h:message for="yearSpinner"/>
               <h:outputText value="#{msgs.changes}"/>
               <h:outputText value="#{cardExpirationDate.changes}"/>
            </h:panelGrid>
            <p/>
            <h:commandButton value="#{msgs.nextButtonPrompt}" action="next"/>
         </h:form>
      </body>
   </f:view>
</html>
