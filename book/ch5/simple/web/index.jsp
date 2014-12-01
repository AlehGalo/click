<html>
   <%@ taglib uri="http://java.sun.com/jsf/core"  prefix="f" %>
   <%@ taglib uri="http://java.sun.com/jsf/html"  prefix="h" %>
   <f:view>
      <head> 
         <title>
            <h:outputText value="#{msgs.windowTitle}"/>
         </title>
      </head>

      <body>
         <h:outputText value="#{msgs.pageTitle}"/>
         <p>
         <h:form>
            <h:dataTable value="#{tableData.names}" 
                            var="name">
               <h:column>
                  <h:outputText value="#{name.last}, "/>
               </h:column>

               <h:column>
                  <h:outputText value="#{name.first}"/>
               </h:column>
            </h:dataTable>
         </h:form>
      </body>
   </f:view>
</html>  
