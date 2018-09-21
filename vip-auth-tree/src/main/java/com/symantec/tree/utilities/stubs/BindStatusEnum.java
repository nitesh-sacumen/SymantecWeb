
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BindStatusEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="BindStatusEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="ENABLED"/&gt;
 *     &lt;enumeration value="DISABLED"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "BindStatusEnum")
@XmlEnum
public enum BindStatusEnum {

    ENABLED,
    DISABLED;

    public String value() {
        return name();
    }

    public static BindStatusEnum fromValue(String v) {
        return valueOf(v);
    }

}
