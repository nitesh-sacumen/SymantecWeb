
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CredentialTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CredentialTypeEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="STANDARD_OTP"/&gt;
 *     &lt;enumeration value="SMS_OTP"/&gt;
 *     &lt;enumeration value="VOICE_OTP"/&gt;
 *     &lt;enumeration value="SERVICE_OTP"/&gt;
 *     &lt;enumeration value="CERTIFICATE"/&gt;
 *     &lt;enumeration value="IA"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CredentialTypeEnum")
@XmlEnum
public enum CredentialTypeEnum {

    STANDARD_OTP,
    SMS_OTP,
    VOICE_OTP,
    SERVICE_OTP,
    CERTIFICATE,
    IA;

    public String value() {
        return name();
    }

    public static CredentialTypeEnum fromValue(String v) {
        return valueOf(v);
    }

}
