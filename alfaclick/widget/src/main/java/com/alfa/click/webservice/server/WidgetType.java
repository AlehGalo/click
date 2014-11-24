
package com.alfa.click.webservice.server;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for widgetType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="widgetType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="amount"/>
 *     &lt;enumeration value="date"/>
 *     &lt;enumeration value="select"/>
 *     &lt;enumeration value="string"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "widgetType")
@XmlEnum
public enum WidgetType {

    @XmlEnumValue("amount")
    AMOUNT("amount"),
    @XmlEnumValue("date")
    DATE("date"),
    @XmlEnumValue("select")
    SELECT("select"),
    @XmlEnumValue("string")
    STRING("string");
    private final String value;

    WidgetType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WidgetType fromValue(String v) {
        for (WidgetType c: WidgetType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
