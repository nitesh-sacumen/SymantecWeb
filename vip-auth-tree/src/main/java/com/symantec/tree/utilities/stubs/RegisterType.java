
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * XML to Register phone number
 * 
 * <p>Java class for RegisterType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RegisterType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://schemas.vip.symantec.com/2006/08/vipservice}TokenRequestType"&gt;
 *       &lt;sequence minOccurs="0"&gt;
 *         &lt;element name="DeliverOTP" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
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
@XmlType(name = "RegisterType", propOrder = {
    "deliverOTP",
    "smsDeliveryInfo",
    "voiceDeliveryInfo"
})
public class RegisterType
    extends TokenRequestType
{

    @XmlElement(name = "DeliverOTP")
    protected Boolean deliverOTP;
    @XmlElement(name = "SMSDeliveryInfo")
    protected SMSDeliveryInfoType smsDeliveryInfo;
    @XmlElement(name = "VoiceDeliveryInfo")
    protected VoiceDeliveryInfoType voiceDeliveryInfo;

    /**
     * Gets the value of the deliverOTP property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDeliverOTP() {
        return deliverOTP;
    }

    /**
     * Sets the value of the deliverOTP property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDeliverOTP(Boolean value) {
        this.deliverOTP = value;
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
