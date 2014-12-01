package com.corejsf;

import javax.faces.event.PhaseListener;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.context.FacesContext;
import javax.faces.component.UIInput;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class AjaxPhaseListener implements PhaseListener {
    private static final String RICO_SCRIPT_REQUEST = "rico-script";
    private static final String PROTOTYPE_SCRIPT_FILE = "prototype.js";
    private static final String SCRIPTACULOUS_SCRIPT_FILE = "scriptaculous.js";
    private static final String RICO_SCRIPT_FILE = "rico-1.1.2.js";

    public PhaseId getPhaseId() {    // We need access to the view state
        return PhaseId.RESTORE_VIEW; // in afterPhase()
    }
    public void beforePhase(PhaseEvent phaseEvent) { // not interested
    }
    public void afterPhase(PhaseEvent phaseEvent) { // After the RESTORE VIEW phase
        FacesContext fc = FacesContext.getCurrentInstance();
        if(((HttpServletRequest)fc.getExternalContext()
                                  .getRequest()).getRequestURI()
                                  .contains(RICO_SCRIPT_REQUEST)) {
            try {
                readAndWriteFiles(fc, phaseEvent, new String[] {
                        PROTOTYPE_SCRIPT_FILE,
                        SCRIPTACULOUS_SCRIPT_FILE,
                        RICO_SCRIPT_FILE
                });
            }
            catch(java.io.IOException ex) {
                ex.printStackTrace();
            }
            phaseEvent.getFacesContext().responseComplete();
        }
    }
    // Should cache JS files...
    private void readAndWriteFiles(FacesContext fc, PhaseEvent phaseEvent, String[] filenames)
        throws java.io.IOException {
        HttpServletResponse response = Util.getResponse(fc);
        OutputStreamWriter outWriter = new OutputStreamWriter(response.getOutputStream(),
                                           response.getCharacterEncoding());
        for(String filename : filenames) {
            URL url = AjaxPhaseListener.class.getResource(filename);
            URLConnection conn = null;
            BufferedReader bufReader = null;
            String curLine = null;

            response.setContentType("text/javascript");
            response.setStatus(200);

            conn = url.openConnection();
            //conn.setUseCaches(false);
            bufReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            while (null != (curLine = bufReader.readLine())) {
                outWriter.write(curLine+"\n");
            }
        }
        outWriter.flush();
        outWriter.close();
    }
}
