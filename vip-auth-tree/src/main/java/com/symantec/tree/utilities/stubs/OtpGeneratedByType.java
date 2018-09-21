
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OtpGeneratedByType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OtpGeneratedByType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="HARDWARE"/&gt;
 *     &lt;enumeration value="SOFTWARE"/&gt;
 *     &lt;enumeration value="SERVER"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "OtpGeneratedByType")
@XmlEnum
public enum OtpGeneratedByType {

    HARDWARE,
    SOFTWARE,
    SERVER;

    public String value() {
        return name();
    }

    public static OtpGeneratedByType fromValue(String v) {
        return valueOf(v);
    }

}
