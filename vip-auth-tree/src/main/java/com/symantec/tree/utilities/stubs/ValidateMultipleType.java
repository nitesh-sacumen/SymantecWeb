
package com.symantec.tree.utilities.stubs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Request to validate multiple Tokens with one OTP
 * 
 * <p>Java class for ValidateMultipleType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ValidateMultipleType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://schemas.vip.symantec.com/2006/08/vipservice}AccountRequestAbstractType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TokenIds" type="{https://schemas.vip.symantec.com/2006/08/vipservice}TokenIdType" maxOccurs="5" minOccurs="2"/&gt;
 *         &lt;element name="OTP" type="{https://schemas.vip.symantec.com/2006/08/vipservice}OTPType"/&gt;
 *         &lt;element name="SendSuccessfulTokenId" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ValidateMultipleType", propOrder = {
    "tokenIds",
    "otp",
    "sendSuccessfulTokenId"
})
public class ValidateMultipleType
    extends AccountRequestAbstractType
{

    @XmlElement(name = "TokenIds", required = true)
    protected List<TokenIdType> tokenIds;
    @XmlElement(name = "OTP", required = true)
    protected String otp;
    @XmlElement(name = "SendSuccessfulTokenId")
    protected Boolean sendSuccessfulTokenId;

    /**
     * Gets the value of the tokenIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tokenIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTokenIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TokenIdType }
     * 
     * 
     */
    public List<TokenIdType> getTokenIds() {
        if (tokenIds == null) {
            tokenIds = new ArrayList<TokenIdType>();
        }
        return this.tokenIds;
    }

    /**
     * Gets the value of the otp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOTP() {
        return otp;
    }

    /**
     * Sets the value of the otp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOTP(String value) {
        this.otp = value;
    }

    /**
     * Gets the value of the sendSuccessfulTokenId property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSendSuccessfulTokenId() {
        return sendSuccessfulTokenId;
    }

    /**
     * Sets the value of the sendSuccessfulTokenId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSendSuccessfulTokenId(Boolean value) {
        this.sendSuccessfulTokenId = value;
    }

}
