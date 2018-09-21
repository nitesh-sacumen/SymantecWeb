
package com.symantec.tree.utilities.stubs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PollPushStatusResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PollPushStatusResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://schemas.symantec.com/vip/2011/04/vipuserservices}BaseResponseType"&gt;
 *       &lt;sequence minOccurs="0"&gt;
 *         &lt;element name="transactionStatus" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}PushTransactionStatusType" maxOccurs="20" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PollPushStatusResponseType", propOrder = {
    "transactionStatus"
})
public class PollPushStatusResponseType
    extends BaseResponseType
{

    protected List<PushTransactionStatusType> transactionStatus;

    /**
     * Gets the value of the transactionStatus property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transactionStatus property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransactionStatus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PushTransactionStatusType }
     * 
     * 
     */
    public List<PushTransactionStatusType> getTransactionStatus() {
        if (transactionStatus == null) {
            transactionStatus = new ArrayList<PushTransactionStatusType>();
        }
        return this.transactionStatus;
    }

}
