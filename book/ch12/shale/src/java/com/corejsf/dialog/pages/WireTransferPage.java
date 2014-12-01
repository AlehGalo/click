package com.corejsf.dialog.pages;

import java.util.Map;
import javax.faces.context.FacesContext;
import org.apache.shale.dialog.Status;

public class WireTransferPage extends BaseDialogPage {
    // State constants

    private static final String BANK_INFORMATION = "Bank Information";
    private static final String ACCOUNT_INFORMATION = "Account Information";
    private static final String ACCOUNT_CONTACT = "Account Contact";
    private static final String SUMMARY = "Summary";

    // View logic for panels:

    public boolean isBankInformationRendered() {
       return stateEquals(BANK_INFORMATION);
    }
    public boolean isAccountInformationRendered() {
       return stateEquals(ACCOUNT_INFORMATION);
    }
    public boolean isAccountContactRendered() {
       return stateEquals(ACCOUNT_CONTACT);
    }
    public boolean isSummaryRendered() {
      return stateEquals(SUMMARY);
    }

    // View logic for buttons:

    public boolean isNextButtonEnabled() {
         return isStateOneOf(new String[] {
             BANK_INFORMATION, ACCOUNT_INFORMATION, ACCOUNT_CONTACT });
    }
    public boolean isPreviousButtonEnabled() {
        return isStateOneOf(new String[] {
             ACCOUNT_INFORMATION, ACCOUNT_CONTACT, SUMMARY });
    }
    public boolean isCancelButtonEnabled() {
         return true;
    }
    public boolean isFinishButtonEnabled() {
        return isStateOneOf(new String[] { SUMMARY });
    }

    // View logic for CSS styles:

    public String getBankInformationStyle() {
        return isBankInformationRendered() ?
            "selectedHeading" : "unselectedHeading";
    }
    public String getAccountInformationStyle() {
        return isAccountInformationRendered() ?
            "selectedHeading" : "unselectedHeading";
    }
    public String getAccountContactStyle() {
        return isAccountContactRendered() ?
            "selectedHeading" : "unselectedHeading";
    }
    public String getSummaryStyle() {
        return isSummaryRendered() ?
            "selectedHeading" : "unselectedHeading";
    }
}
