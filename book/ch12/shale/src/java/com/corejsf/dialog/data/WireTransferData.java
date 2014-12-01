package com.corejsf.dialog.data;

import com.corejsf.dialog.pages.WireTransferPage;

// This class contains properties for the wire
// transfer dialog. In addition, it contains a page
// object (instance of WireTransferPage) that controls
// context sensitivity for buttons and tabs in the UI.

public class WireTransferData {
    // Properties set in the wire transfer dialog
    private String bankName="First Bank";
    private String streetAddress = "124 Oak Lane";
    private String city = "Buffalo";
    private String state = "New York";
    private String zip = "14214";
    private String bankKey = "019983458";
    private String bankAccountNumber = "7790822148766";
    private String bankAccountName = "Clarity Training";
    private String recipient = "James Wilson";
    private String recipientTelephone = "907.886.9987";
    private String recipientEmail = "james@wilson.org";
    private Object page = null; // page object (read-only)

    // The page object
    public Object getPage() {
        if (page == null)
            page = new WireTransferPage();
        return page;
    }

    // Dialog property setters and getters
    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setStreetAddress(String newValue) {
        streetAddress = newValue;
    }
    public String getStreetAddress() {
        return streetAddress;
    }

    public void setCity(String newValue) {
        city = newValue;
    }
    public String getCity() {
        return city;
    }

    public void setState(String newValue) {
        state = newValue;
    }
    public String getState() {
        return state;
    }

    public void setZip(String newValue) {
        zip = newValue;
    }
    public String getZip() {
        return zip;
    }

    public String getBankKey() {
        return bankKey;
    }
    public void setBankKey(String bankKey) {
        this.bankKey = bankKey;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }
    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }
    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getRecipient() {
        return recipient;
    }
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getRecipientTelephone() {
        return recipientTelephone;
    }
    public void setRecipientTelephone(String recipientTelephone) {
        this.recipientTelephone = recipientTelephone;
    }

    public String getRecipientEmail() {
        return recipientEmail;
    }
    public void setRecipientEmail(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }

    public String finish() {
        return "success";
    }
}