
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AuthenticateUserWithPushRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AuthenticateUserWithPushRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://schemas.symantec.com/vip/2011/04/vipuserservices}BaseRequestWithAccountIdType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="userId" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}UserIdType"/&gt;
 *         &lt;element name="pin" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}PinType" minOccurs="0"/&gt;
 *         &lt;element name="pushAuthData" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}PushAuthDataType"/&gt;
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
@XmlType(name = "AuthenticateUserWithPushRequestType", propOrder = {
    "userId",
    "pin",
    "pushAuthData",
    "authContext"
})
public class AuthenticateUserWithPushRequestType
    extends BaseRequestWithAccountIdType
{

    @XmlElement(required = true)
    protected String userId;
    protected String pin;
    @XmlElement(required = true)
    protected PushAuthDataType pushAuthData;
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
     * Gets the value of the pin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPin() {
        return pin;
    }

    /**
     * Sets the value of the pin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPin(String value) {
        this.pin = value;
    }

    /**
     * Gets the value of the pushAuthData property.
     * 
     * @return
     *     possible object is
     *     {@link PushAuthDataType }
     *     
     */
    public PushAuthDataType getPushAuthData() {
        return pushAuthData;
    }

    /**
     * Sets the value of the pushAuthData property.
     * 
     * @param value
     *     allowed object is
     *     {@link PushAuthDataType }
     *     
     */
    public void setPushAuthData(PushAuthDataType value) {
        this.pushAuthData = value;
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
