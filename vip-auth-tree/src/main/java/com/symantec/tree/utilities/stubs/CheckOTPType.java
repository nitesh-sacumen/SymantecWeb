
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Verifies the OTP for the Token
 * 
 * <p>Java class for CheckOTPType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CheckOTPType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://schemas.vip.symantec.com/2006/08/vipservice}TokenRequestType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="OTP1" type="{https://schemas.vip.symantec.com/2006/08/vipservice}OTPType"/&gt;
 *         &lt;element name="OTP2" type="{https://schemas.vip.symantec.com/2006/08/vipservice}OTPType" minOccurs="0"/&gt;
 *         &lt;element name="acceptTemporaryPassword" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CheckOTPType", propOrder = {
    "otp1",
    "otp2",
    "acceptTemporaryPassword"
})
public class CheckOTPType
    extends TokenRequestType
{

    @XmlElement(name = "OTP1", required = true)
    protected String otp1;
    @XmlElement(name = "OTP2")
    protected String otp2;
    @XmlElement(defaultValue = "false")
    protected Boolean acceptTemporaryPassword;

    /**
     * Gets the value of the otp1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOTP1() {
        return otp1;
    }

    /**
     * Sets the value of the otp1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOTP1(String value) {
        this.otp1 = value;
    }

    /**
     * Gets the value of the otp2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOTP2() {
        return otp2;
    }

    /**
     * Sets the value of the otp2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOTP2(String value) {
        this.otp2 = value;
    }

    /**
     * Gets the value of the acceptTemporaryPassword property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAcceptTemporaryPassword() {
        return acceptTemporaryPassword;
    }

    /**
     * Sets the value of the acceptTemporaryPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAcceptTemporaryPassword(Boolean value) {
        this.acceptTemporaryPassword = value;
    }

}
