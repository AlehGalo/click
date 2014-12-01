<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<f:view>
    <html>
      <head>
         <title>Users</title>
         <link href="styles.css" type="text/css" rel="stylesheet"/>
      </head>
      <body>
          <div class="heading"><h:outputText value="Address Book"
                    styleClass="headingText"/></div>
          <h:form><p>
              <h:dataTable value="#{contacts}"
                             var="currentContact"
                      styleClass="contacts"
                      rowClasses="contactsEvenRow, contactsOddRow">
                  <h:column>
                      <h:commandButton value="delete"
                                      action="#{addressBook.delete}"/>
                  </h:column>
                  <h:column>
                      <f:facet name="header">
                          <h:outputText value="Name"/>
                      </f:facet>
                      <h:commandLink value="#{currentContact.name}"
                                    action="#{addressBook.setupEdit}"/>
                  </h:column>

                  <h:column>
                      <f:facet name="header">
                          <h:outputText value="Street Address"/>
                      </f:facet>
                      <h:outputText value="#{currentContact.streetAddress}"/>
                  </h:column>

                  <h:column>
                      <f:facet name="header">
                          <h:outputText value="City"/>
                      </f:facet>
                      <h:outputText value="#{currentContact.city}"/>
                  </h:column>

                  <h:column>
                      <f:facet name="header">
                          <h:outputText value="State"/>
                      </f:facet>
                      <h:outputText value="#{currentContact.state}"/>
                  </h:column>

                  <h:column>
                      <f:facet name="header">
                          <h:outputText value="Country"/>
                      </f:facet>
                      <h:outputText value="#{currentContact.country}"/>
                  </h:column>
              </h:dataTable></p>
              <h:commandLink value="Create more contacts..." action="addContact"/>
          </h:form>
      </body>
    </html>
</f:view>