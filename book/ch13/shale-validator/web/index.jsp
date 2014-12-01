<html>
   <%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
   <%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
   <%@ taglib uri="http://struts.apache.org/shale/core" prefix="s" %>

   <f:view>
      <head>
         <link href="styles.css" rel="stylesheet" type="text/css"/>
         <title><h:outputText value="#{msgs.title}"/></title>
      </head>
      <body>
         <h:form id="paymentForm" onsubmit="return validatePaymentForm(this);">
            <h1><h:outputText value="#{msgs.enterPayment}"/></h1>
            <h:panelGrid columns="3">
               <h:outputText value="#{msgs.amount}"/>
               <h:inputText id="amount" value="#{payment.amount}"> 
                  <s:commonsValidator type="required"
                        arg="#{msgs.amount}"
                        client="true" server="true"/>                  
                  <f:convertNumber minFractionDigits="2"/>
                  <s:commonsValidator type="floatRange"
                        arg="#{msgs.amount}"
                        client="true" server="true">                  
                     <s:validatorVar name="min" value="10"/>
                     <s:validatorVar name="max" value="10000"/>
                  </s:commonsValidator>
               </h:inputText>
               <h:message for="amount" styleClass="errorMessage"/>

               <h:outputText value="#{msgs.creditCard}"/>
               <h:inputText id="card" value="#{payment.card}"> 
                  <s:commonsValidator type="required"
                        arg="#{msgs.creditCard}"
                        client="true" server="true"/>                  

                  <s:commonsValidator type="mask"
                        arg="#{msgs.creditCard}"
                        client="true" server="true">                  
                     <s:validatorVar name="mask" value="[4-6].*"/>
                  </s:commonsValidator>

                  <s:commonsValidator type="creditCard" 
                        arg="#{msgs.creditCard}"
                        client="true" server="true"/>                  
               </h:inputText>
               <h:message for="card" styleClass="errorMessage"/>

               <h:outputText value="#{msgs.expirationDate}"/>
               <h:inputText id="date" value="#{payment.date}"
                  required="true"> 
                  <f:convertDateTime pattern="MM/yyyy"/>
               </h:inputText>
               <h:message for="date" styleClass="errorMessage"/>
            </h:panelGrid>
            <h:commandButton value="Process" action="process"/>
            <h:commandButton value="Cancel" action="cancel" immediate="true"/>
            <s:validatorScript functionName="validatePaymentForm"/>
         </h:form>
      </body>
   </f:view>
</html>
