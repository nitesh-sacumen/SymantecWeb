
package com.symantec.tree.utilities.stubs;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Contains the counts of a tokens in a particular status.
 * 
 * <p>Java class for TokenStatusCountType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TokenStatusCountType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://schemas.vip.symantec.com/2006/08/vipservice}TokenStatus"/&gt;
 *         &lt;element name="Count" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TokenStatusCountType", propOrder = {
    "tokenStatus",
    "count"
})
public class TokenStatusCountType {

    @XmlElement(name = "TokenStatus", required = true)
    @XmlSchemaType(name = "string")
    protected TokenStatusType tokenStatus;
    @XmlElement(name = "Count", required = true)
    protected BigInteger count;

    /**
     * Gets the value of the tokenStatus property.
     * 
     * @return
     *     possible object is
     *     {@link TokenStatusType }
     *     
     */
    public TokenStatusType getTokenStatus() {
        return tokenStatus;
    }

    /**
     * Sets the value of the tokenStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link TokenStatusType }
     *     
     */
    public void setTokenStatus(TokenStatusType value) {
        this.tokenStatus = value;
    }

    /**
     * Gets the value of the count property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCount() {
        return count;
    }

    /**
     * Sets the value of the count property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCount(BigInteger value) {
        this.count = value;
    }

}
