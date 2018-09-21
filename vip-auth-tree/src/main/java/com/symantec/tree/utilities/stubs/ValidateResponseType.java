
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Response to a request to validate an OTP.
 * 
 * <p>Java class for ValidateResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ValidateResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://schemas.vip.symantec.com/2006/08/vipservice}ResponseWithStatusType"&gt;
 *       &lt;sequence minOccurs="0"&gt;
 *         &lt;element name="NetworkAlert" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
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
@XmlType(name = "ValidateResponseType", propOrder = {
    "networkAlert",
    "tokenCategoryDetails"
})
public class ValidateResponseType
    extends ResponseWithStatusType
{

    @XmlElement(name = "NetworkAlert")
    protected Boolean networkAlert;
    @XmlElement(name = "TokenCategoryDetails")
    protected TokenCategoryDetailsType tokenCategoryDetails;

    /**
     * Gets the value of the networkAlert property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNetworkAlert() {
        return networkAlert;
    }

    /**
     * Sets the value of the networkAlert property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNetworkAlert(Boolean value) {
        this.networkAlert = value;
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
