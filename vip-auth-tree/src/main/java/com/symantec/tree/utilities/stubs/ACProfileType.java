
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ACProfileType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ACProfileType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="MOBILEPHONE"/&gt;
 *     &lt;enumeration value="COMPUTER"/&gt;
 *     &lt;enumeration value="BREW"/&gt;
 *     &lt;enumeration value="MOBILE_NUMERIC_MEDIUM"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ACProfileType")
@XmlEnum
public enum ACProfileType {

    MOBILEPHONE,
    COMPUTER,
    BREW,
    MOBILE_NUMERIC_MEDIUM;

    public String value() {
        return name();
    }

    public static ACProfileType fromValue(String v) {
        return valueOf(v);
    }

}
