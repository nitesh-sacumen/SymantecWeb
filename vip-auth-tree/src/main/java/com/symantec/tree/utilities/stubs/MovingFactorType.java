
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MovingFactorType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MovingFactorType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="NONE"/&gt;
 *     &lt;enumeration value="TIME"/&gt;
 *     &lt;enumeration value="EVENT"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "MovingFactorType")
@XmlEnum
public enum MovingFactorType {

    NONE,
    TIME,
    EVENT;

    public String value() {
        return name();
    }

    public static MovingFactorType fromValue(String v) {
        return valueOf(v);
    }

}
