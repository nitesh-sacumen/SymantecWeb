
package com.symantec.tree.utilities.stubs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for PushTransactionStatusType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PushTransactionStatusType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="transactionId" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}PushTransactionIdType"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}hexBinary"/&gt;
 *         &lt;element name="statusMessage" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="detail" type="{http://www.w3.org/2001/XMLSchema}hexBinary" minOccurs="0"/&gt;
 *         &lt;element name="detailMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="authnTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="credentialId" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}CredentialIdType" minOccurs="0"/&gt;
 *         &lt;element name="credentialType" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}CredentialTypeEnum" minOccurs="0"/&gt;
 *         &lt;element name="isPinExpired" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="pinExpirationTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="deviceInfo" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}KeyValuePairType" maxOccurs="50" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PushTransactionStatusType", propOrder = {
    "transactionId",
    "status",
    "statusMessage",
    "detail",
    "detailMessage",
    "authnTime",
    "credentialId",
    "credentialType",
    "isPinExpired",
    "pinExpirationTime",
    "deviceInfo"
})
public class PushTransactionStatusType {

    @XmlElement(required = true)
    protected String transactionId;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    @XmlSchemaType(name = "hexBinary")
    protected byte[] status;
    @XmlElement(required = true)
    protected String statusMessage;
    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    @XmlSchemaType(name = "hexBinary")
    protected byte[] detail;
    protected String detailMessage;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar authnTime;
    protected String credentialId;
    @XmlSchemaType(name = "string")
    protected CredentialTypeEnum credentialType;
    protected Boolean isPinExpired;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar pinExpirationTime;
    protected List<KeyValuePairType> deviceInfo;

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
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public byte[] getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(byte[] value) {
        this.status = value;
    }

    /**
     * Gets the value of the statusMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusMessage() {
        return statusMessage;
    }

    /**
     * Sets the value of the statusMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusMessage(String value) {
        this.statusMessage = value;
    }

    /**
     * Gets the value of the detail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public byte[] getDetail() {
        return detail;
    }

    /**
     * Sets the value of the detail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDetail(byte[] value) {
        this.detail = value;
    }

    /**
     * Gets the value of the detailMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDetailMessage() {
        return detailMessage;
    }

    /**
     * Sets the value of the detailMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDetailMessage(String value) {
        this.detailMessage = value;
    }

    /**
     * Gets the value of the authnTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAuthnTime() {
        return authnTime;
    }

    /**
     * Sets the value of the authnTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAuthnTime(XMLGregorianCalendar value) {
        this.authnTime = value;
    }

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
     * Gets the value of the deviceInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the deviceInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDeviceInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KeyValuePairType }
     * 
     * 
     */
    public List<KeyValuePairType> getDeviceInfo() {
        if (deviceInfo == null) {
            deviceInfo = new ArrayList<KeyValuePairType>();
        }
        return this.deviceInfo;
    }

}
