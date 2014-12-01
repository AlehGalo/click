<html>
   <%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
   <%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
   <%@ taglib uri="http://corejsf.com/chart" prefix="corejsf" %>
   <f:view>
      <head>               
         <title>Generating binary data</title>
      </head>
      <body>
         <h:form>
            <p>Here is your image:</p>
            <corejsf:chart width="500" height="500" 
               title="Diameters of the Planets" 
               names="#{planets.names}" values="#{planets.values}"/>
         </h:form>
      </body>
   </f:view>
</html>