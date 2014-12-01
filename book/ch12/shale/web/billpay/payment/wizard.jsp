<%@ include file="/taglibs.jsp" %>

<f:view>
    <f:loadBundle basename="com.corejsf.messages" var="msgs"/>
    <html>
        <head>
          <link href="<%= request.getContextPath() %>/styles.css"
                type="text/css" rel="stylesheet">

          <title>
              <h:outputText value="#{msgs.billPaymentWizardTitle}"/>
          </title>

          <script src="<%= request.getContextPath() %>/fields.js"
                 type="text/javascript"></script>
        </head>

        <body onload="document.getElementsByTagName('input')[0].focus();">
            <h:form>
                <div class="toolbar">
                    <f:subview id="toolbar">
                        <jsp:include page="toolbar.jsp"/>
                    </f:subview>
                </div>

                <div class="content">
                    <h:panelGrid columns="2" styleClass="wizardPanel">
                        <%-- PAYEE FIELDS --%>
                        <h:panelGrid columns="1"
                                    rendered="#{dialog.data.page.payeeRendered}">

                           <h:panelGrid columns="1" styleClass="summaryHeadingPanel">
                               <h:outputText value="#{msgs.payeeHeading}"
                                      styleClass="summaryHeading"/>
                           </h:panelGrid>

                           <h:panelGrid columns="2">
                              <%@ include file="fields/payeeFields.jsp" %>
                              <h:outputText value=""/>
                              <f:subview id="usernameButtons">
                                 <jsp:include page="wizardButtons.jsp" />
                              </f:subview>
                           </h:panelGrid>
                        </h:panelGrid>

                        <%-- PHONE NUMBER FIELDS --%>
                        <h:panelGrid columns="1"
                                    rendered="#{dialog.data.page.paymentMethodRendered}">

                           <h:panelGrid columns="1" styleClass="summaryHeadingPanel">
                               <h:outputText value="#{msgs.paymentMethodHeading}"
                                      styleClass="summaryHeading"/>
                            </h:panelGrid>

                           <h:panelGrid columns="2">
                              <%@ include file="fields/paymentMethodFields.jsp" %>
                              <h:outputText value=""/>
                              <f:subview id="phoneNumberButtons">
                                 <jsp:include page="wizardButtons.jsp" />
                              </f:subview>
                           </h:panelGrid>

                        </h:panelGrid>

                        <%-- ADDRESS FIELDS --%>
                        <h:panelGrid columns="1"
                                    rendered="#{dialog.data.page.paymentScheduleRendered}">

                           <h:panelGrid columns="1" styleClass="summaryHeadingPanel">
                               <h:outputText value="#{msgs.paymentScheduleHeading}"
                                      styleClass="summaryHeading"/>
                            </h:panelGrid>

                           <h:panelGrid columns="2">
                              <%@ include file="fields/paymentScheduleFields.jsp" %>
                              <h:outputText value=""/>
                              <f:subview id="addressButtons">
                                 <jsp:include page="wizardButtons.jsp" />
                              </f:subview>
                           </h:panelGrid>

                        </h:panelGrid>

                        <%-- SUMMARY FIELDS --%>
                        <h:panelGrid columns="1"
                                    rendered="#{dialog.data.page.summaryRendered}">

                           <h:panelGrid columns="1" styleClass="summaryHeadingPanel">
                               <h:outputText value="#{msgs.billpaySummaryHeading}"
                                      styleClass="summaryHeading"/>
                            </h:panelGrid>

                           <h:panelGrid columns="1">
                            <%@ include file="fields/summaryFields.jsp" %>
                               <h:outputText value=""/>
                               <f:subview id="summaryButtons">
                                  <jsp:include page="wizardButtons.jsp" />
                               </f:subview>
                           </h:panelGrid>
                        </h:panelGrid>
                    </h:panelGrid>
                </div>
            </h:form>
        </body>
    </html>
</f:view>
