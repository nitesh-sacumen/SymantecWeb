
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ChallengeFormatType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ChallengeFormatType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="NUMERIC"/&gt;
 *     &lt;enumeration value="HEX"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ChallengeFormatType")
@XmlEnum
public enum ChallengeFormatType {

    NUMERIC,
    HEX;

    public String value() {
        return name();
    }

    public static ChallengeFormatType fromValue(String v) {
        return valueOf(v);
    }

}
