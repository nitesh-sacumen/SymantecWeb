
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Response to a request to get token information
 * 
 * <p>Java class for GetTokenInformationResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetTokenInformationResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://schemas.vip.symantec.com/2006/08/vipservice}ResponseWithStatusType"&gt;
 *       &lt;sequence minOccurs="0"&gt;
 *         &lt;element ref="{https://schemas.vip.symantec.com/2006/08/vipservice}TokenInformation" minOccurs="0"/&gt;
 *         &lt;element ref="{https://schemas.vip.symantec.com/2006/08/vipservice}NetworkIntelligence" minOccurs="0"/&gt;
 *         &lt;element name="ChallengeResponseFormat" type="{https://schemas.vip.symantec.com/2006/08/vipservice}ChallengeResponseFormatType" minOccurs="0"/&gt;
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
@XmlType(name = "GetTokenInformationResponseType", propOrder = {
    "tokenInformation",
    "networkIntelligence",
    "challengeResponseFormat",
    "tokenCategoryDetails"
})
public class GetTokenInformationResponseType
    extends ResponseWithStatusType
{

    @XmlElement(name = "TokenInformation")
    protected TokenInformationType tokenInformation;
    @XmlElement(name = "NetworkIntelligence")
    protected NetworkIntelligenceType networkIntelligence;
    @XmlElement(name = "ChallengeResponseFormat")
    protected ChallengeResponseFormatType challengeResponseFormat;
    @XmlElement(name = "TokenCategoryDetails")
    protected TokenCategoryDetailsType tokenCategoryDetails;

    /**
     * Gets the value of the tokenInformation property.
     * 
     * @return
     *     possible object is
     *     {@link TokenInformationType }
     *     
     */
    public TokenInformationType getTokenInformation() {
        return tokenInformation;
    }

    /**
     * Sets the value of the tokenInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link TokenInformationType }
     *     
     */
    public void setTokenInformation(TokenInformationType value) {
        this.tokenInformation = value;
    }

    /**
     * Gets the value of the networkIntelligence property.
     * 
     * @return
     *     possible object is
     *     {@link NetworkIntelligenceType }
     *     
     */
    public NetworkIntelligenceType getNetworkIntelligence() {
        return networkIntelligence;
    }

    /**
     * Sets the value of the networkIntelligence property.
     * 
     * @param value
     *     allowed object is
     *     {@link NetworkIntelligenceType }
     *     
     */
    public void setNetworkIntelligence(NetworkIntelligenceType value) {
        this.networkIntelligence = value;
    }

    /**
     * Gets the value of the challengeResponseFormat property.
     * 
     * @return
     *     possible object is
     *     {@link ChallengeResponseFormatType }
     *     
     */
    public ChallengeResponseFormatType getChallengeResponseFormat() {
        return challengeResponseFormat;
    }

    /**
     * Sets the value of the challengeResponseFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChallengeResponseFormatType }
     *     
     */
    public void setChallengeResponseFormat(ChallengeResponseFormatType value) {
        this.challengeResponseFormat = value;
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
