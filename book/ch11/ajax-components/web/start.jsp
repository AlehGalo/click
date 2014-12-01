<html>
   <%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
   <%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
   <%@ taglib uri="http://corejsf/rico" prefix="rico"%>

   <f:view>
       <f:loadBundle basename="com.corejsf.messages" var="msgs"/>
        <head>
            <link href="styles.css" rel="stylesheet" type="text/css"/>
            <title><h:outputText value="#{msgs.windowTitle}"/></title>
        </head>

        <body>
            <div class="banner">
                <h:outputText value="#{msgs.banner}"
                         styleClass="bannerText"/>
            </div>

            <rico:accordion     name="bookAccordionTwo"
                         panelHeight="175"
                          styleClass="accordion"
                          panelClass="accordionPanel"
                         headerClass="accordionPanelHeader"
                        contentClass="accordionPanelContent">
                <rico:accordionPanel heading="Here's some plain text...">
                    Just plain text inside this accordion panel.
                </rico:accordionPanel>

                <rico:accordionPanel heading="Here's some more plain text...">
                    Just more plain text inside this accordion panel.
                </rico:accordionPanel>

                <rico:accordionPanel heading="#{msgs.whatIsAHybrid}">
				   <jsp:include page="/whatIsAHybrid.jsp"/>
				</rico:accordionPanel>

                <rico:accordionPanel heading="#{msgs.aboutThisComponent}">
				   <jsp:include page="/aboutTheAccordion.jsp"/>
				</rico:accordionPanel>

                <rico:accordionPanel heading="#{msgs.aboutRico}">
				   <jsp:include page="/aboutRico.jsp"/>
				</rico:accordionPanel>

                <rico:accordionPanel heading="#{msgs.lookWhatYouCanDo}">
				   <jsp:include page="/lookWhatYouCanDo.jsp"/>
				</rico:accordionPanel>
            </rico:accordion>
        </body>
   </f:view>
</html>
