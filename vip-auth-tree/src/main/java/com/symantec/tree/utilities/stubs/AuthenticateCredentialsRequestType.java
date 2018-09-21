
package com.symantec.tree.utilities.stubs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AuthenticateCredentialsRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AuthenticateCredentialsRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://schemas.symantec.com/vip/2011/04/vipuserservices}BaseRequestWithAccountIdType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="credentials" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}CredentialDefinitionType" maxOccurs="5"/&gt;
 *         &lt;element name="activate" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="otpAuthData" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}OtpAuthDataType"/&gt;
 *           &lt;element name="pushAuthData" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}PushAuthDataType"/&gt;
 *         &lt;/choice&gt;
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
@XmlType(name = "AuthenticateCredentialsRequestType", propOrder = {
    "credentials",
    "activate",
    "otpAuthData",
    "pushAuthData",
    "authContext"
})
public class AuthenticateCredentialsRequestType
    extends BaseRequestWithAccountIdType
{

    @XmlElement(required = true)
    protected List<CredentialDefinitionType> credentials;
    @XmlElement(defaultValue = "false")
    protected Boolean activate;
    protected OtpAuthDataType otpAuthData;
    protected PushAuthDataType pushAuthData;
    protected AuthContext authContext;

    /**
     * Gets the value of the credentials property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the credentials property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCredentials().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CredentialDefinitionType }
     * 
     * 
     */
    public List<CredentialDefinitionType> getCredentials() {
        if (credentials == null) {
            credentials = new ArrayList<CredentialDefinitionType>();
        }
        return this.credentials;
    }

    /**
     * Gets the value of the activate property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isActivate() {
        return activate;
    }

    /**
     * Sets the value of the activate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setActivate(Boolean value) {
        this.activate = value;
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
