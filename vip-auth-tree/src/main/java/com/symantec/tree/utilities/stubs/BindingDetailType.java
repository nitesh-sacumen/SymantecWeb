
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for BindingDetailType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BindingDetailType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="bindStatus" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}BindStatusEnum"/&gt;
 *         &lt;element name="friendlyName" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}FriendlyNameType" minOccurs="0"/&gt;
 *         &lt;element name="trustedDevice" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="clientVersion" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}ClientVersionType" minOccurs="0"/&gt;
 *         &lt;element name="clientType" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}ClientTypeType" minOccurs="0"/&gt;
 *         &lt;element name="lastBindTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="lastAuthnTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="lastAuthnId" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}AuthnIdType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BindingDetailType", propOrder = {
    "bindStatus",
    "friendlyName",
    "trustedDevice",
    "clientVersion",
    "clientType",
    "lastBindTime",
    "lastAuthnTime",
    "lastAuthnId"
})
public class BindingDetailType {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected BindStatusEnum bindStatus;
    protected String friendlyName;
    protected Boolean trustedDevice;
    protected String clientVersion;
    protected String clientType;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastBindTime;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastAuthnTime;
    protected String lastAuthnId;

    /**
     * Gets the value of the bindStatus property.
     * 
     * @return
     *     possible object is
     *     {@link BindStatusEnum }
     *     
     */
    public BindStatusEnum getBindStatus() {
        return bindStatus;
    }

    /**
     * Sets the value of the bindStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link BindStatusEnum }
     *     
     */
    public void setBindStatus(BindStatusEnum value) {
        this.bindStatus = value;
    }

    /**
     * Gets the value of the friendlyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFriendlyName() {
        return friendlyName;
    }

    /**
     * Sets the value of the friendlyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFriendlyName(String value) {
        this.friendlyName = value;
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

    /**
     * Gets the value of the clientVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientVersion() {
        return clientVersion;
    }

    /**
     * Sets the value of the clientVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientVersion(String value) {
        this.clientVersion = value;
    }

    /**
     * Gets the value of the clientType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientType() {
        return clientType;
    }

    /**
     * Sets the value of the clientType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientType(String value) {
        this.clientType = value;
    }

    /**
     * Gets the value of the lastBindTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastBindTime() {
        return lastBindTime;
    }

    /**
     * Sets the value of the lastBindTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastBindTime(XMLGregorianCalendar value) {
        this.lastBindTime = value;
    }

    /**
     * Gets the value of the lastAuthnTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastAuthnTime() {
        return lastAuthnTime;
    }

    /**
     * Sets the value of the lastAuthnTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastAuthnTime(XMLGregorianCalendar value) {
        this.lastAuthnTime = value;
    }

    /**
     * Gets the value of the lastAuthnId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastAuthnId() {
        return lastAuthnId;
    }

    /**
     * Sets the value of the lastAuthnId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastAuthnId(String value) {
        this.lastAuthnId = value;
    }

}
