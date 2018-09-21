
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for AuthenticateUserResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AuthenticateUserResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://schemas.symantec.com/vip/2011/04/vipuserservices}BaseResponseType"&gt;
 *       &lt;sequence minOccurs="0"&gt;
 *         &lt;element name="credentialId" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}CredentialIdType" minOccurs="0"/&gt;
 *         &lt;element name="credentialType" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}CredentialTypeEnum" minOccurs="0"/&gt;
 *         &lt;element name="authnId" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}AuthnIdType" minOccurs="0"/&gt;
 *         &lt;element name="isPinExpired" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="pinExpirationTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
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
@XmlType(name = "AuthenticateUserResponseType", propOrder = {
    "credentialId",
    "credentialType",
    "authnId",
    "isPinExpired",
    "pinExpirationTime",
    "authContext"
})
public class AuthenticateUserResponseType
    extends BaseResponseType
{

    protected String credentialId;
    @XmlSchemaType(name = "string")
    protected CredentialTypeEnum credentialType;
    protected String authnId;
    protected Boolean isPinExpired;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar pinExpirationTime;
    protected AuthContext authContext;

    /**
     * Gets the value of the credentialId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCredentialId() {
        return credentialId;
    }

    /**
     * Sets the value of the credentialId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCredentialId(String value) {
        this.credentialId = value;
    }

    /**
     * Gets the value of the credentialType property.
     * 
     * @return
     *     possible object is
     *     {@link CredentialTypeEnum }
     *     
     */
    public CredentialTypeEnum getCredentialType() {
        return credentialType;
    }

    /**
     * Sets the value of the credentialType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CredentialTypeEnum }
     *     
     */
    public void setCredentialType(CredentialTypeEnum value) {
        this.credentialType = value;
    }

    /**
     * Gets the value of the authnId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthnId() {
        return authnId;
    }

    /**
     * Sets the value of the authnId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthnId(String value) {
        this.authnId = value;
    }

    /**
     * Gets the value of the isPinExpired property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsPinExpired() {
        return isPinExpired;
    }

    /**
     * Sets the value of the isPinExpired property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsPinExpired(Boolean value) {
        this.isPinExpired = value;
    }

    /**
     * Gets the value of the pinExpirationTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPinExpirationTime() {
        return pinExpirationTime;
    }

    /**
     * Sets the value of the pinExpirationTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPinExpirationTime(XMLGregorianCalendar value) {
        this.pinExpirationTime = value;
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
