
package com.symantec.tree.utilities.stubs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * Contains the configuration information about the SMS OTP Adapter Type.
 * 
 * <p>Java class for AdapterInfoSMSOTPType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdapterInfoSMSOTPType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://schemas.vip.symantec.com/2006/08/vipservice}AdapterInfoServerOTPType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SMSFrom" type="{https://schemas.vip.symantec.com/2006/08/vipservice}SMSFromType" minOccurs="0"/&gt;
 *         &lt;element name="GatewayId" type="{https://schemas.vip.symantec.com/2006/08/vipservice}GatewayIdType" minOccurs="0"/&gt;
 *         &lt;element name="GatewayAcctInfo" type="{https://schemas.vip.symantec.com/2006/08/vipservice}GatewayAcctInfoType" minOccurs="0"/&gt;
 *         &lt;element name="Message" maxOccurs="100" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                 &lt;attribute name="type" use="required" type="{https://schemas.vip.symantec.com/2006/08/vipservice}MessageType" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdapterInfoSMSOTPType", propOrder = {
    "smsFrom",
    "gatewayId",
    "gatewayAcctInfo",
    "message"
})
public class AdapterInfoSMSOTPType
    extends AdapterInfoServerOTPType
{

    @XmlElement(name = "SMSFrom")
    protected String smsFrom;
    @XmlElement(name = "GatewayId")
    @XmlSchemaType(name = "string")
    protected GatewayIdType gatewayId;
    @XmlElement(name = "GatewayAcctInfo")
    protected GatewayAcctInfoType gatewayAcctInfo;
    @XmlElement(name = "Message")
    protected List<AdapterInfoSMSOTPType.Message> message;

    /**
     * Gets the value of the smsFrom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSMSFrom() {
        return smsFrom;
    }

    /**
     * Sets the value of the smsFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSMSFrom(String value) {
        this.smsFrom = value;
    }

    /**
     * Gets the value of the gatewayId property.
     * 
     * @return
     *     possible object is
     *     {@link GatewayIdType }
     *     
     */
    public GatewayIdType getGatewayId() {
        return gatewayId;
    }

    /**
     * Sets the value of the gatewayId property.
     * 
     * @param value
     *     allowed object is
     *     {@link GatewayIdType }
     *     
     */
    public void setGatewayId(GatewayIdType value) {
        this.gatewayId = value;
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
     * Gets the value of the message property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the message property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMessage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AdapterInfoSMSOTPType.Message }
     * 
     * 
     */
    public List<AdapterInfoSMSOTPType.Message> getMessage() {
        if (message == null) {
            message = new ArrayList<AdapterInfoSMSOTPType.Message>();
        }
        return this.message;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;simpleContent&gt;
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
     *       &lt;attribute name="type" use="required" type="{https://schemas.vip.symantec.com/2006/08/vipservice}MessageType" /&gt;
     *     &lt;/extension&gt;
     *   &lt;/simpleContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class Message {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "type", required = true)
        protected MessageType type;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the type property.
         * 
         * @return
         *     possible object is
         *     {@link MessageType }
         *     
         */
        public MessageType getType() {
            return type;
        }

        /**
         * Sets the value of the type property.
         * 
         * @param value
         *     allowed object is
         *     {@link MessageType }
         *     
         */
        public void setType(MessageType value) {
            this.type = value;
        }

    }

}
