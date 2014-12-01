<html>
   <%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
   <%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
   <f:view>
      <head>                  
         <title>A Variable Resolver</title>
      </head>
      <body>
         <h:form id="form1">
            <h3>Testing the Variable Resolver</h3>            
            <table>
               <tr>
                  <td>sysprop['java.version']=</td>
                  <td>      
                     <h:outputText id="output1" value="#{sysprop['java.version']}"/>
                  </td>
               </tr>             
               <tr>
                  <td>sysprop.java.home=</td>
                  <td>
                     <h:outputText value="#{sysprop.java.home}"/>
                  </td>
               </tr>
               <tr>
                  <td>view.form1.output1.value=</td>
                  <td>
                     <h:outputText value="#{view.form1.output1.value}"/>
                  </td>
               </tr>
            </table>            
         </h:form>
      </body>
   </f:view>
</html>