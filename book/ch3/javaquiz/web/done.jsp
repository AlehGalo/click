<html>
   <%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %> 
   <%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %> 
   <f:view>
      <head> 
         <title><h:outputText value="#{msgs.title}"/></title>
      </head>
      <body>
         <h:form>
            <p>
               <h:outputText value="#{msgs.thankYou}"/>
               <h:outputFormat value="#{msgs.score}">                        
                  <f:param value="#{quiz.score}"/>
               </h:outputFormat>
            </p>
            <p>
               <h:commandButton value="#{msgs.startOverButton}" 
                  action="#{quiz.startOverAction}"/>
            </p>
         </h:form>
      </body>
   </f:view>
</html>
