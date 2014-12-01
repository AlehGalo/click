<html>
   <%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
   <%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
   <%@ taglib uri="https://ajax4jsf.dev.java.net/ajax" prefix="a4j" %>
   <f:view>
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

         <h:panelGrid columns="1" styleClass="heading">
            <h:outputText value="#{msgs.informationPrompt}"
               styleClass="heading"/>
         </h:panelGrid>   

         <h:form id="form">
             <h:panelGrid columns="2">
                 <h:outputLabel for="zip"
                              value="#{msgs.zipPrompt}"/>

                 <h:inputText id="zip"
                            size="5"
                           value="#{bb.zip}">

                    <a4j:support event="onfocus"
                        actionListener="#{bb.clearCityAndState}"
                              reRender="city, state"/>

                    <a4j:support event="onblur"
                        actionListener="#{bb.setCityAndStateForZip}"
                              reRender="city, state"
                            oncomplete="Fat.fade_element('form:city');
                                        Fat.fade_element('form:state');"/>
                 </h:inputText>

                 <h:outputLabel for="city"
                            value="#{msgs.cityPrompt}"/>
                 <h:inputText id="city"
                          size="25"
                         value="#{bb.city}"/>

                 <h:outputLabel for="state"
                            value="#{msgs.statePrompt}"/>
                 <h:inputText id="state"
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
