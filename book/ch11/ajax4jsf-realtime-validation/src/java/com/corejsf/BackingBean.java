package com.corejsf;

import javax.faces.event.ActionEvent;
import javax.faces.context.FacesContext;
import javax.faces.component.UIInput;
import javax.faces.application.FacesMessage;
import java.util.Iterator;

public class BackingBean {
    private String zip;
    private String city;
    private String state;
    private String errorMessage = null;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

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

    public void clearErrorMessage(ActionEvent e) {
        errorMessage = null;
    }

    // AJAX

    /* cityInput and stateInput are set by component
     * bindings in the view:
     *
     * <h:inputText id="city" binding="#{bb.cityInput}"
     *            size="25"
     *           value="#{bb.city}"/>
     *
     * <h:inputText id="state" binding="#{bb.stateInput}"
     *            size="15"
     *           value="#{bb.state}"/>
     *
     */
    private UIInput cityInput = null; // cityInput
    public UIInput getCityInput() {
        return cityInput;
    }
    public void setCityInput(UIInput cityInput) {
        this.cityInput = cityInput;
    }

    private UIInput stateInput = null; // stateInput
    public UIInput getStateInput() {
        return stateInput;
    }
    public void setStateInput(UIInput stateInput) {
        this.stateInput = stateInput;
    }


    /* validateZip is called by Ajax4jsf in response to
     * an onblur in the zip code textfield:
     *
     * <a4j:support event="onblur"
     *          immediate="true"
     *     actionListener="#{bb.validateZip}"
     *           reRender="city, state, errorMessage"/>
    */
    public void validateZip(ActionEvent e) {
        // This executes too fast to see the busy indicator in
        // the view, so we slow it down
        try {
            Thread.sleep(250);
        }
        catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        UIInput input = (UIInput)e.getComponent() // Ajax4jsf comp
                                  .getParent();   // input comp
        if (input != null) {
            String zip = (String)input.getSubmittedValue();
            if (zip != null) {
                // set city and state properties according
                // to the zip field's submitted value
                setCityAndState(zip);

                // validate the zip field
                FacesContext fc = FacesContext.getCurrentInstance();
                input.validate(fc); // iterates over input's validators
                if ( ! input.isValid())
                    setErrorMessage(fc, input);

                // Force JSF to refresh city and state input fields.
                // If an input component's submitted value is not null,
                // JSF will not refresh the field.
                cityInput.setSubmittedValue(null);
                stateInput.setSubmittedValue(null);
            }
        }
    }
    private void setErrorMessage(FacesContext fc, UIInput input) {
        // set errorMessage to the first message for the zip field
        Iterator it = fc.getMessages(input.getClientId(fc));
        if (it.hasNext()) {
           FacesMessage facesMessage = (FacesMessage)it.next();
           errorMessage = facesMessage.getSummary();
        }
    }
    private void setCityAndState(String zip) {
        String cityAndState = ZipcodeDatabase.getCityAndState(zip);
        if (cityAndState != null) { // zip recognized
            String[] cityStateArray = cityAndState.split(",");
            setCity(cityStateArray[0]);
            setState(cityStateArray[1]);
        }
        else { // unknown zip with 5 chars
            if (zip.length() == 5) {
                setCity ("no data for " + zip);
                setState("no data for " + zip);
            }
            else { // unknown zip without 5 chars
                setCity(null);
                setState(null);
            }
        }
    }
}