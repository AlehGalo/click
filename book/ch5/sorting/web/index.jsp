<html>
   <%@ taglib uri="http://java.sun.com/jsf/core"  prefix="f" %>
   <%@ taglib uri="http://java.sun.com/jsf/html"  prefix="h" %>
   <f:view>
      <head>
         <link href="site.css" rel="stylesheet" type="text/css"/>
         <title>
            <h:outputText value="#{msgs.windowTitle}"/>
         </title>
      </head>
      <body>
         <h:form>
            <h:dataTable value="#{tableData.names}" var="name" 
               styleClass="names" headerClass="namesHeader" 
               columnClasses="last,first">
               <h:column>
                  <f:facet name="header"> 
                     <h:outputText value="#{msgs.deleteColumnHeader}"/>
                  </f:facet>
                  <h:selectBooleanCheckbox 
                     value="#{name.markedForDeletion}" 
                     onchange="submit()"/>
               </h:column>

               <h:column>
                  <f:facet name="header"> 
                     <h:commandLink action="#{tableData.names.sortByLast}">  
                        <h:outputText value="#{msgs.lastColumnHeader}"/> 
                     </h:commandLink>
                  </f:facet>
                  <h:outputText value="#{name.last}, "/>
               </h:column>
               <h:column>
                  <f:facet name="header"> 
                     <h:commandLink action="#{tableData.names.sortByFirst}">  
                        <h:outputText value="#{msgs.firstColumnHeader}"/> 
                     </h:commandLink>
                  </f:facet>
                  <h:outputText value="#{name.first}"/>
               </h:column>
            </h:dataTable>
            <h:commandButton value="#{msgs.deleteButtonText}" 
               action="#{tableData.deleteNames}" 
               rendered="#{tableData.anyNamesMarkedForDeletion}"/>
         </h:form>
      </body>
   </f:view>
</html>
