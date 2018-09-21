
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Request to validate a challenge/response. Both the challenge and the response should be provided as inputs.
 * 
 * <p>Java class for ValidateCRType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ValidateCRType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://schemas.vip.symantec.com/2006/08/vipservice}MultipleTokensRequestType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="NumericChallenge" type="{https://schemas.vip.symantec.com/2006/08/vipservice}NumericChallengeType" minOccurs="0"/&gt;
 *         &lt;element name="HexChallenge" type="{https://schemas.vip.symantec.com/2006/08/vipservice}HexChallengeType" minOccurs="0"/&gt;
 *         &lt;element name="Response" type="{https://schemas.vip.symantec.com/2006/08/vipservice}OTPType"/&gt;
 *         &lt;element name="CheckOnly" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="Usage" type="{https://schemas.vip.symantec.com/2006/08/vipservice}OCRAUsageType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ValidateCRType", propOrder = {
    "numericChallenge",
    "hexChallenge",
    "response",
    "checkOnly",
    "usage"
})
public class ValidateCRType
    extends MultipleTokensRequestType
{

    @XmlElement(name = "NumericChallenge")
    protected String numericChallenge;
    @XmlElement(name = "HexChallenge")
    protected String hexChallenge;
    @XmlElement(name = "Response", required = true)
    protected String response;
    @XmlElement(name = "CheckOnly", defaultValue = "false")
    protected boolean checkOnly;
    @XmlElement(name = "Usage")
    @XmlSchemaType(name = "string")
    protected OCRAUsageType usage;

    /**
     * Gets the value of the numericChallenge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumericChallenge() {
        return numericChallenge;
    }

    /**
     * Sets the value of the numericChallenge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumericChallenge(String value) {
        this.numericChallenge = value;
    }

    /**
     * Gets the value of the hexChallenge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHexChallenge() {
        return hexChallenge;
    }

    /**
     * Sets the value of the hexChallenge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHexChallenge(String value) {
        this.hexChallenge = value;
    }

    /**
     * Gets the value of the response property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponse(String value) {
        this.response = value;
    }

    /**
     * Gets the value of the checkOnly property.
     * 
     */
    public boolean isCheckOnly() {
        return checkOnly;
    }

    /**
     * Sets the value of the checkOnly property.
     * 
     */
    public void setCheckOnly(boolean value) {
        this.checkOnly = value;
    }

    /**
     * Gets the value of the usage property.
     * 
     * @return
     *     possible object is
     *     {@link OCRAUsageType }
     *     
     */
    public OCRAUsageType getUsage() {
        return usage;
    }

    /**
     * Sets the value of the usage property.
     * 
     * @param value
     *     allowed object is
     *     {@link OCRAUsageType }
     *     
     */
    public void setUsage(OCRAUsageType value) {
        this.usage = value;
    }

}
