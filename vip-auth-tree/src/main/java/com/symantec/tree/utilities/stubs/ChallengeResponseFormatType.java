
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Contains information on the challenge/response formats.
 * 
 * <p>Java class for ChallengeResponseFormatType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ChallengeResponseFormatType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ChallengeFormat" type="{https://schemas.vip.symantec.com/2006/08/vipservice}ChallengeFormatType"/&gt;
 *         &lt;element name="ChallengeLength" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="ResponseLength" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChallengeResponseFormatType", propOrder = {
    "challengeFormat",
    "challengeLength",
    "responseLength"
})
public class ChallengeResponseFormatType {

    @XmlElement(name = "ChallengeFormat", required = true)
    @XmlSchemaType(name = "string")
    protected ChallengeFormatType challengeFormat;
    @XmlElement(name = "ChallengeLength")
    protected int challengeLength;
    @XmlElement(name = "ResponseLength")
    protected int responseLength;

    /**
     * Gets the value of the challengeFormat property.
     * 
     * @return
     *     possible object is
     *     {@link ChallengeFormatType }
     *     
     */
    public ChallengeFormatType getChallengeFormat() {
        return challengeFormat;
    }

    /**
     * Sets the value of the challengeFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChallengeFormatType }
     *     
     */
    public void setChallengeFormat(ChallengeFormatType value) {
        this.challengeFormat = value;
    }

    /**
     * Gets the value of the challengeLength property.
     * 
     */
    public int getChallengeLength() {
        return challengeLength;
    }

    /**
     * Sets the value of the challengeLength property.
     * 
     */
    public void setChallengeLength(int value) {
        this.challengeLength = value;
    }

    /**
     * Gets the value of the responseLength property.
     * 
     */
    public int getResponseLength() {
        return responseLength;
    }

    /**
     * Sets the value of the responseLength property.
     * 
     */
    public void setResponseLength(int value) {
        this.responseLength = value;
    }

}
