package com.corejsf.rico;

import javax.faces.webapp.UIComponentELTag;
import javax.faces.component.UIComponent;
import com.corejsf.util.Tags;

public class AccordionTag extends UIComponentELTag {
    private String name = null;
    private String panelHeight  = "100";
    private String styleClass   = null;
    private String panelClass   = null;
    private String headerClass  = null;
    private String contentClass = null;
    
    public String getComponentType() {
        return "com.corejsf.rico.Accordion";
    }

    public String getRendererType() {
        return "com.corejsf.rico.AccordionRenderer";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPanelHeight() {
        return panelHeight;
    }

    public void setPanelHeight(String panelHeight) {
        this.panelHeight = panelHeight;
    }

    public String getStyleClass() {
        return styleClass;
    }

    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
    }

    public String getPanelClass() {
        return panelClass;
    }

    public void setPanelClass(String panelClass) {
        this.panelClass = panelClass;
    }

    public String getHeaderClass() {
        return headerClass;
    }

    public void setHeaderClass(String headerClass) {
        this.headerClass = headerClass;
    }

    public String getContentClass() {
        return contentClass;
    }

    public void setContentClass(String contentClass) {
        this.contentClass = contentClass;
    }

    public void release() {
        super.release();
        name = panelHeight = styleClass =
        panelClass = contentClass = null;
    }

    protected void setProperties(UIComponent component) {
        super.setProperties(component);
        Tags.setString(component, "name", name);
        Tags.setString(component, "panelHeight", panelHeight);
        Tags.setString(component, "styleClass", styleClass);
        Tags.setString(component, "panelClass", panelClass);
        Tags.setString(component, "headerClass", headerClass);
        Tags.setString(component, "contentClass", contentClass);
    }
}
