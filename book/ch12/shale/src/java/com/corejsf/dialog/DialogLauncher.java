package com.corejsf.dialog;

import org.apache.shale.view.AbstractFacesBean;
import com.corejsf.dialog.data.BillpayData;
import com.corejsf.dialog.data.WireTransferData;

public class DialogLauncher extends AbstractFacesBean {
    // billpayData contains all of the properties for the
    // payment dialog. It also contains a couple of JSF
    // action methods used for navigation, and an
    // embedded wire transfer data object
    private BillpayData billpayData = null;

    // Called just afer entering the payment dialog
    public String setupPaymentDialog() {
       // Create billpay data and nested wire transfer data
       billpayData = new BillpayData();
       billpayData.setTransfer(new WireTransferData());

       // Set dialog data with the handy setValue method
       // from org.apache.shale.view.AbstractFacesBean
       setValue("#{dialog.data}", billpayData);

       // This outcome takes us to the payment dialog's
       // first view
       return "success";
    }

    // Called just afer entering the wire transfer dialog
    public String setupWireTransferDialog() {
       // Set the dialog's data to the wire transfer object
       // stored in the bill pay data
       setValue("#{dialog.data}", billpayData.getTransfer());

       // This outcome takes us to the wire transfer dialog's
       // first view
       return "success";
    }
}
