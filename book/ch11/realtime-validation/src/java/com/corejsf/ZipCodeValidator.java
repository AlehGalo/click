package com.corejsf;

import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;
import javax.faces.application.FacesMessage;

public class ZipCodeValidator implements Validator {
    public void validate(FacesContext facesContext,
                         UIComponent uiComponent, Object value)
            throws ValidatorException {
        if(!"97402".equals(value))
           throw new ValidatorException(
              new FacesMessage("Validation Failed!"));
    }
}
