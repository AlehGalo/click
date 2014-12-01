package com.corejsf.dialog.pages;

import java.util.Map;
import javax.faces.context.FacesContext;

import org.apache.shale.dialog.Status;

// Convenience methods for determining the current dialog state

public class BaseDialogPage {
   protected BaseDialogPage() {
       // protected constructor means
       // this is a base class only...
   }
   protected boolean stateEquals(String stateName) {
        return stateName.equals(getCurrentState());
   }
   protected boolean isStateOneOf(String[] these) {
      String currentState = getCurrentState();

      for (String nextState : these) {
        if(nextState.equals(currentState))
          return true;
      }
      return false;
   }
   private String getCurrentState() {
       return getDialogStatus().getStateName();
   }
   private Status getDialogStatus() {
       Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
                                    .getExternalContext()
                                    .getSessionMap();
       return (Status)sessionMap.get(org.apache.shale.dialog.Globals.STATUS);
   }
}
