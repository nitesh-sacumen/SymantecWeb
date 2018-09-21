
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MessageType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MessageType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="REGISTER"/&gt;
 *     &lt;enumeration value="SERVICE"/&gt;
 *     &lt;enumeration value="TEMP_PASSWORD"/&gt;
 *     &lt;enumeration value="PIN_DELIVERY"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "MessageType")
@XmlEnum
public enum MessageType {

    REGISTER,
    SERVICE,
    TEMP_PASSWORD,
    PIN_DELIVERY;

    public String value() {
        return name();
    }

    public static MessageType fromValue(String v) {
        return valueOf(v);
    }

}
