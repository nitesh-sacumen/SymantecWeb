
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Request for adding a credential under a user.
 * 
 * <p>Java class for AddCredentialRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AddCredentialRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://schemas.symantec.com/vip/2011/04/vipuserservices}BaseRequestWithAccountIdType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="userId" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}UserIdType"/&gt;
 *         &lt;element name="credentialDetail" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}CredentialDetailType"/&gt;
 *         &lt;choice minOccurs="0"&gt;
 *           &lt;element name="otpAuthData" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}OtpAuthDataType"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="trustedDevice" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddCredentialRequestType", propOrder = {
    "userId",
    "credentialDetail",
    "otpAuthData",
    "trustedDevice"
})
public class AddCredentialRequestType
    extends BaseRequestWithAccountIdType
{

    @XmlElement(required = true)
    protected String userId;
    @XmlElement(required = true)
    protected CredentialDetailType credentialDetail;
    protected OtpAuthDataType otpAuthData;
    protected Boolean trustedDevice;

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
     * Gets the value of the credentialDetail property.
     * 
     * @return
     *     possible object is
     *     {@link CredentialDetailType }
     *     
     */
    public CredentialDetailType getCredentialDetail() {
        return credentialDetail;
    }

    /**
     * Sets the value of the credentialDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link CredentialDetailType }
     *     
     */
    public void setCredentialDetail(CredentialDetailType value) {
        this.credentialDetail = value;
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
     * Gets the value of the trustedDevice property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTrustedDevice() {
        return trustedDevice;
    }

    /**
     * Sets the value of the trustedDevice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTrustedDevice(Boolean value) {
        this.trustedDevice = value;
    }

}
