<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<html>
    <f:view>
       <head>
           <title><h:outputText value="#{msgs.windowTitle}"/></title>
           <link href="styles.css" rel="stylesheet" type="text/css"/>
           <script type="text/javascript" src="prototype.js"></script>
           <script type="text/javascript" src="fat.js"></script>
           <script type="text/javascript" language="Javascript1.1">
               <!--
                function zipBlurred(zip) {
                    if(zip.length != 5)
                        clearCityAndStateFields();
                    else {
                        new Ajax.Request("zipChanged.ajax",
                        {      method: "get",
                           parameters: "ajax=true&zip=" + zip,
                           onComplete: processZipCodeSelection
                        });
                    }
                }

                function zipChanged(zip) {
                    if(zip.length != 5) {
                       hideErrorsDiv();                       
                       return;
                    }

                    var jsfState = getJSFState();
                    new Ajax.Request(window.document.forms[0].action,
                    {      method: "post",
                       parameters: "ajax=true&zip=" 
                                   + zip 
                                   + "&javax.faces.ViewState=" 
                                   + jsfState,
                       onComplete: processRealtimeValidation
                    });
                }
                function getJSFState() {
                    var state = window.document
                                .getElementsByName("javax.faces.ViewState");
                    var value = null;

                    if(null != state && 0 < state.length) {
                        value = state[0].value;
                        var encodedValue = encodeURI(value);
                        var re = new RegExp("\\+", "g");
                        return encodedValue.replace(re, "\%2B");
                    }
                }
                function processRealtimeValidation(xhr) {
                    var rt = xhr.responseText;
                    if(xhr.responseText == "okay") {
                        hideErrorsDiv();
                    }
                    else {
                        showErrorsDiv(rt);
                    }
                }

                function processZipCodeSelection(xhr) {
                    var cityAndState = xhr.responseText.split(',');
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
                function hideErrorsDiv() {
                   var errors = $("errors");
                   errors.innerHTML = "";
                   errors.style.display = "none";
                   errors.style.padding = "0px";
                   errors.style.border = "none";
                   errors.style.fontSize = "0em";
                }
                function showErrorsDiv(msg) {
                   errors.style.display = "inline";
                   errors.style.color = "red";
                   errors.style.padding = "10px";
                   errors.style.border = "thin solid red;";
                   errors.style.fontSize = "1.5em";
                   errors.innerHTML = msg;
                   Fat.fade_element("errors", 60, 150, "#FF0000", null);
                }
           -->
        </script>
    </head>

    <body>
         <div class="banner">
            <h:outputText value="#{msgs.bannerText}"
               styleClass="bannerText"/>
         </div>

         <p><div id="errors" class="errors"></div></p>

         <h:form id="form">
            <p><h:outputText value="#{informationPrompt}"
                         styleClass="heading"/><p>

            <h:panelGrid columns="2">
                 <h:outputLabel for="zip" value="Zip Code"/>
                 <h:panelGroup>
                    <h:inputText id="zip"
                                size="5"
                               value="#{bb.zip}"
                             onfocus="clearCityAndStateFields();"
                              onblur="zipBlurred(this.value);"
                             onkeyup="zipChanged(this.value);">
                         <f:validator 
                            validatorId="com.corejsf.ZipCodeValidator"/>
                     </h:inputText>
                     <h:message for="zip" styleClass="inlineErrors"/>
                 </h:panelGroup>

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
