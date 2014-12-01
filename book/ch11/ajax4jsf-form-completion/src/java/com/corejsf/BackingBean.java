package com.corejsf;

import javax.faces.event.ActionEvent;

public class BackingBean {
    private String zip;
    private String city;
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void clearCityAndState(ActionEvent e) {
        setCity("");
        setState("");
    }

    public void setCityAndStateForZip(ActionEvent e) {
        if (zip.equals("97402")) {
            setCity("Eugene");
            setState("Oregon");
        }
        else if(zip.equals("80132")) {
            setCity("Monument");
            setState("Colorado");
        }
        else {
            setCity("NO DATA");
            setState("NO DATA");
        }
    }
}
