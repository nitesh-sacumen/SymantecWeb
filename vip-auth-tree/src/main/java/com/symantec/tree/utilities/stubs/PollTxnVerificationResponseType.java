
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Response to a PollTxnVerification call.
 * 
 * <p>Java class for PollTxnVerificationResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PollTxnVerificationResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://schemas.vip.symantec.com/2006/08/vipservice}ResponseWithStatusType"&gt;
 *       &lt;sequence minOccurs="0"&gt;
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
@XmlType(name = "PollTxnVerificationResponseType", propOrder = {
    "txnOTP"
})
public class PollTxnVerificationResponseType
    extends ResponseWithStatusType
{

    @XmlElement(name = "TxnOTP")
    protected String txnOTP;

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
