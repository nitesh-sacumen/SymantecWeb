
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UserBindingDetailType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UserBindingDetailType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="userId" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}UserIdType"/&gt;
 *         &lt;element name="userStatus" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}UserStatusEnum"/&gt;
 *         &lt;element name="bindingDetail" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}BindingDetailType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserBindingDetailType", propOrder = {
    "userId",
    "userStatus",
    "bindingDetail"
})
public class UserBindingDetailType {

    @XmlElement(required = true)
    protected String userId;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected UserStatusEnum userStatus;
    @XmlElement(required = true)
    protected BindingDetailType bindingDetail;

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
     * Gets the value of the userStatus property.
     * 
     * @return
     *     possible object is
     *     {@link UserStatusEnum }
     *     
     */
    public UserStatusEnum getUserStatus() {
        return userStatus;
    }

    /**
     * Sets the value of the userStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserStatusEnum }
     *     
     */
    public void setUserStatus(UserStatusEnum value) {
        this.userStatus = value;
    }

    /**
     * Gets the value of the bindingDetail property.
     * 
     * @return
     *     possible object is
     *     {@link BindingDetailType }
     *     
     */
    public BindingDetailType getBindingDetail() {
        return bindingDetail;
    }

    /**
     * Sets the value of the bindingDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link BindingDetailType }
     *     
     */
    public void setBindingDetail(BindingDetailType value) {
        this.bindingDetail = value;
    }

}
