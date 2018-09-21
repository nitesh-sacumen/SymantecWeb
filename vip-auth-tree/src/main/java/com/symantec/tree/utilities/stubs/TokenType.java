
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TokenType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TokenType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="SMS"/&gt;
 *     &lt;enumeration value="Voice"/&gt;
 *     &lt;enumeration value="Service"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TokenType")
@XmlEnum
public enum TokenType {

    SMS("SMS"),
    @XmlEnumValue("Voice")
    VOICE("Voice"),
    @XmlEnumValue("Service")
    SERVICE("Service");
    private final String value;

    TokenType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TokenType fromValue(String v) {
        for (TokenType c: TokenType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
