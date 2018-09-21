
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Response to a request to deliver an SMS message, returns success or failure with reason code
 * 
 * <p>Java class for DeliverSMSResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeliverSMSResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://schemas.vip.symantec.com/2006/08/vipservice}ResponseWithStatusType"&gt;
 *       &lt;sequence minOccurs="0"&gt;
 *         &lt;element name="GatewayResponse" type="{https://schemas.vip.symantec.com/2006/08/vipservice}GatewayResponseType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeliverSMSResponseType", propOrder = {
    "gatewayResponse"
})
public class DeliverSMSResponseType
    extends ResponseWithStatusType
{

    @XmlElement(name = "GatewayResponse")
    protected String gatewayResponse;

    /**
     * Gets the value of the gatewayResponse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGatewayResponse() {
        return gatewayResponse;
    }

    /**
     * Sets the value of the gatewayResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGatewayResponse(String value) {
        this.gatewayResponse = value;
    }

}
