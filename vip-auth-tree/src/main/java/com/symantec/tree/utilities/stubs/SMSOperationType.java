
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SMSOperationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SMSOperationType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="REGISTER"/&gt;
 *     &lt;enumeration value="SEND_MESSAGE"/&gt;
 *     &lt;enumeration value="PASS_THROUGH"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "SMSOperationType")
@XmlEnum
public enum SMSOperationType {

    REGISTER,
    SEND_MESSAGE,
    PASS_THROUGH;

    public String value() {
        return name();
    }

    public static SMSOperationType fromValue(String v) {
        return valueOf(v);
    }

}
