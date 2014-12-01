package com.corejsf;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.ScopeType;

@Entity
@Name("contact")
@Scope(ScopeType.EVENT)
@Table(name="contacts")
public class Contact implements Serializable {
    private static final long serialVersionUID = 48L;

    private String name, streetAddress, city;
    private String state, country;

    public Contact(String name) {
       this.name = name;
    }

    public Contact() {}

    @Id @NotNull @Length(min=5, max=25)
    public String getName() {
       return name;
    }

    public void setName(String name) {
       this.name = name;
    }

    public String toString() {
       return "Contact(" + name + ")";
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
