<html>
   <%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
   <%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
   <f:view>
      <head>
         <title><h:outputText value="#{msgs.title}"/></title>
      </head>
      <body>
         <h:form>
            <h1><h:outputText value="#{msgs.searchResult}"/></h1>
            <h:dataTable value="#{authorSearch.response}" var="item" 
               border="1">
               <h:column>
                  <f:facet name="header">
                     <h:outputText value="#{msgs.author1}"/>
                  </f:facet>
                  <h:outputText value="#{item.itemAttributes.author[0]}"/>
               </h:column>
               <h:column>
                  <f:facet name="header">
                     <h:outputText value="#{msgs.title}"/>
                  </f:facet>
                  <h:outputText value="#{item.itemAttributes.title}"/>
               </h:column>
               <h:column>
                  <f:facet name="header">
                     <h:outputText value="#{msgs.publisher}"/>
                  </f:facet>
                  <h:outputText value="#{item.itemAttributes.publisher}"/>
               </h:column>
               <h:column>
                  <f:facet name="header">
                     <h:outputText value="#{msgs.pubdate}"/>
                  </f:facet>
                  <h:outputText value="#{item.itemAttributes.publicationDate}"/>
               </h:column>
            </h:dataTable>
            <h:commandButton value="#{msgs.back}" action="back"/>
         </h:form>
      </body>
   </f:view>
</html>
