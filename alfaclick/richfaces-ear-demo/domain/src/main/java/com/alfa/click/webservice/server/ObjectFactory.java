
package com.alfa.click.webservice.server;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.alfa.click.webservice.server package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetWidgets_QNAME = new QName("http://server.webservice.click.alfa.com/", "getWidgets");
    private final static QName _GetWidgetsResponse_QNAME = new QName("http://server.webservice.click.alfa.com/", "getWidgetsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.alfa.click.webservice.server
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Params }
     * 
     */
    public Params createParams() {
        return new Params();
    }

    /**
     * Create an instance of {@link GetWidgetsResponse }
     * 
     */
    public GetWidgetsResponse createGetWidgetsResponse() {
        return new GetWidgetsResponse();
    }

    /**
     * Create an instance of {@link Widgets }
     * 
     */
    public Widgets createWidgets() {
        return new Widgets();
    }

    /**
     * Create an instance of {@link Widget }
     * 
     */
    public Widget createWidget() {
        return new Widget();
    }

    /**
     * Create an instance of {@link GetWidgets }
     * 
     */
    public GetWidgets createGetWidgets() {
        return new GetWidgets();
    }

    /**
     * Create an instance of {@link SelectItem }
     * 
     */
    public SelectItem createSelectItem() {
        return new SelectItem();
    }

    /**
     * Create an instance of {@link Params.Param }
     * 
     */
    public Params.Param createParamsParam() {
        return new Params.Param();
    }

    /**
     * Create an instance of {@link GetWidgetsResponse.Return }
     * 
     */
    public GetWidgetsResponse.Return createGetWidgetsResponseReturn() {
        return new GetWidgetsResponse.Return();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWidgets }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.click.alfa.com/", name = "getWidgets")
    public JAXBElement<GetWidgets> createGetWidgets(GetWidgets value) {
        return new JAXBElement<GetWidgets>(_GetWidgets_QNAME, GetWidgets.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWidgetsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.click.alfa.com/", name = "getWidgetsResponse")
    public JAXBElement<GetWidgetsResponse> createGetWidgetsResponse(GetWidgetsResponse value) {
        return new JAXBElement<GetWidgetsResponse>(_GetWidgetsResponse_QNAME, GetWidgetsResponse.class, null, value);
    }

}
