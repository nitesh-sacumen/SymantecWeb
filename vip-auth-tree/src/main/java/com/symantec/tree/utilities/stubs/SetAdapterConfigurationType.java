
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * sets adapter configuration information
 * 
 * <p>Java class for SetAdapterConfigurationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SetAdapterConfigurationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://schemas.vip.symantec.com/2006/08/vipservice}AccountRequestAbstractType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://schemas.vip.symantec.com/2006/08/vipservice}Adapter"/&gt;
 *         &lt;element ref="{https://schemas.vip.symantec.com/2006/08/vipservice}AdapterInfoServerOTP" minOccurs="0"/&gt;
 *         &lt;element ref="{https://schemas.vip.symantec.com/2006/08/vipservice}AdapterInfoEventBased" minOccurs="0"/&gt;
 *         &lt;element ref="{https://schemas.vip.symantec.com/2006/08/vipservice}AdapterInfoTimeBased" minOccurs="0"/&gt;
 *         &lt;element ref="{https://schemas.vip.symantec.com/2006/08/vipservice}AdapterInfoHOTPTimeBased" minOccurs="0"/&gt;
 *         &lt;element ref="{https://schemas.vip.symantec.com/2006/08/vipservice}AdapterInfoSMSOTP" minOccurs="0"/&gt;
 *         &lt;element ref="{https://schemas.vip.symantec.com/2006/08/vipservice}AdapterInfoVoiceOTP" minOccurs="0"/&gt;
 *         &lt;element ref="{https://schemas.vip.symantec.com/2006/08/vipservice}AdapterInfoChallengeResponseBased" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SetAdapterConfigurationType", propOrder = {
    "adapter",
    "adapterInfoServerOTP",
    "adapterInfoEventBased",
    "adapterInfoTimeBased",
    "adapterInfoHOTPTimeBased",
    "adapterInfoSMSOTP",
    "adapterInfoVoiceOTP",
    "adapterInfoChallengeResponseBased"
})
public class SetAdapterConfigurationType
    extends AccountRequestAbstractType
{

    @XmlElement(name = "Adapter", required = true)
    @XmlSchemaType(name = "string")
    protected AdapterType adapter;
    @XmlElement(name = "AdapterInfoServerOTP")
    protected AdapterInfoServerOTPType adapterInfoServerOTP;
    @XmlElement(name = "AdapterInfoEventBased")
    protected AdapterInfoEventBasedType adapterInfoEventBased;
    @XmlElement(name = "AdapterInfoTimeBased")
    protected AdapterInfoTimeBasedType adapterInfoTimeBased;
    @XmlElement(name = "AdapterInfoHOTPTimeBased")
    protected AdapterInfoHOTPTimeBasedType adapterInfoHOTPTimeBased;
    @XmlElement(name = "AdapterInfoSMSOTP")
    protected AdapterInfoSMSOTPType adapterInfoSMSOTP;
    @XmlElement(name = "AdapterInfoVoiceOTP")
    protected AdapterInfoVoiceOTPType adapterInfoVoiceOTP;
    @XmlElement(name = "AdapterInfoChallengeResponseBased")
    protected AdapterInfoChallengeResponseBasedType adapterInfoChallengeResponseBased;

    /**
     * Gets the value of the adapter property.
     * 
     * @return
     *     possible object is
     *     {@link AdapterType }
     *     
     */
    public AdapterType getAdapter() {
        return adapter;
    }

    /**
     * Sets the value of the adapter property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdapterType }
     *     
     */
    public void setAdapter(AdapterType value) {
        this.adapter = value;
    }

    /**
     * Gets the value of the adapterInfoServerOTP property.
     * 
     * @return
     *     possible object is
     *     {@link AdapterInfoServerOTPType }
     *     
     */
    public AdapterInfoServerOTPType getAdapterInfoServerOTP() {
        return adapterInfoServerOTP;
    }

    /**
     * Sets the value of the adapterInfoServerOTP property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdapterInfoServerOTPType }
     *     
     */
    public void setAdapterInfoServerOTP(AdapterInfoServerOTPType value) {
        this.adapterInfoServerOTP = value;
    }

    /**
     * Gets the value of the adapterInfoEventBased property.
     * 
     * @return
     *     possible object is
     *     {@link AdapterInfoEventBasedType }
     *     
     */
    public AdapterInfoEventBasedType getAdapterInfoEventBased() {
        return adapterInfoEventBased;
    }

    /**
     * Sets the value of the adapterInfoEventBased property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdapterInfoEventBasedType }
     *     
     */
    public void setAdapterInfoEventBased(AdapterInfoEventBasedType value) {
        this.adapterInfoEventBased = value;
    }

    /**
     * Gets the value of the adapterInfoTimeBased property.
     * 
     * @return
     *     possible object is
     *     {@link AdapterInfoTimeBasedType }
     *     
     */
    public AdapterInfoTimeBasedType getAdapterInfoTimeBased() {
        return adapterInfoTimeBased;
    }

    /**
     * Sets the value of the adapterInfoTimeBased property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdapterInfoTimeBasedType }
     *     
     */
    public void setAdapterInfoTimeBased(AdapterInfoTimeBasedType value) {
        this.adapterInfoTimeBased = value;
    }

    /**
     * Gets the value of the adapterInfoHOTPTimeBased property.
     * 
     * @return
     *     possible object is
     *     {@link AdapterInfoHOTPTimeBasedType }
     *     
     */
    public AdapterInfoHOTPTimeBasedType getAdapterInfoHOTPTimeBased() {
        return adapterInfoHOTPTimeBased;
    }

    /**
     * Sets the value of the adapterInfoHOTPTimeBased property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdapterInfoHOTPTimeBasedType }
     *     
     */
    public void setAdapterInfoHOTPTimeBased(AdapterInfoHOTPTimeBasedType value) {
        this.adapterInfoHOTPTimeBased = value;
    }

    /**
     * Gets the value of the adapterInfoSMSOTP property.
     * 
     * @return
     *     possible object is
     *     {@link AdapterInfoSMSOTPType }
     *     
     */
    public AdapterInfoSMSOTPType getAdapterInfoSMSOTP() {
        return adapterInfoSMSOTP;
    }

    /**
     * Sets the value of the adapterInfoSMSOTP property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdapterInfoSMSOTPType }
     *     
     */
    public void setAdapterInfoSMSOTP(AdapterInfoSMSOTPType value) {
        this.adapterInfoSMSOTP = value;
    }

    /**
     * Gets the value of the adapterInfoVoiceOTP property.
     * 
     * @return
     *     possible object is
     *     {@link AdapterInfoVoiceOTPType }
     *     
     */
    public AdapterInfoVoiceOTPType getAdapterInfoVoiceOTP() {
        return adapterInfoVoiceOTP;
    }

    /**
     * Sets the value of the adapterInfoVoiceOTP property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdapterInfoVoiceOTPType }
     *     
     */
    public void setAdapterInfoVoiceOTP(AdapterInfoVoiceOTPType value) {
        this.adapterInfoVoiceOTP = value;
    }

    /**
     * Gets the value of the adapterInfoChallengeResponseBased property.
     * 
     * @return
     *     possible object is
     *     {@link AdapterInfoChallengeResponseBasedType }
     *     
     */
    public AdapterInfoChallengeResponseBasedType getAdapterInfoChallengeResponseBased() {
        return adapterInfoChallengeResponseBased;
    }

    /**
     * Sets the value of the adapterInfoChallengeResponseBased property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdapterInfoChallengeResponseBasedType }
     *     
     */
    public void setAdapterInfoChallengeResponseBased(AdapterInfoChallengeResponseBasedType value) {
        this.adapterInfoChallengeResponseBased = value;
    }

}
