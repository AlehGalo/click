package com.corejsf;

import java.util.List;
import java.io.Serializable;

import javax.ejb.Interceptors;
import javax.ejb.Stateful;
import javax.ejb.Remove;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.jboss.seam.annotations.*;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.annotations.datamodel.DataModelSelection;
import org.jboss.seam.ejb.SeamInterceptor;
import org.jboss.seam.ScopeType;

// The class annotations that follow specify that this is a
// stateful session bean, named addressBook, that Seam will
// store in session scope.
@Stateful
@Scope(ScopeType.SESSION)
@Name("addressBook")
@Interceptors(SeamInterceptor.class)
public class AddressBookAction implements Serializable, AddressBook {
   // In a JSP, doing this...
   //   <h:dataTable value="#{contacts}...>...</h:dataTable>
   // ...will cause Seam to intervene and call the contacts
   // factory method, defined with the @Factory annotation below.
   //
   // Seam only calls that method once--the first time it
   // encounters #{contacts}, so we also export the contacts
   // variable with the @Out annotation.
   //
   // By exporting the contacts variable, Seam exports
   // (or 'outjects', if you must) that variable to page
   // scope every time a method in this class returns.
   //
   // Actually, the preceeding paragraph is not exactly accurate:
   // Seam doesn't export the contacts variable; instead, it
   // wraps that variable in a JSF DataModel.
   @DataModel
   @Out(required=false)
   private List<Contact> contacts;

   // This @DataModelSelection annotation is linked to
   // the preceeding @DataModel annotation. When someone
   // makes a selection from the contacts list that results
   // in a call to the @Begin method, defined below,
   // Seam outjects (UGH) the selectedContact to CONVERSATION
   // scope. The selectedContact is available to all views
   // until the @End method is called. When that method exits
   // Seam takes the selectedContact out of conversation scope.
   // We also tell Seam to inject the selectedContact when
   // the conversation begins so we can access it in the
   // @End method. DID YOU GET ALL THAT?!? 8-)
   @DataModelSelection
   @In(required=false)
   @Out(required=false, scope=ScopeType.CONVERSATION)
   private Contact selectedContact;

   // Inject the contact variable when it's in scope (which
   // is only when we invoke an action method from the
   // addContact.jsp view). In fact, the only such method
   // is addToBook(), which adds the contact, an entity bean
   // that sprung into existance when the user loaded
   // addContact.jsp, to the address book.
   @In(required=false)
   private Contact contact;

   // This is the factory method for the contacts variable
   // declared above. It's called only once, remember, which
   // is why we need that @Out(required=false) annotation
   // above on the contacts variable. Without that annotation,
   // views would never see the updated version of the
   // contacts list after the user adds a contact.
   @Factory("contacts")
   public void findContacts() {
       contacts = (List<Contact>)em.createQuery("from Contact")
         .getResultList();
   }

   // We use the entity manager in this class to do some
   // queries. That, after all, is why this class is an
   // EJB.
   @PersistenceContext(type= PersistenceContextType.EXTENDED)
   private EntityManager em;

   // Seam injects the faces context before each method
   // in this class is invoked.
   @In
   private FacesContext facesContext;

   // This JSF action method is caled from the addContact.jsp
   // view, which accesses the contact managed bean, which
   // is a request-scoped entity bean. This method saves that
   // bean to the database if it's not already there.
   @IfInvalid(outcome=Outcome.REDISPLAY)
   public String addToBook() {
      List<Contact> existing = (List<Contact>)em.createQuery(
          "select name from Contact where name=:name")
         .setParameter("name", contact.getName())
         .getResultList();

      if (existing.size()==0) {
         // save to the database if the contact doesn't
         // already exist
         em.persist(contact);
         contacts = (List<Contact>)em.createQuery
				 ("from Contact").getResultList();
         return "success";
      }
      else {
         facesContext.addMessage(null,
            new FacesMessage("contact already exists"));
         return null;
      }
   }

   // This method begins the short conversation for editing
   // an existing contact
   @Begin
   public String setupEdit() {
       // Seam "outjects" the selectedContact object to
       // CONVERSATIONAL scope, and this method is annotated
       // to begin a conversation. The selectedContact object
       // is available in views until the edit method--which
       // is annotated as the end of the conversation--returns
       return "edit";
   }

   // This method signifies the end of the 'edit contact'
   // conversation.
   @End
   public String edit() {
       // At the end of this conversation, we save
       // the contact that's been edited. The 'edited' outcome
       // is not wired to any view, so the same page
       // (addressBook.jsp) redisplays
       em.persist(selectedContact);
       contacts = (List<Contact>)em.createQuery(
           "from Contact").getResultList();
       return "edited";
   }

   // This method is called from addressBook.jsp.
   public String delete() {
       // Deletes the selected contact from the database
       contacts.remove(selectedContact);
       em.remove(selectedContact);
       return "deleted";
   }

   // All Seam session beans must have a method annotated
   // with @Remove and @Destroy. That method should clean
   // up extraneous state.
   @Remove @Destroy
   public void destroy() {}
}
