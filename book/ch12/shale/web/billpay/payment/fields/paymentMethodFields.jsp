<%-- This file is statically included with the JSP
     include directive by wizard.jsp. --%>

<%-- PAYMENT AMOUNT --%>
<h:outputLabel for="paymentAmount" value="#{msgs.paymentAmountPrompt}"/>
<h:panelGroup>
   <h:inputText id="paymentAmount"
             value="#{dialog.data.paymentAmount}"
           onfocus="activatefield(this);"
            onblur="deactivatefield(this);"
        styleClass="input">
      <f:convertNumber type="currency"/>
   </h:inputText>
   <h:message for="paymentAmount" styleClass="errors"/>
</h:panelGroup>

<%-- PAYMENT METHOD --%>
<h:outputLabel for="paymentMethod" value="#{msgs.paymentMethodPrompt}"/>
<h:panelGroup>
   <h:selectOneMenu id="paymentMethod"
                 value="#{dialog.data.paymentMethod}">
       <f:selectItems value="#{dialog.data.paymentMethodItems}"/>
   </h:selectOneMenu>
   <h:message for="paymentMethod" styleClass="errors"/>
</h:panelGroup>
