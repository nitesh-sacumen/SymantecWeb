
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Set or Generate a Pin and deliver to the phone number through SMS or Voice as specified.
 * 
 * <p>Java class for DeliverTxnOTPType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeliverTxnOTPType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://schemas.vip.symantec.com/2006/08/vipservice}AccountRequestAbstractType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TxnOTP" type="{https://schemas.vip.symantec.com/2006/08/vipservice}TxnOTPType" minOccurs="0"/&gt;
 *         &lt;element name="Destination" type="{https://schemas.vip.symantec.com/2006/08/vipservice}DestinationType"/&gt;
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
@XmlType(name = "DeliverTxnOTPType", propOrder = {
    "txnOTP",
    "destination",
    "smsDeliveryInfo",
    "voiceDeliveryInfo"
})
public class DeliverTxnOTPType
    extends AccountRequestAbstractType
{

    @XmlElement(name = "TxnOTP")
    protected String txnOTP;
    @XmlElement(name = "Destination", required = true)
    protected DestinationType destination;
    @XmlElement(name = "SMSDeliveryInfo")
    protected SMSDeliveryInfoType smsDeliveryInfo;
    @XmlElement(name = "VoiceDeliveryInfo")
    protected VoiceDeliveryInfoType voiceDeliveryInfo;

    /**
     * Gets the value of the txnOTP property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxnOTP() {
        return txnOTP;
    }

    /**
     * Sets the value of the txnOTP property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxnOTP(String value) {
        this.txnOTP = value;
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
