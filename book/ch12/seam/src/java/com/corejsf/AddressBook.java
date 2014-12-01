package com.corejsf;

import javax.ejb.Local;

@Local
public interface AddressBook {
   public String addToBook();
   public String delete();
   public String setupEdit();
   public String edit();
   public void findContacts();
}
