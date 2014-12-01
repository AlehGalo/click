package com.corejsf;

import javax.faces.event.ActionEvent;

public class UIPreferences {
    private boolean trace = false;

    public boolean isTrace() {
        return trace;
    }

    public void setTrace(boolean trace) {
        this.trace = trace;
    }

    public boolean getShowFacesTrace() {
        return trace;
    }

    public void toggleFacesTrace(ActionEvent e) {
        if (trace) trace = false;
        else                trace = true;
    }
}