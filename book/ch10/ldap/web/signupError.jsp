<html>
   <%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
   <%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
   <f:view>
      <head>
         <title>Signup Error</title>
      </head>
      <body>
         <h:form id="signupErrorForm">
            <p>
               An error has occurred when trying to sign up. 
               Try a different user name.
            </p>
            <p>
               <h:commandButton value="#{msgs.tryAgain}" action="login"/>
               <h:commandButton value="#{msgs.cancel}" action="signup_cancel"/>
            </p>
         </h:form>
      </body>
   </f:view>
</html>
