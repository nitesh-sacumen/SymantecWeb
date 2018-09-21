
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdapterType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AdapterType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="OATH_EVENT_BASIC"/&gt;
 *     &lt;enumeration value="OATH_EVENT_ADVANCED_1"/&gt;
 *     &lt;enumeration value="OATH_EVENT_ADVANCED_2"/&gt;
 *     &lt;enumeration value="VASCO_TIME"/&gt;
 *     &lt;enumeration value="SERVER_OTP"/&gt;
 *     &lt;enumeration value="OATH_TIME"/&gt;
 *     &lt;enumeration value="SMS_OTP"/&gt;
 *     &lt;enumeration value="VOICE_OTP"/&gt;
 *     &lt;enumeration value="SECURID"/&gt;
 *     &lt;enumeration value="OCRA"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "AdapterType")
@XmlEnum
public enum AdapterType {

    OATH_EVENT_BASIC,
    OATH_EVENT_ADVANCED_1,
    OATH_EVENT_ADVANCED_2,
    VASCO_TIME,
    SERVER_OTP,
    OATH_TIME,
    SMS_OTP,
    VOICE_OTP,
    SECURID,
    OCRA;

    public String value() {
        return name();
    }

    public static AdapterType fromValue(String v) {
        return valueOf(v);
    }

}
