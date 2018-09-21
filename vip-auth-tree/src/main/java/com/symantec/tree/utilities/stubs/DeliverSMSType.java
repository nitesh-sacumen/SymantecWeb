
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * XML schema to send an SMS
 * 
 * <p>Java class for DeliverSMSType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeliverSMSType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://schemas.vip.symantec.com/2006/08/vipservice}TokenRequestType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SMSOperation" type="{https://schemas.vip.symantec.com/2006/08/vipservice}SMSOperationType" minOccurs="0"/&gt;
 *         &lt;element name="SMSDeliveryInfo" type="{https://schemas.vip.symantec.com/2006/08/vipservice}SMSDeliveryInfoType"/&gt;
 *         &lt;element name="GatewayAcctInfo" type="{https://schemas.vip.symantec.com/2006/08/vipservice}GatewayAcctInfoType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeliverSMSType", propOrder = {
    "smsOperation",
    "smsDeliveryInfo",
    "gatewayAcctInfo"
})
public class DeliverSMSType
    extends TokenRequestType
{

    @XmlElement(name = "SMSOperation")
    @XmlSchemaType(name = "string")
    protected SMSOperationType smsOperation;
    @XmlElement(name = "SMSDeliveryInfo", required = true)
    protected SMSDeliveryInfoType smsDeliveryInfo;
    @XmlElement(name = "GatewayAcctInfo")
    protected GatewayAcctInfoType gatewayAcctInfo;

    /**
     * Gets the value of the smsOperation property.
     * 
     * @return
     *     possible object is
     *     {@link SMSOperationType }
     *     
     */
    public SMSOperationType getSMSOperation() {
        return smsOperation;
    }

    /**
     * Sets the value of the smsOperation property.
     * 
     * @param value
     *     allowed object is
     *     {@link SMSOperationType }
     *     
     */
    public void setSMSOperation(SMSOperationType value) {
        this.smsOperation = value;
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

}
