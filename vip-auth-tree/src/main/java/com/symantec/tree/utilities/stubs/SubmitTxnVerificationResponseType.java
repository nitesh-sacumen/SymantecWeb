
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Response to a SubmitTxnVerification request. Gives the status along with a tracking number,
 * 				that the client can use to poll.
 * 
 * <p>Java class for SubmitTxnVerificationResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubmitTxnVerificationResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://schemas.vip.symantec.com/2006/08/vipservice}ResponseWithStatusType"&gt;
 *       &lt;sequence minOccurs="0"&gt;
 *         &lt;element name="TxnId" type="{https://schemas.vip.symantec.com/2006/08/vipservice}TxnIdType" minOccurs="0"/&gt;
 *         &lt;element name="TxnOTP" type="{https://schemas.vip.symantec.com/2006/08/vipservice}TxnOTPType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubmitTxnVerificationResponseType", propOrder = {
    "txnId",
    "txnOTP"
})
public class SubmitTxnVerificationResponseType
    extends ResponseWithStatusType
{

    @XmlElement(name = "TxnId")
    protected String txnId;
    @XmlElement(name = "TxnOTP")
    protected String txnOTP;

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

}
