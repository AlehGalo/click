package com.alfa.click.webservice.server;

import java.io.Serializable;
import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for widget complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="widget">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="widgetid" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="label" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="params" type="{http://server.webservice.click.alfa.com/}params"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "widget", propOrder = { "widgetid", "label", "params" })
public class Widget implements Serializable {

	/**
	 * Default serial version id.
	 */
	private static final long serialVersionUID = 1L;

	@XmlElement(required = true)
	protected BigInteger widgetid;

	@XmlElement(required = true)
	protected String label;

	@XmlElement(required = true)
	protected Params params;

	/**
	 * Gets the value of the widgetid property.
	 * 
	 * @return possible object is {@link BigInteger }
	 * 
	 */
	public BigInteger getWidgetid() {
		return widgetid;
	}

	/**
	 * Sets the value of the widgetid property.
	 * 
	 * @param value
	 *            allowed object is {@link BigInteger }
	 * 
	 */
	public void setWidgetid(final BigInteger value) {
		this.widgetid = value;
	}

	/**
	 * Gets the value of the label property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Sets the value of the label property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLabel(final String value) {
		this.label = value;
	}

	/**
	 * Gets the value of the params property.
	 * 
	 * @return possible object is {@link Params }
	 * 
	 */
	public Params getParams() {
		return params;
	}

	/**
	 * Sets the value of the params property.
	 * 
	 * @param value
	 *            allowed object is {@link Params }
	 * 
	 */
	public void setParams(final Params value) {
		this.params = value;
	}

}
