
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Response to a DeliverTxnOTP request.
 * 
 * <p>Java class for DeliverTxnOTPResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeliverTxnOTPResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://schemas.vip.symantec.com/2006/08/vipservice}ResponseWithStatusType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TxnId" type="{https://schemas.vip.symantec.com/2006/08/vipservice}TxnIdType" minOccurs="0"/&gt;
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
@XmlType(name = "DeliverTxnOTPResponseType", propOrder = {
    "txnId",
    "gatewayResponse"
})
public class DeliverTxnOTPResponseType
    extends ResponseWithStatusType
{

    @XmlElement(name = "TxnId")
    protected String txnId;
    @XmlElement(name = "GatewayResponse")
    protected String gatewayResponse;

    /**
     * Gets the value of the txnId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxnId() {
        return txnId;
    }

    /**
     * Sets the value of the txnId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxnId(String value) {
        this.txnId = value;
    }

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
