
package com.symantec.tree.utilities.stubs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Message to send voice or SMS transaction verification request.
 * 				For SMS messages the requests can only be submitted, not polled.
 * 				For voice messages the request can be submitted and optionally polled for success/failure.
 * 
 * <p>Java class for SubmitTxnVerificationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubmitTxnVerificationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://schemas.vip.symantec.com/2006/08/vipservice}AccountRequestAbstractType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PhoneNumber" type="{https://schemas.vip.symantec.com/2006/08/vipservice}PhoneNumberType"/&gt;
 *         &lt;element name="TxnOTP" type="{https://schemas.vip.symantec.com/2006/08/vipservice}TxnOTPType" minOccurs="0"/&gt;
 *         &lt;element name="Language" type="{https://schemas.vip.symantec.com/2006/08/vipservice}LanguageType" minOccurs="0"/&gt;
 *         &lt;element name="VoiceTemplateName" type="{https://schemas.vip.symantec.com/2006/08/vipservice}TemplateNameType"/&gt;
 *         &lt;element name="NamedParam" type="{https://schemas.vip.symantec.com/2006/08/vipservice}NameValuePairType" maxOccurs="16" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubmitTxnVerificationType", propOrder = {
    "phoneNumber",
    "txnOTP",
    "language",
    "voiceTemplateName",
    "namedParam"
})
public class SubmitTxnVerificationType
    extends AccountRequestAbstractType
{

    @XmlElement(name = "PhoneNumber", required = true)
    protected String phoneNumber;
    @XmlElement(name = "TxnOTP")
    protected String txnOTP;
    @XmlElement(name = "Language")
    protected String language;
    @XmlElement(name = "VoiceTemplateName", required = true)
    protected String voiceTemplateName;
    @XmlElement(name = "NamedParam")
    protected List<NameValuePairType> namedParam;

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
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Gets the value of the voiceTemplateName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVoiceTemplateName() {
        return voiceTemplateName;
    }

    /**
     * Sets the value of the voiceTemplateName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVoiceTemplateName(String value) {
        this.voiceTemplateName = value;
    }

    /**
     * Gets the value of the namedParam property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the namedParam property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNamedParam().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NameValuePairType }
     * 
     * 
     */
    public List<NameValuePairType> getNamedParam() {
        if (namedParam == null) {
            namedParam = new ArrayList<NameValuePairType>();
        }
        return this.namedParam;
    }

}
