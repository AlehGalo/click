package com.corejsf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.sql.DataSource;

public class UserBean {
   private String name;
   private String password;
   private boolean loggedIn;
   private Logger logger = Logger.getLogger("com.corejsf");
   
   @Resource(name="jdbc/mydb")
   private DataSource ds;
   
   /*
   If you use Tomcat or JSF 1.1, remove the @Resource line and add this constructor:
   public UserBean()
   {
      try {
         Context ctx = new InitialContext();
         ds = (DataSource) ctx.lookup("java:comp/env/jdbc/mydb");
      } catch (NamingException ex) {
         logger.log(Level.SEVERE, "DataSource lookup failed", ex);
      }
   }
   */

   public String getName() { return name; }
   public void setName(String newValue) { name = newValue; }

   public String getPassword() { return password; }
   public void setPassword(String newValue) { password = newValue; }

   public String login() {
      try {
         doLogin();
      }
      catch (SQLException ex) {
         logger.log(Level.SEVERE, "login failed", ex);
         return "internalError";
      }
      if (loggedIn)
         return "loginSuccess";
      else 
         return "loginFailure";
   }

   public String logout() { 
      loggedIn = false;
      return "login";
   }

   public void doLogin() throws SQLException {  
      if (ds == null) throw new SQLException("No data source");      
      Connection conn = ds.getConnection();
      if (conn == null) throw new SQLException("No connection");

      try {
         PreparedStatement passwordQuery = conn.prepareStatement(
            "SELECT password from Users WHERE username = ?");

         passwordQuery.setString(1, name);
         
         ResultSet result = passwordQuery.executeQuery();

         if (!result.next()) return;
         String storedPassword = result.getString("password");                
         loggedIn = password.equals(storedPassword.trim());
      }
      finally {      
         conn.close();
      }
   }
}
