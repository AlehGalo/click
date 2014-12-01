<html>
   <%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
   <%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

   <f:view>
      <head>                  
         <link href="styles.css" rel="stylesheet" type="text/css"/>
         <title><h:outputText value="#{msgs.windowTitle}"/></title>
      </head>
      <body>
         <h:form>
            <h:outputText value="#{msgs.youEnteredPrompt}" 
               styleClass="pageTitle"/>
            <p/>
            <h:outputText value="#{msgs.expirationDatePrompt}"/>
            <h:outputText value="#{cardExpirationDate.month}"/> /
            <h:outputText value="#{cardExpirationDate.year}"/>
            <p/>
            <h:commandButton value="Try again" action="again"/>
         </h:form>
      </body>
   </f:view>
</html>
