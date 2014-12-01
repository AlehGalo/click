<%-- This file is statically included with the JSP
     include directive by wizard.jsp. --%>

<h:selectOneRadio value="#{dialog.data.paymentSchedule}"
                 layout="pageDirection">
    <f:selectItems value="#{dialog.data.paymentScheduleItems}"/>
</h:selectOneRadio>
