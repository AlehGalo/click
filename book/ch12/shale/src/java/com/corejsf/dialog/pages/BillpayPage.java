package com.corejsf.dialog.pages;

import java.util.Map;
import javax.faces.context.FacesContext;
import javax.faces.component.UISelectOne;

import org.apache.shale.dialog.Status;

public class BillpayPage extends BaseDialogPage {
    // State constants must match state names in payment.xml

    private static final String PAYEE_INFORMATION = "Payee Information";
    private static final String PAYMENT_METHOD    = "Payment Method";
    private static final String PAYMENT_SCHEDULE  = "Payment Schedule";
    private static final String SUMMARY           = "Summary";

    // View logic for panels:

    public boolean isPayeeRendered() {
      return stateEquals(PAYEE_INFORMATION);
    }
    public boolean isPaymentMethodRendered() {
      return stateEquals(PAYMENT_METHOD);
    }
    public boolean isPaymentScheduleRendered() {
      return stateEquals(PAYMENT_SCHEDULE);
    }
    public boolean isSummaryRendered() {
      return stateEquals(SUMMARY);
    }

    // View logic for buttons:

    public boolean isNextButtonEnabled() {
        return isStateOneOf(new String[] {
            PAYEE_INFORMATION, PAYMENT_METHOD, PAYMENT_SCHEDULE });
    }
    public boolean isPreviousButtonEnabled() {
        return isStateOneOf(new String[] {
            PAYMENT_METHOD, PAYMENT_SCHEDULE, SUMMARY });
    }
    public boolean isCancelButtonEnabled() {
        return true;
    }
    public boolean isFinishButtonEnabled() {
        return isStateOneOf(new String[] { SUMMARY });
    }

    // View logic for CSS style names

    public String getPayeeStyle() {
       return isPayeeRendered() ?
          "selectedHeading" : "unselectedHeading";
    }

    public String getPaymentMethodStyle() {
        return isPaymentMethodRendered() ?
           "selectedHeading" : "unselectedHeading";
    }

    public String getPaymentScheduleStyle() {
        return isPaymentScheduleRendered() ?
           "selectedHeading" : "unselectedHeading";
    }

    public String getSummaryStyle() {
        return isSummaryRendered() ?
           "selectedHeading" : "unselectedHeading";
    }
}
