package com.alfa.click.webservice.server;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for params complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="params">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="param" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="paramid" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                   &lt;element name="type" type="{http://server.webservice.click.alfa.com/}widgetType"/>
 *                   &lt;element name="selectItems" type="{http://server.webservice.click.alfa.com/}selectItem" minOccurs="0"/>
 *                   &lt;element name="default" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="label" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="mode" type="{http://server.webservice.click.alfa.com/}modeType"/>
 *                   &lt;element name="hint" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "params", propOrder = { "param" })
public class Params implements Serializable {

	/**
	 * Default serial version id.
	 */
	private static final long serialVersionUID = 1L;

	@XmlElement(nillable = true)
	protected List<Params.Param> param;

	/**
	 * Gets the value of the param property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the param property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getParam().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link Params.Param }
	 * 
	 * 
	 */
	public List<Params.Param> getParam() {
		if (param == null) {
			param = new ArrayList<Params.Param>();
		}
		return this.param;
	}

	/**
	 * <p>
	 * Java class for anonymous complex type.
	 * 
	 * <p>
	 * The following schema fragment specifies the expected content contained
	 * within this class.
	 * 
	 * <pre>
	 * &lt;complexType>
	 *   &lt;complexContent>
	 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *       &lt;sequence>
	 *         &lt;element name="paramid" type="{http://www.w3.org/2001/XMLSchema}integer"/>
	 *         &lt;element name="type" type="{http://server.webservice.click.alfa.com/}widgetType"/>
	 *         &lt;element name="selectItems" type="{http://server.webservice.click.alfa.com/}selectItem" minOccurs="0"/>
	 *         &lt;element name="default" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *         &lt;element name="label" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *         &lt;element name="mode" type="{http://server.webservice.click.alfa.com/}modeType"/>
	 *         &lt;element name="hint" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *       &lt;/sequence>
	 *     &lt;/restriction>
	 *   &lt;/complexContent>
	 * &lt;/complexType>
	 * </pre>
	 * 
	 * 
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "paramid", "type", "selectItems", "_default", "label",
			"mode", "hint" })
	public static class Param implements Serializable {

		/**
		 * Default serial version id.
		 */
		private static final long serialVersionUID = 1L;

		@XmlElement(required = true)
		protected BigInteger paramid;

		@XmlElement(required = true)
		protected WidgetType type;

		protected SelectItem selectItems;

		@XmlElement(name = "default")
		protected String _default;

		@XmlElement(required = true)
		protected String label;

		@XmlElement(required = true)
		protected ModeType mode;

		@XmlElement(required = true)
		protected String hint;

		/**
		 * Gets the value of the paramid property.
		 * 
		 * @return possible object is {@link BigInteger }
		 * 
		 */
		public BigInteger getParamid() {
			return paramid;
		}

		/**
		 * Sets the value of the paramid property.
		 * 
		 * @param value
		 *            allowed object is {@link BigInteger }
		 * 
		 */
		public void setParamid(final BigInteger value) {
			this.paramid = value;
		}

		/**
		 * Gets the value of the type property.
		 * 
		 * @return possible object is {@link WidgetType }
		 * 
		 */
		public WidgetType getType() {
			return type;
		}

		/**
		 * Sets the value of the type property.
		 * 
		 * @param value
		 *            allowed object is {@link WidgetType }
		 * 
		 */
		public void setType(final WidgetType value) {
			this.type = value;
		}

		/**
		 * Gets the value of the selectItems property.
		 * 
		 * @return possible object is {@link SelectItem }
		 * 
		 */
		public SelectItem getSelectItems() {
			return selectItems;
		}

		/**
		 * Sets the value of the selectItems property.
		 * 
		 * @param value
		 *            allowed object is {@link SelectItem }
		 * 
		 */
		public void setSelectItems(final SelectItem value) {
			this.selectItems = value;
		}

		/**
		 * Gets the value of the default property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getDefault() {
			return _default;
		}

		/**
		 * Sets the value of the default property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setDefault(final String value) {
			this._default = value;
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
		 * Gets the value of the mode property.
		 * 
		 * @return possible object is {@link ModeType }
		 * 
		 */
		public ModeType getMode() {
			return mode;
		}

		/**
		 * Sets the value of the mode property.
		 * 
		 * @param value
		 *            allowed object is {@link ModeType }
		 * 
		 */
		public void setMode(final ModeType value) {
			this.mode = value;
		}

		/**
		 * Gets the value of the hint property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getHint() {
			return hint;
		}

		/**
		 * Sets the value of the hint property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setHint(final String value) {
			this.hint = value;
		}

	}

}
