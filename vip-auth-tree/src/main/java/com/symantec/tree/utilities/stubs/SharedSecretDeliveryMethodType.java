
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SharedSecretDeliveryMethodType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SharedSecretDeliveryMethodType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="HTTPS"/&gt;
 *     &lt;enumeration value="SMS"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "SharedSecretDeliveryMethodType")
@XmlEnum
public enum SharedSecretDeliveryMethodType {

    HTTPS,
    SMS;

    public String value() {
        return name();
    }

    public static SharedSecretDeliveryMethodType fromValue(String v) {
        return valueOf(v);
    }

}
