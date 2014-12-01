package com.corejsf;

import javax.faces.event.PhaseListener;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.context.FacesContext;
import javax.faces.component.UIViewRoot;
import javax.faces.component.UIInput;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

public class AjaxPhaseListener implements PhaseListener {
    private static final String OKAY_MESSAGE  = "okay";

    public PhaseId getPhaseId() {    // We need access to the view state
        return PhaseId.RESTORE_VIEW; // in afterPhase()
    }

    public void beforePhase(PhaseEvent phaseEvent) { // not interested
    }

    public void afterPhase(PhaseEvent phaseEvent) {
        FacesContext   fc = FacesContext.getCurrentInstance();
        Map requestParams = fc.getExternalContext()
                              .getRequestParameterMap();
        String ajaxParam = (String)requestParams.get("ajax");

        if("true".equals(ajaxParam)) {
            UIViewRoot vr = fc.getViewRoot();
            UIInput   zip = (UIInput)vr.findComponent("form:zip");
            boolean valid = true;

            if(zip != null) {
                HttpServletResponse response =
                        (HttpServletResponse)fc.getExternalContext()
                                               .getResponse();
                Validator[] validators = zip.getValidators();
                String value = (String)requestParams.get("zip");

                PrintWriter writer = null;
                try {
                    writer = response.getWriter();
                }
                catch (java.io.IOException ex) {
                    ex.printStackTrace();
                }

                // Invoke all validators and catch exceptions
                for (int i = 0; i < validators.length; i++) {
                    Validator validator = validators[i];
                    try {
                        validator.validate(fc, zip, value);
                    }
                    catch (ValidatorException ve) {
                        writer.write(ve.getMessage());
                        valid = false;
                        break; // only handle the first validator exception
                    }
                }
                if(valid) {  // made it through validation okay
                    writer.write(OKAY_MESSAGE);
                }
            }
            fc.responseComplete(); // that's all for this response
        }
    }
}
