
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActivationCodeStatusType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActivationCodeStatusType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="NEW"/&gt;
 *     &lt;enumeration value="PROVISIONED"/&gt;
 *     &lt;enumeration value="DISABLED"/&gt;
 *     &lt;enumeration value="EXPIRED"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ActivationCodeStatusType")
@XmlEnum
public enum ActivationCodeStatusType {

    NEW,
    PROVISIONED,
    DISABLED,
    EXPIRED;

    public String value() {
        return name();
    }

    public static ActivationCodeStatusType fromValue(String v) {
        return valueOf(v);
    }

}
