
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Contains the configuration information about the Server OTP Adapter Type.
 * 
 * <p>Java class for AdapterInfoServerOTPType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdapterInfoServerOTPType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MaxFailedAttempts" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *               &lt;minInclusive value="2"/&gt;
 *               &lt;maxInclusive value="64"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ValidityPeriod" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *               &lt;minInclusive value="60"/&gt;
 *               &lt;maxInclusive value="600"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdapterInfoServerOTPType", propOrder = {
    "maxFailedAttempts",
    "validityPeriod"
})
@XmlSeeAlso({
    AdapterInfoSMSOTPType.class,
    AdapterInfoVoiceOTPType.class
})
public class AdapterInfoServerOTPType {

    @XmlElement(name = "MaxFailedAttempts")
    protected Integer maxFailedAttempts;
    @XmlElement(name = "ValidityPeriod")
    protected Integer validityPeriod;

    /**
     * Gets the value of the maxFailedAttempts property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxFailedAttempts() {
        return maxFailedAttempts;
    }

    /**
     * Sets the value of the maxFailedAttempts property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxFailedAttempts(Integer value) {
        this.maxFailedAttempts = value;
    }

    /**
     * Gets the value of the validityPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getValidityPeriod() {
        return validityPeriod;
    }

    /**
     * Sets the value of the validityPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setValidityPeriod(Integer value) {
        this.validityPeriod = value;
    }

}
