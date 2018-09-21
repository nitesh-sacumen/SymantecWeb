
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Response to a request to validate an OTP for multiple Tokens.
 * 
 * <p>Java class for ValidateMultipleResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ValidateMultipleResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://schemas.vip.symantec.com/2006/08/vipservice}ResponseWithStatusType"&gt;
 *       &lt;sequence minOccurs="0"&gt;
 *         &lt;element name="SuccessfulTokenId" type="{https://schemas.vip.symantec.com/2006/08/vipservice}TokenIdType" minOccurs="0"/&gt;
 *         &lt;element name="TokenCategoryDetails" type="{https://schemas.vip.symantec.com/2006/08/vipservice}TokenCategoryDetailsType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ValidateMultipleResponseType", propOrder = {
    "successfulTokenId",
    "tokenCategoryDetails"
})
public class ValidateMultipleResponseType
    extends ResponseWithStatusType
{

    @XmlElement(name = "SuccessfulTokenId")
    protected TokenIdType successfulTokenId;
    @XmlElement(name = "TokenCategoryDetails")
    protected TokenCategoryDetailsType tokenCategoryDetails;

    /**
     * Gets the value of the successfulTokenId property.
     * 
     * @return
     *     possible object is
     *     {@link TokenIdType }
     *     
     */
    public TokenIdType getSuccessfulTokenId() {
        return successfulTokenId;
    }

    /**
     * Sets the value of the successfulTokenId property.
     * 
     * @param value
     *     allowed object is
     *     {@link TokenIdType }
     *     
     */
    public void setSuccessfulTokenId(TokenIdType value) {
        this.successfulTokenId = value;
    }

    /**
     * Gets the value of the tokenCategoryDetails property.
     * 
     * @return
     *     possible object is
     *     {@link TokenCategoryDetailsType }
     *     
     */
    public TokenCategoryDetailsType getTokenCategoryDetails() {
        return tokenCategoryDetails;
    }

    /**
     * Sets the value of the tokenCategoryDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link TokenCategoryDetailsType }
     *     
     */
    public void setTokenCategoryDetails(TokenCategoryDetailsType value) {
        this.tokenCategoryDetails = value;
    }

}
