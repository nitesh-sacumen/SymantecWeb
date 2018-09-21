
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SetTemporaryPasswordRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SetTemporaryPasswordRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://schemas.symantec.com/vip/2011/04/vipuserservices}BaseRequestWithAccountIdType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="userId" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}UserIdType"/&gt;
 *         &lt;element name="temporaryPassword" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}TemporaryPasswordType" minOccurs="0"/&gt;
 *         &lt;element name="temporaryPasswordAttributes" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}TemporaryPasswordAttributesType" minOccurs="0"/&gt;
 *         &lt;choice minOccurs="0"&gt;
 *           &lt;element name="smsDeliveryInfo" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}SmsDeliveryInfoType" minOccurs="0"/&gt;
 *           &lt;element name="voiceDeliveryInfo" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}VoiceDeliveryInfoType" minOccurs="0"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SetTemporaryPasswordRequestType", propOrder = {
    "userId",
    "temporaryPassword",
    "temporaryPasswordAttributes",
    "smsDeliveryInfo",
    "voiceDeliveryInfo"
})
public class SetTemporaryPasswordRequestType
    extends BaseRequestWithAccountIdType
{

    @XmlElement(required = true)
    protected String userId;
    protected String temporaryPassword;
    protected TemporaryPasswordAttributesType temporaryPasswordAttributes;
    protected SmsDeliveryInfoType smsDeliveryInfo;
    protected VoiceDeliveryInfoType voiceDeliveryInfo;

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
     * Gets the value of the temporaryPassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemporaryPassword() {
        return temporaryPassword;
    }

    /**
     * Sets the value of the temporaryPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemporaryPassword(String value) {
        this.temporaryPassword = value;
    }

    /**
     * Gets the value of the temporaryPasswordAttributes property.
     * 
     * @return
     *     possible object is
     *     {@link TemporaryPasswordAttributesType }
     *     
     */
    public TemporaryPasswordAttributesType getTemporaryPasswordAttributes() {
        return temporaryPasswordAttributes;
    }

    /**
     * Sets the value of the temporaryPasswordAttributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link TemporaryPasswordAttributesType }
     *     
     */
    public void setTemporaryPasswordAttributes(TemporaryPasswordAttributesType value) {
        this.temporaryPasswordAttributes = value;
    }

    /**
     * Gets the value of the smsDeliveryInfo property.
     * 
     * @return
     *     possible object is
     *     {@link SmsDeliveryInfoType }
     *     
     */
    public SmsDeliveryInfoType getSmsDeliveryInfo() {
        return smsDeliveryInfo;
    }

    /**
     * Sets the value of the smsDeliveryInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link SmsDeliveryInfoType }
     *     
     */
    public void setSmsDeliveryInfo(SmsDeliveryInfoType value) {
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
