
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReasonType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReasonType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Unspecified"/&gt;
 *     &lt;enumeration value="Stolen"/&gt;
 *     &lt;enumeration value="Lost"/&gt;
 *     &lt;enumeration value="Canceled"/&gt;
 *     &lt;enumeration value="Returned"/&gt;
 *     &lt;enumeration value="TemporarilyUnavailable"/&gt;
 *     &lt;enumeration value="Expired"/&gt;
 *     &lt;enumeration value="DeactivatedAsPerUnusedPolicy"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ReasonType")
@XmlEnum
public enum ReasonType {

    @XmlEnumValue("Unspecified")
    UNSPECIFIED("Unspecified"),
    @XmlEnumValue("Stolen")
    STOLEN("Stolen"),
    @XmlEnumValue("Lost")
    LOST("Lost"),
    @XmlEnumValue("Canceled")
    CANCELED("Canceled"),
    @XmlEnumValue("Returned")
    RETURNED("Returned"),
    @XmlEnumValue("TemporarilyUnavailable")
    TEMPORARILY_UNAVAILABLE("TemporarilyUnavailable"),
    @XmlEnumValue("Expired")
    EXPIRED("Expired"),
    @XmlEnumValue("DeactivatedAsPerUnusedPolicy")
    DEACTIVATED_AS_PER_UNUSED_POLICY("DeactivatedAsPerUnusedPolicy");
    private final String value;

    ReasonType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ReasonType fromValue(String v) {
        for (ReasonType c: ReasonType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
