<html>
   <%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
   <%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
   <%@ taglib uri="https://ajax4jsf.dev.java.net/ajax" prefix="a4j" %>

   <f:view locale="en">
      <f:loadBundle basename="com.corejsf.messages" var="msgs"/>
      <head>
         <title><h:outputText value="#{msgs.windowTitle}"/></title>
         <link href="styles.css" rel="stylesheet" type="text/css"/>
         <script type="text/javascript" src="fat.js"></script>
      </head>

      <body>
         <div class="banner">
            <h:outputText value="#{msgs.bannerText}"
               styleClass="bannerText"/>
         </div>

         <h:panelGrid columns="2" styleClass="heading">
            <a4j:status id="status">
               <f:facet name="start">
                  <h:graphicImage value="/indicator_radar.gif"/>
               </f:facet>
            </a4j:status>

             <h:outputText value="#{msgs.informationPrompt}"
                styleClass="heading"/>
         </h:panelGrid>

         <h:form id="form">
             <h:panelGrid columns="2">
                 <h:outputLabel for="zip"
                              value="#{msgs.zipPrompt}"/>
                 <h:panelGroup>
                     <h:inputText id="zip"
                                size="5"
                               value="#{bb.zip}"
                            required="true">

                        <!-- Add two validators: one for length and
                             another for our custom zip code
                             validator -->
                        <f:validateLength minimum="5"
                                          maximum="5"/>

                        <f:validator
                            validatorId="com.corejsf.ZipcodeValidator"/>

                        <!-- The a4j:support tag must be immediate;
                             otherwise, if validation fails, JSF will
                             skip action listeners and go directly to
                             the Render Response phase to rerender
                             the current view. -->
                        <a4j:support event="onblur"
                                 immediate="true"
                            actionListener="#{bb.validateZip}"
                                  reRender="city, state, errorMessage"/>

                     </h:inputText>

                     <h:outputText id="errorMessage"
                                value="#{bb.errorMessage}"
                                style="color: red; font-style: italic;"/>
                 </h:panelGroup>

                 <h:outputLabel for="city"
                            value="#{msgs.cityPrompt}"/>
                 <h:inputText id="city" binding="#{bb.cityInput}"
                          size="25"
                         value="#{bb.city}"/>

                 <h:outputLabel for="state"
                            value="#{msgs.statePrompt}"/>
                 <h:inputText id="state" binding="#{bb.stateInput}"
                          size="15"
                         value="#{bb.state}"/>

                 <h:outputText value=""/>

                 <h:commandButton id="submit"
                               value="#{msgs.submitButtonText}"
                              action="showBackingBean"/>
            </h:panelGrid>
        </h:form>
       </body>
   </f:view>
</html>
