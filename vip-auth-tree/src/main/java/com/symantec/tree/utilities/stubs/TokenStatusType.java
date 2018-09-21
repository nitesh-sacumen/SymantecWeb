
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TokenStatusType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TokenStatusType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="NEW"/&gt;
 *     &lt;enumeration value="ENABLED"/&gt;
 *     &lt;enumeration value="DISABLED"/&gt;
 *     &lt;enumeration value="LOCKED"/&gt;
 *     &lt;enumeration value="INACTIVE"/&gt;
 *     &lt;enumeration value="UNKNOWN"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TokenStatusType")
@XmlEnum
public enum TokenStatusType {

    NEW,
    ENABLED,
    DISABLED,
    LOCKED,
    INACTIVE,
    UNKNOWN;

    public String value() {
        return name();
    }

    public static TokenStatusType fromValue(String v) {
        return valueOf(v);
    }

}
