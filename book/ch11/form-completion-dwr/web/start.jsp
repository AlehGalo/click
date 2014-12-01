<html>
    <%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
    <%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
    <f:view>
        <head>
            <title><h:outputText value="#{msgs.windowTitle}"/></title>
            <link href="styles.css" rel="stylesheet" type="text/css"/>
            <script type="text/javascript" src="prototype.js"></script>
            <script type="text/javascript" src="fat.js"></script>
            <script type='text/javascript' 
				         src='/form-completion-dwr/dwr/interface/ZipCodes.js'></script>
            <script type='text/javascript' 
				         src='/form-completion-dwr/dwr/engine.js'></script>
            <script type="text/javascript" language="Javascript1.1">
                <!--
                function zipChanged(zip) {
                    if(zip.length != 5) {
                        clearCityAndStateFields();
                    }
                    else {
                       // A DWR call. See /WEB-INF/dwr.xml
                       ZipCodes.getCityAndStateForZip(zip, 
                          processZipCodeSelection); 
                    }
                }
                function processZipCodeSelection(returnValue) {
                    var cityAndState = returnValue.split(',');
                    setCityAndStateFields(cityAndState[0], cityAndState[1]);
                    Fat.fade_element("form:city");
                    Fat.fade_element("form:state");
                }
                function clearCityAndStateFields() {
                    $("form:city").value  = "";
                    $("form:state").value = "";
                }
                function setCityAndStateFields(city, state) {
                    $("form:city").value  = city;
                    $("form:state").value = state;
                }
               -->
            </script>
        </head>

        <body>
            <div class="banner">
                <h:outputText value="#{msgs.bannerText}"
                         styleClass="bannerText"/>
            </div>

           <h:form id="form">
              <p><h:outputText value="#{informationPrompt}"
                           styleClass="heading"/><p>

               <h:panelGrid columns="2">
                   <h:outputLabel for="zip" value="#{msgs.zipPrompt}"/>
                   <h:inputText id="zip"
                              size="5"
                             value="#{bb.zip}"
                            onblur="zipChanged(this.value);"/>

                   <h:outputLabel for="city" value="#{msgs.cityPrompt}"/>
                   <h:inputText id="city"
                              size="25"
                             value="#{bb.city}"/>

                   <h:outputLabel for="state" value="#{msgs.statePrompt}"/>
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
