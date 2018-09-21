
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * XML to send temporary password to phone number
 * 
 * <p>Java class for SendTemporaryPasswordType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SendTemporaryPasswordType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://schemas.vip.symantec.com/2006/08/vipservice}TokenRequestType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PhoneNumber" type="{https://schemas.vip.symantec.com/2006/08/vipservice}PhoneNumberType" minOccurs="0"/&gt;
 *         &lt;element name="Destination" type="{https://schemas.vip.symantec.com/2006/08/vipservice}DestinationType" minOccurs="0"/&gt;
 *         &lt;element name="GatewayAcctInfo" type="{https://schemas.vip.symantec.com/2006/08/vipservice}GatewayAcctInfoType" minOccurs="0"/&gt;
 *         &lt;element name="ExpirationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="SMSDeliveryInfo" type="{https://schemas.vip.symantec.com/2006/08/vipservice}SMSDeliveryInfoType" minOccurs="0"/&gt;
 *         &lt;element name="VoiceDeliveryInfo" type="{https://schemas.vip.symantec.com/2006/08/vipservice}VoiceDeliveryInfoType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SendTemporaryPasswordType", propOrder = {
    "phoneNumber",
    "destination",
    "gatewayAcctInfo",
    "expirationDate",
    "smsDeliveryInfo",
    "voiceDeliveryInfo"
})
public class SendTemporaryPasswordType
    extends TokenRequestType
{

    @XmlElement(name = "PhoneNumber")
    protected String phoneNumber;
    @XmlElement(name = "Destination")
    protected DestinationType destination;
    @XmlElement(name = "GatewayAcctInfo")
    protected GatewayAcctInfoType gatewayAcctInfo;
    @XmlElement(name = "ExpirationDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expirationDate;
    @XmlElement(name = "SMSDeliveryInfo")
    protected SMSDeliveryInfoType smsDeliveryInfo;
    @XmlElement(name = "VoiceDeliveryInfo")
    protected VoiceDeliveryInfoType voiceDeliveryInfo;

    /**
     * Gets the value of the phoneNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the value of the phoneNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }

    /**
     * Gets the value of the destination property.
     * 
     * @return
     *     possible object is
     *     {@link DestinationType }
     *     
     */
    public DestinationType getDestination() {
        return destination;
    }

    /**
     * Sets the value of the destination property.
     * 
     * @param value
     *     allowed object is
     *     {@link DestinationType }
     *     
     */
    public void setDestination(DestinationType value) {
        this.destination = value;
    }

    /**
     * Gets the value of the gatewayAcctInfo property.
     * 
     * @return
     *     possible object is
     *     {@link GatewayAcctInfoType }
     *     
     */
    public GatewayAcctInfoType getGatewayAcctInfo() {
        return gatewayAcctInfo;
    }

    /**
     * Sets the value of the gatewayAcctInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link GatewayAcctInfoType }
     *     
     */
    public void setGatewayAcctInfo(GatewayAcctInfoType value) {
        this.gatewayAcctInfo = value;
    }

    /**
     * Gets the value of the expirationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpirationDate() {
        return expirationDate;
    }

    /**
     * Sets the value of the expirationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpirationDate(XMLGregorianCalendar value) {
        this.expirationDate = value;
    }

    /**
     * Gets the value of the smsDeliveryInfo property.
     * 
     * @return
     *     possible object is
     *     {@link SMSDeliveryInfoType }
     *     
     */
    public SMSDeliveryInfoType getSMSDeliveryInfo() {
        return smsDeliveryInfo;
    }

    /**
     * Sets the value of the smsDeliveryInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link SMSDeliveryInfoType }
     *     
     */
    public void setSMSDeliveryInfo(SMSDeliveryInfoType value) {
        this.smsDeliveryInfo = value;
    }

    /**
     * Gets the value of the voiceDeliveryInfo property.
     * 
     * @return
     *     possible object is
     *     {@link VoiceDeliveryInfoType }
     *     
     */
    public VoiceDeliveryInfoType getVoiceDeliveryInfo() {
        return voiceDeliveryInfo;
    }

    /**
     * Sets the value of the voiceDeliveryInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link VoiceDeliveryInfoType }
     *     
     */
    public void setVoiceDeliveryInfo(VoiceDeliveryInfoType value) {
        this.voiceDeliveryInfo = value;
    }

}
