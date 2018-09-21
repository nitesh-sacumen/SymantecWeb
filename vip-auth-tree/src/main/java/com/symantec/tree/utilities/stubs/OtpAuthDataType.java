
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OtpAuthDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OtpAuthDataType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://schemas.symantec.com/vip/2011/04/vipuserservices}AbstractAuthDataType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="otp" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}OtpType"/&gt;
 *         &lt;element name="otp2" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}OtpType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OtpAuthDataType", propOrder = {
    "otp",
    "otp2"
})
public class OtpAuthDataType
    extends AbstractAuthDataType
{

    @XmlElement(required = true)
    protected String otp;
    protected String otp2;

    /**
     * Gets the value of the otp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOtp() {
        return otp;
    }

    /**
     * Sets the value of the otp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOtp(String value) {
        this.otp = value;
    }

    /**
     * Gets the value of the otp2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOtp2() {
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
    public void setOtp2(String value) {
        this.otp2 = value;
    }

}
