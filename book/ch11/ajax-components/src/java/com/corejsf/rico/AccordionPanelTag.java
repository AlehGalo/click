package com.corejsf.rico;

import javax.faces.webapp.UIComponentELTag;
import javax.faces.component.UIComponent;
import com.corejsf.util.Tags;

public class AccordionPanelTag extends UIComponentELTag {
    private String heading = null;
    private String styleClass = null;

    public String getComponentType() {
        return "com.corejsf.rico.AccordionPanel";
    }

    public String getRendererType() {
        return "com.corejsf.rico.AccordionPanelRenderer";
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getStyleClass() {
        return styleClass;
    }

    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
    }

    public void release() {
        super.release();
        heading = styleClass = null;
    }

    protected void setProperties(UIComponent component) {
        super.setProperties(component);
        Tags.setString(component, "heading", heading);
        Tags.setString(component, "styleClass", styleClass);
    }
}
