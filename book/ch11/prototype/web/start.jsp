<html>
    <%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
    <%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
    <f:view>
        <head>
            <title><h:outputText value="#{msgs.windowTitle}"/></title>
            <link href="styles.css" rel="stylesheet" type="text/css"/>
            <script type="text/javascript" src="prototype.js"></script>
            <script type="text/javascript" language="Javascript1.1">
                <!--
                function showDateAndTime() {
                    new Ajax.Updater("dateDIV", // DIV to update
                                     "dateAndTime.ajax", // URL
                                     { method: "get" }); // HTTP method
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
