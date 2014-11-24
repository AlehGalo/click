
package com.alfa.click.webservice.server.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getWidgetsResponse", namespace = "http://server.webservice.click.alfa.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getWidgetsResponse", namespace = "http://server.webservice.click.alfa.com/")
public class GetWidgetsResponse {

    @XmlElement(name = "return", namespace = "")
    private com.alfa.click.webservice.server.Widgets _return;

    /**
     * 
     * @return
     *     returns Widgets
     */
    public com.alfa.click.webservice.server.Widgets getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(com.alfa.click.webservice.server.Widgets _return) {
        this._return = _return;
    }

}
