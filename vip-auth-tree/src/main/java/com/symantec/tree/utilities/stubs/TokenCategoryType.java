
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TokenCategoryType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TokenCategoryType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="OATH_EVENT"/&gt;
 *     &lt;enumeration value="VASCO_TIME"/&gt;
 *     &lt;enumeration value="SERVER_OTP"/&gt;
 *     &lt;enumeration value="OATH_TIME"/&gt;
 *     &lt;enumeration value="SMS_OTP"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TokenCategoryType")
@XmlEnum
public enum TokenCategoryType {

    OATH_EVENT,
    VASCO_TIME,
    SERVER_OTP,
    OATH_TIME,
    SMS_OTP;

    public String value() {
        return name();
    }

    public static TokenCategoryType fromValue(String v) {
        return valueOf(v);
    }

}
