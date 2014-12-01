<%@ include file="/taglibs.jsp" %>

<f:view>
    <f:loadBundle basename="com.corejsf.messages" var="msgs"/>
    <html>
        <head>
          <link href="<%= request.getContextPath() %>/styles.css"
                type="text/css" rel="stylesheet">

          <title>
              <h:outputText value="#{msgs.wireTransferWizardTitle}"/>
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
                    <h:panelGrid columns="2"
                              styleClass="wizardPanel"
                                rendered="#{dialog.data.page.bankInformationRendered}">
                        <h:panelGrid columns="1">

                           <h:panelGrid columns="1" styleClass="summaryHeadingPanel">
                               <h:outputText value="#{msgs.bankInformationHeading}"
                                      styleClass="summaryHeading"/>
                            </h:panelGrid>

                           <h:panelGrid columns="2">
                               <%@ include file="fields/bankInformationFields.jsp" %>
                               <h:outputText value=""/>
                               <f:subview id="bankInformationButtons">
                                  <jsp:include page="wizardButtons.jsp" />
                               </f:subview>
                           </h:panelGrid>
                        </h:panelGrid>
                    </h:panelGrid>

                    <h:panelGrid columns="2"
                              styleClass="wizardPanel"
                                rendered="#{dialog.data.page.accountInformationRendered}">
                        <h:panelGrid columns="1">

                           <h:panelGrid columns="1"
                                     styleClass="summaryHeadingPanel">
                               <h:outputText value="#{msgs.accountInformationHeading}"
                                      styleClass="summaryHeading"/>
                            </h:panelGrid>

                           <h:panelGrid columns="2">
                               <%@ include file="fields/accountInformationFields.jsp" %>
                               <h:outputText value=""/>
                               <f:subview id="accountInformationButtons">
                                  <jsp:include page="wizardButtons.jsp" />
                               </f:subview>
                           </h:panelGrid>
                        </h:panelGrid>
                    </h:panelGrid>

                    <h:panelGrid columns="2"
                              styleClass="wizardPanel"
                                rendered="#{dialog.data.page.accountContactRendered}">
                        <h:panelGrid columns="1">

                           <h:panelGrid columns="1"
                                     styleClass="summaryHeadingPanel">
                               <h:outputText value="#{msgs.accountContactHeading}"
                                      styleClass="summaryHeading"/>
                            </h:panelGrid>

                           <h:panelGrid columns="2">
                               <%@ include file="fields/accountContactFields.jsp" %>
                               <h:outputText value=""/>
                               <f:subview id="accountContactButtons">
                                  <jsp:include page="wizardButtons.jsp" />
                               </f:subview>
                           </h:panelGrid>
                        </h:panelGrid>
                    </h:panelGrid>

                    <h:panelGrid columns="2"
                              styleClass="wizardPanel"
                                rendered="#{dialog.data.page.summaryRendered}">
                        <h:panelGrid columns="1">

                           <h:panelGrid columns="1" styleClass="summaryHeadingPanel">
                               <h:outputText value="#{msgs.wireTransferSummaryHeading}"
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
