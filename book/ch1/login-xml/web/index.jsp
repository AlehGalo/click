<?xml version="1.0"?>
<jsp:root version="2.0" 
   xmlns:jsp="http://java.sun.com/JSP/Page"
   xmlns:f="http://java.sun.com/jsf/core" 
   xmlns:h="http://java.sun.com/jsf/html">
   <jsp:directive.page contentType="text/html"/>
   <jsp:output omit-xml-declaration="no" 
      doctype-root-element="html"
      doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
      doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"/>
   <f:view>
      <html xmlns="http://www.w3.org/1999/xhtml">
         <head>
            <title>A Simple JavaServer Faces Application</title>
         </head>
         <body>         
            <h:form>
               <h3>Please enter your name and password.</h3>
               <table>
                  <tr>
                     <td>Name:</td>
                     <td>
                        <h:inputText value="#{user.name}"/>
                     </td>
                  </tr>
                  <tr>
                     <td>Password:</td>
                     <td>
                        <h:inputSecret value="#{user.password}"/>
                     </td>
                  </tr>
               </table>
               <p>
                  <h:commandButton value="Login" action="#{user.login}"/> </p>
            </h:form>
         </body>
      </html>
   </f:view>
</jsp:root>