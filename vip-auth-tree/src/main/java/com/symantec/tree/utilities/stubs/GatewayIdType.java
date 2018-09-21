
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GatewayIdType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="GatewayIdType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="IMN"/&gt;
 *     &lt;enumeration value="HKCSL"/&gt;
 *     &lt;enumeration value="SINGTEL"/&gt;
 *     &lt;enumeration value="TELESIGN"/&gt;
 *     &lt;enumeration value="DEFAULT"/&gt;
 *     &lt;enumeration value="TWILIO"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "GatewayIdType")
@XmlEnum
public enum GatewayIdType {

    IMN,
    HKCSL,
    SINGTEL,
    TELESIGN,
    DEFAULT,
    TWILIO;

    public String value() {
        return name();
    }

    public static GatewayIdType fromValue(String v) {
        return valueOf(v);
    }

}
