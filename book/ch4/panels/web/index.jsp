<html>
   <%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
   <%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
   <f:view>
      <head>                  
         <link href="styles.css" rel="stylesheet" type="text/css"/>
         <title>
            <h:outputText value="#{msgs.windowTitle}"/>
         </title>
      </head>

      <body>
         <h:form>
            <h:panelGrid columns="2" rowClasses="oddRows,evenRows">
               <h:outputText value="#{msgs.namePrompt}:"/>
               <h:panelGroup>
                  <h:inputText id="name" 
                     value="#{user.name}" required="true"
                     label="#{msgs.namePrompt}"/>
                  <h:message for="name" errorClass="errors"/>
               </h:panelGroup>
               <h:outputText value="#{msgs.agePrompt}:"/>
               <h:inputText size="3" value="#{user.age}"
                  label="#{msgs.agePrompt}"/>
            </h:panelGrid>
            <br/>
            <h:commandButton value="#{msgs.submitPrompt}"/>
         </h:form>
      </body>
   </f:view>
</html>
