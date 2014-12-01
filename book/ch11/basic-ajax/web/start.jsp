<html>
    <%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
    <%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
    <f:view>
        <f:loadBundle basename="com.corejsf.messages" var="msgs"/>
        <head>
            <title><h:outputText value="#{msgs.windowTitle}"/></title>
            <link href="styles.css" rel="stylesheet" type="text/css"/>
            <script type="text/javascript" language="Javascript1.1">
                <!--
                var xhr;

                function showDateAndTime() { 
                    sendRequest("dateAndTime.ajax", // the URL
                                processAjaxCall);   // the callback function
                }

                function sendRequest(url, handler) {
                   initXHR();
                   xhr.onreadystatechange = handler; // set callback function
                   xhr.open("GET", url, true); // open asynchronous GET request
                   xhr.send(null); // send the request without params
                }

                function initXHR() {
                   if(window.XMLHttpRequest) {
                      xhr = new XMLHttpRequest();
                   }
                   else if(window.ActiveXObject) {
                      xhr = new ActiveXObject("Microsoft.XMLHTTP");
                   }
                }

                function processAjaxCall() {
                   if(xhr.readyState == 4) {  // if the request is finished...
                      if(xhr.status == 200) { // ...and everything's okay
                         // Get the dateDiv DIV and configure it
                         // with the response text
                        var dateDiv = window.document.getElementById("dateDIV");
                        dateDiv.innerHTML = xhr.responseText;
                      }
                   }
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
                <h:commandButton type="button"
                                value="#{msgs.buttonPrompt}"
                              onclick="showDateAndTime();"
                           styleClass="button"/>
            </h:form>

            <div id="dateDIV" class="dateDiv"/>
        </body>
    </f:view>
</html>
