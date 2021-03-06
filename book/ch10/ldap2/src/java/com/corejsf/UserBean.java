package com.corejsf;

import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.NameNotFoundException;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class UserBean {
   private Name name;
   private String id;
   private String email;
   private String password;
   private Logger logger = Logger.getLogger("com.corejava");

   public UserBean() { name = new Name(); } 

   public DirContext getRootContext() throws NamingException {
      ExternalContext external 
         = FacesContext.getCurrentInstance().getExternalContext();

      String managerDN = external.getInitParameter("managerDN");
      String managerPW = external.getInitParameter("managerPassword");
      String url = external.getInitParameter("URL");
      
      Hashtable<String, String> env = new Hashtable<String, String>();
      env.put(Context.SECURITY_PRINCIPAL, managerDN);
      env.put(Context.SECURITY_CREDENTIALS, managerPW);
      DirContext initial = new InitialDirContext(env);

      Object obj = initial.lookup(url);
      if (!(obj instanceof DirContext))
         throw new NamingException("No directory context");
      return (DirContext) obj;
   }
  
   public Name getName() { return name; }
   public void setName(Name newValue) { name = newValue; }

   public String getEmail() { return email; }
   public void setEmail(String newValue) { email = newValue; }

   public String getId() { return id; }
   public void setId(String newValue) { id = newValue; }

   public String getPassword() { return password; }
   public void setPassword(String newValue) { password = newValue; }

   public String login() {
      try {
         DirContext context = getRootContext();
         try {
            String dn = "uid=" + id + ",ou=people,dc=corejsf,dc=com";
            Attributes userAttributes = context.getAttributes(dn); 
            String cn = (String) userAttributes.get("cn").get();
            name.parse(cn);
            email = (String) userAttributes.get("mail").get();
            byte[] pw = (byte[]) 
               userAttributes.get("userPassword").get();
            if (password.equals(new String(pw)))
               return "login_success";
            else
               return "login_failure";
         } finally {
            context.close();
         }         
      }
      catch (NamingException ex) {
         logger.log(Level.SEVERE, "loginAction", ex);
         return "login_error";
      }
   }

   public String signup() {
      try {
         DirContext context = getRootContext();
         try {
            String dn = "uid=" + id + ",ou=people,dc=corejsf,dc=com";

            try {
               context.lookup(dn); 
               return "signup_failure";
            }
            catch (NameNotFoundException ex) {}

            Attributes attrs = new BasicAttributes();
            attrs.put("objectClass", "inetOrgPerson");
            attrs.put("uid", id);
            attrs.put("sn", name.getLast());
            attrs.put("cn", name.toString());
            attrs.put("mail", email);
            attrs.put("userPassword", password.getBytes());
            context.createSubcontext(dn, attrs);
         } finally {
            context.close();
         }         
      }
      catch (NamingException ex) {
         logger.log(Level.SEVERE, "loginAction", ex);
         return "signup_error";
      }

      return "signup_success";
   }

   public String update() {
      try {
         DirContext context = getRootContext();
         try {
            String dn = "uid=" + id + ",ou=people,dc=corejsf,dc=com";
            Attributes attrs = new BasicAttributes();
            attrs.put("sn", name.getLast());
            attrs.put("cn", name.toString());
            attrs.put("mail", email);
            attrs.put("userPassword", password.getBytes());
            context.modifyAttributes(dn, 
               DirContext.REPLACE_ATTRIBUTE, attrs);
         } finally {
            context.close();
         }         
      }
      catch (NamingException ex) {
         logger.log(Level.SEVERE, "updateAction", ex);
         return "internal_error";
      }

      return "update_success";
   }

   public String logout() {      
      password = "";
      return "logout_success";
   }
}
