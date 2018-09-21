
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MimeTypeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MimeTypeType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="image/gif"/&gt;
 *     &lt;enumeration value="image/jpeg"/&gt;
 *     &lt;enumeration value="image/png"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "MimeTypeType")
@XmlEnum
public enum MimeTypeType {

    @XmlEnumValue("image/gif")
    IMAGE_GIF("image/gif"),
    @XmlEnumValue("image/jpeg")
    IMAGE_JPEG("image/jpeg"),
    @XmlEnumValue("image/png")
    IMAGE_PNG("image/png");
    private final String value;

    MimeTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MimeTypeType fromValue(String v) {
        for (MimeTypeType c: MimeTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
