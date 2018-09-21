
package com.symantec.tree.utilities.stubs;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Counter - is the Event counter
 *             		TimeStep (X) - time step in seconds
 *             		Time (T0) - UTC timestamp (number of seconds since epoch) when time step starts to count.  T0 = 0 at epoch
 * 
 * <p>Java class for UsageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UsageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AI" type="{https://schemas.vip.symantec.com/2006/08/vipservice}OtpAlgorithmIdentifierType" minOccurs="0"/&gt;
 *         &lt;element name="CR" type="{https://schemas.vip.symantec.com/2006/08/vipservice}OCRASuiteType" maxOccurs="4" minOccurs="0"/&gt;
 *         &lt;element name="Counter" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="TimeStep" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="Time" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="ClockDrift" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="otp" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *       &lt;attribute name="signing" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UsageType", propOrder = {
    "ai",
    "cr",
    "counter",
    "timeStep",
    "time",
    "clockDrift"
})
public class UsageType {

    @XmlElement(name = "AI")
    protected OtpAlgorithmIdentifierType ai;
    @XmlElement(name = "CR")
    protected List<OCRASuiteType> cr;
    @XmlElement(name = "Counter", defaultValue = "0")
    protected BigInteger counter;
    @XmlElement(name = "TimeStep", defaultValue = "30")
    protected BigInteger timeStep;
    @XmlElement(name = "Time", defaultValue = "0")
    protected BigInteger time;
    @XmlElement(name = "ClockDrift", defaultValue = "0")
    protected BigInteger clockDrift;
    @XmlAttribute(name = "otp")
    protected Boolean otp;
    @XmlAttribute(name = "signing")
    protected Boolean signing;

    /**
     * Gets the value of the ai property.
     * 
     * @return
     *     possible object is
     *     {@link OtpAlgorithmIdentifierType }
     *     
     */
    public OtpAlgorithmIdentifierType getAI() {
        return ai;
    }

    /**
     * Sets the value of the ai property.
     * 
     * @param value
     *     allowed object is
     *     {@link OtpAlgorithmIdentifierType }
     *     
     */
    public void setAI(OtpAlgorithmIdentifierType value) {
        this.ai = value;
    }

    /**
     * Gets the value of the cr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCR().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OCRASuiteType }
     * 
     * 
     */
    public List<OCRASuiteType> getCR() {
        if (cr == null) {
            cr = new ArrayList<OCRASuiteType>();
        }
        return this.cr;
    }

    /**
     * Gets the value of the counter property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCounter() {
        return counter;
    }

    /**
     * Sets the value of the counter property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCounter(BigInteger value) {
        this.counter = value;
    }

    /**
     * Gets the value of the timeStep property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTimeStep() {
        return timeStep;
    }

    /**
     * Sets the value of the timeStep property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTimeStep(BigInteger value) {
        this.timeStep = value;
    }

    /**
     * Gets the value of the time property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTime() {
        return time;
    }

    /**
     * Sets the value of the time property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTime(BigInteger value) {
        this.time = value;
    }

    /**
     * Gets the value of the clockDrift property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getClockDrift() {
        return clockDrift;
    }

    /**
     * Sets the value of the clockDrift property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setClockDrift(BigInteger value) {
        this.clockDrift = value;
    }

    /**
     * Gets the value of the otp property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isOtp() {
        if (otp == null) {
            return false;
        } else {
            return otp;
        }
    }

    /**
     * Sets the value of the otp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOtp(Boolean value) {
        this.otp = value;
    }

    /**
     * Gets the value of the signing property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isSigning() {
        if (signing == null) {
            return false;
        } else {
            return signing;
        }
    }

    /**
     * Sets the value of the signing property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSigning(Boolean value) {
        this.signing = value;
    }

}
