package com.corejsf;

import com.corejsf.util.Messages;

import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;
import javax.faces.validator.ValidatorException;
import javax.faces.validator.Validator;

public class ZipcodeValidator implements Validator {
    public void validate(FacesContext fc,
                         UIComponent c,
                         Object zip)
        throws ValidatorException {
        String cityAndState = ZipcodeDatabase
                              .getCityAndState((String)zip);

        if (cityAndState == null) {
            throw new ValidatorException(
                Messages.getMessage("com.corejsf.messages",
                                    "badZip"));
        }
    }
}
