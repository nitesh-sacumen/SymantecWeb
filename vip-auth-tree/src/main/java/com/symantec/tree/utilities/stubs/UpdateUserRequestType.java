
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * This request object can be used to rename the user.
 * 
 * <p>Java class for UpdateUserRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateUserRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://schemas.symantec.com/vip/2011/04/vipuserservices}BaseRequestWithAccountIdType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="userId" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}UserIdType"/&gt;
 *         &lt;element name="newUserId" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}UserIdType" minOccurs="0"/&gt;
 *         &lt;element name="newUserStatus" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}UserStatusEnum" minOccurs="0"/&gt;
 *         &lt;element name="oldPin" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}PinType" minOccurs="0"/&gt;
 *         &lt;element name="newPin" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}PinType" minOccurs="0"/&gt;
 *         &lt;element name="forcePinChange" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateUserRequestType", propOrder = {
    "userId",
    "newUserId",
    "newUserStatus",
    "oldPin",
    "newPin",
    "forcePinChange"
})
public class UpdateUserRequestType
    extends BaseRequestWithAccountIdType
{

    @XmlElement(required = true)
    protected String userId;
    protected String newUserId;
    @XmlSchemaType(name = "string")
    protected UserStatusEnum newUserStatus;
    protected String oldPin;
    protected String newPin;
    protected Boolean forcePinChange;

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
     * Gets the value of the newUserId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewUserId() {
        return newUserId;
    }

    /**
     * Sets the value of the newUserId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewUserId(String value) {
        this.newUserId = value;
    }

    /**
     * Gets the value of the newUserStatus property.
     * 
     * @return
     *     possible object is
     *     {@link UserStatusEnum }
     *     
     */
    public UserStatusEnum getNewUserStatus() {
        return newUserStatus;
    }

    /**
     * Sets the value of the newUserStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserStatusEnum }
     *     
     */
    public void setNewUserStatus(UserStatusEnum value) {
        this.newUserStatus = value;
    }

    /**
     * Gets the value of the oldPin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOldPin() {
        return oldPin;
    }

    /**
     * Sets the value of the oldPin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOldPin(String value) {
        this.oldPin = value;
    }

    /**
     * Gets the value of the newPin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewPin() {
        return newPin;
    }

    /**
     * Sets the value of the newPin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewPin(String value) {
        this.newPin = value;
    }

    /**
     * Gets the value of the forcePinChange property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isForcePinChange() {
        return forcePinChange;
    }

    /**
     * Sets the value of the forcePinChange property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setForcePinChange(Boolean value) {
        this.forcePinChange = value;
    }

}
