<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<f:subview id="lookWhatYouCanDo">
    <div class="accordionFiller">
        You can put anything you like in the content region of an
        accordion's panels; for example, in this panel we have a
        JSF form which you can submit. The form acts just like
        any other form. So, you can put whatever you like
        in these panels.
        <p>Also notice that the Rico component automatically adds
        a scrollbar to an accordion panel when its content overflows
        the panel.</p>
    </div>

    <h:form>
        <h:panelGrid columns="2">
            <h:outputText value="City: "/>
            <h:inputText value="#{bb.city}" size="20"/>

            <h:outputText value="State: "/>
            <h:inputText value="#{bb.state}" size="15"/>

            <h:outputText value="Zip: "/>
            <h:inputText value="#{bb.zip}" size="5"/>

            <h:outputText value="&nbsp;" escape="false"/>
            <h:commandButton action="welcome" value="Submit"/>
        </h:panelGrid>
    </h:form>
</f:subview>