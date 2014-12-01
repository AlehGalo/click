package com.corejsf.dialog.data;

import com.corejsf.dialog.pages.BillpayPage;
import javax.faces.model.SelectItem;

/*
 This class contains four things:

 1. Properties for all data in the bill payment dialog
 2. JSF action methods (finish() and navigateTransfer())
 3. A page object (instance of BillpayPage, controls context sensitivity)
 4. A transfer object (instance of WireTransferData)

 All four of the items listed above are accessed
 directly in JSP pages; for example:

 <h:inputText value="#{dialog.data.city}"/>
 <h:commandButton action="#{dialog.data.finish}"/>
 <h:inputText value="#{dialog.data.transfer.bankName}"/>
 <h:panelGrid rendered="#{dialog.data.page.payeeRendered}"/>
*/

public class BillpayData {
    // Dialog properties
    private String streetAddress = "86 E. Amherst St.";
    private String city = "Buffalo";
    private String state = "New York";
    private String zip = "14218";
    private String name="Clarity Training, Inc.";
    private double paymentAmount = 2000;
    private String paymentMethod = "Wire Transfer";
    private String paymentSchedule = "One time";

    // transfer and page properties
    private Object transfer = null; // Embedded transfer method object
    private Object page = null; // UI context sensitivity (read-only)

    // The SelectItem arrays are for UI components
    private static SelectItem[] paymentMethodItems = {
        new SelectItem("Wire Transfer"),
        new SelectItem("Wire Transfer"),
        new SelectItem("Wire Transfer"),
    };
    private SelectItem[] paymentScheduleItems = {
        new SelectItem("One time"),
        new SelectItem("Weekly"),
        new SelectItem("Monthly")
    };

    // Transfer object (instance of WireTransferData)
    public Object getTransfer() {
        return transfer;
    }
    public void setTransfer(Object newValue) {
        transfer = newValue;
    }

    // Page object (instance of BillpayPage)
    public Object getPage() {
        if (page == null)
            page = new BillpayPage();

        return page;
    }

    // JSF Action methods
    public String finish() { // finish the dialog
       return "finish";
    }
    public String navigateTransfer() { // start the payment method subdialog
        return paymentMethod;          // based on the paymentMethod property
    }

    // Property setters and getters
    public SelectItem[] getPaymentMethodItems() {
       return paymentMethodItems;
    }

    public SelectItem[] getPaymentScheduleItems() {
        return paymentScheduleItems;
    }

    public void setName(String newValue) {
        name = newValue;
    }
    public String getName() {
        return name;
    }

    public void setStreetAddress(String newValue) {
        streetAddress = newValue;
    }
    public String getStreetAddress() {
        return streetAddress;
    }

    public void setZip(String newValue) {
        zip = newValue;
    }
    public String getZip() {
        return zip;
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

    public double getPaymentAmount() {
        return paymentAmount;
    }
    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentSchedule() {
        return paymentSchedule;
    }
    public void setPaymentSchedule(String paymentSchedule) {
        this.paymentSchedule = paymentSchedule;
    }
}