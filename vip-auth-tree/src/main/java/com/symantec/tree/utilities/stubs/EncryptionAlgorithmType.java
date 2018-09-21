
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EncryptionAlgorithmType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EncryptionAlgorithmType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="NONE"/&gt;
 *     &lt;enumeration value="PBE-3DES112-CBC"/&gt;
 *     &lt;enumeration value="PBE-3DES168-CBC"/&gt;
 *     &lt;enumeration value="PBE-AES128-CBC"/&gt;
 *     &lt;enumeration value="AES128-CTR"/&gt;
 *     &lt;enumeration value="AES128-CBC"/&gt;
 *     &lt;enumeration value="RSA"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "EncryptionAlgorithmType")
@XmlEnum
public enum EncryptionAlgorithmType {

    NONE("NONE"),
    @XmlEnumValue("PBE-3DES112-CBC")
    PBE_3_DES_112_CBC("PBE-3DES112-CBC"),
    @XmlEnumValue("PBE-3DES168-CBC")
    PBE_3_DES_168_CBC("PBE-3DES168-CBC"),
    @XmlEnumValue("PBE-AES128-CBC")
    PBE_AES_128_CBC("PBE-AES128-CBC"),
    @XmlEnumValue("AES128-CTR")
    AES_128_CTR("AES128-CTR"),
    @XmlEnumValue("AES128-CBC")
    AES_128_CBC("AES128-CBC"),
    RSA("RSA");
    private final String value;

    EncryptionAlgorithmType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EncryptionAlgorithmType fromValue(String v) {
        for (EncryptionAlgorithmType c: EncryptionAlgorithmType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
