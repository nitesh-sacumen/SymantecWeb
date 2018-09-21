
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CheckOtpRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CheckOtpRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://schemas.symantec.com/vip/2011/04/vipuserservices}BaseRequestWithAccountIdType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="userId" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}UserIdType"/&gt;
 *         &lt;element name="otpAuthData" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}OtpAuthDataType"/&gt;
 *         &lt;element name="authContext" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}AuthContext" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CheckOtpRequestType", propOrder = {
    "userId",
    "otpAuthData",
    "authContext"
})
public class CheckOtpRequestType
    extends BaseRequestWithAccountIdType
{

    @XmlElement(required = true)
    protected String userId;
    @XmlElement(required = true)
    protected OtpAuthDataType otpAuthData;
    protected AuthContext authContext;

    /**
     * Gets the value of the userId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserId(String value) {
        this.userId = value;
    }

    /**
     * Gets the value of the otpAuthData property.
     * 
     * @return
     *     possible object is
     *     {@link OtpAuthDataType }
     *     
     */
    public OtpAuthDataType getOtpAuthData() {
        return otpAuthData;
    }

    /**
     * Sets the value of the otpAuthData property.
     * 
     * @param value
     *     allowed object is
     *     {@link OtpAuthDataType }
     *     
     */
    public void setOtpAuthData(OtpAuthDataType value) {
        this.otpAuthData = value;
    }

    /**
     * Gets the value of the authContext property.
     * 
     * @return
     *     possible object is
     *     {@link AuthContext }
     *     
     */
    public AuthContext getAuthContext() {
        return authContext;
    }

    /**
     * Sets the value of the authContext property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthContext }
     *     
     */
    public void setAuthContext(AuthContext value) {
        this.authContext = value;
    }

}
