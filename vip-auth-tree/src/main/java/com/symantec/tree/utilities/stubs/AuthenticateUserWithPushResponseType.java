
package com.symantec.tree.utilities.stubs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for AuthenticateUserWithPushResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AuthenticateUserWithPushResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://schemas.symantec.com/vip/2011/04/vipuserservices}BaseResponseType"&gt;
 *       &lt;sequence minOccurs="0"&gt;
 *         &lt;element name="transactionId" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}PushTransactionIdType" minOccurs="0"/&gt;
 *         &lt;element name="isPinExpired" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="pinExpirationTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;sequence maxOccurs="20" minOccurs="0"&gt;
 *           &lt;element name="pushDetail" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}PushDetailType"/&gt;
 *         &lt;/sequence&gt;
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
@XmlType(name = "AuthenticateUserWithPushResponseType", propOrder = {
    "transactionId",
    "isPinExpired",
    "pinExpirationTime",
    "pushDetail",
    "authContext"
})
public class AuthenticateUserWithPushResponseType
    extends BaseResponseType
{

    protected String transactionId;
    protected Boolean isPinExpired;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar pinExpirationTime;
    protected List<PushDetailType> pushDetail;
    protected AuthContext authContext;

    /**
     * Gets the value of the transactionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * Sets the value of the transactionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionId(String value) {
        this.transactionId = value;
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
     * Gets the value of the pushDetail property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pushDetail property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPushDetail().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PushDetailType }
     * 
     * 
     */
    public List<PushDetailType> getPushDetail() {
        if (pushDetail == null) {
            pushDetail = new ArrayList<PushDetailType>();
        }
        return this.pushDetail;
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
