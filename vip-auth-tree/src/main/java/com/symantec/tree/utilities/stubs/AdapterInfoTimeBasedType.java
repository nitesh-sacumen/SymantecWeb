
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Contains the configuration information about the Time based Adapter Type.
 * 
 * <p>Java class for AdapterInfoTimeBasedType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdapterInfoTimeBasedType"&gt;
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
 *         &lt;element name="LookAheadWindow" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *               &lt;minInclusive value="2"/&gt;
 *               &lt;maxInclusive value="64"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="DriftTime" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *               &lt;minInclusive value="1"/&gt;
 *               &lt;maxInclusive value="2"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="AutoSyncEnable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="AutoSyncLookAheadWindow" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *               &lt;minInclusive value="4"/&gt;
 *               &lt;maxInclusive value="128"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="AutoSyncThreshold" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *               &lt;minInclusive value="1"/&gt;
 *               &lt;maxInclusive value="63"/&gt;
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
@XmlType(name = "AdapterInfoTimeBasedType", propOrder = {
    "maxFailedAttempts",
    "lookAheadWindow",
    "driftTime",
    "autoSyncEnable",
    "autoSyncLookAheadWindow",
    "autoSyncThreshold"
})
public class AdapterInfoTimeBasedType {

    @XmlElement(name = "MaxFailedAttempts")
    protected Integer maxFailedAttempts;
    @XmlElement(name = "LookAheadWindow")
    protected Integer lookAheadWindow;
    @XmlElement(name = "DriftTime")
    protected Integer driftTime;
    @XmlElement(name = "AutoSyncEnable")
    protected Boolean autoSyncEnable;
    @XmlElement(name = "AutoSyncLookAheadWindow")
    protected Integer autoSyncLookAheadWindow;
    @XmlElement(name = "AutoSyncThreshold")
    protected Integer autoSyncThreshold;

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
     * Gets the value of the lookAheadWindow property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLookAheadWindow() {
        return lookAheadWindow;
    }

    /**
     * Sets the value of the lookAheadWindow property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLookAheadWindow(Integer value) {
        this.lookAheadWindow = value;
    }

    /**
     * Gets the value of the driftTime property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDriftTime() {
        return driftTime;
    }

    /**
     * Sets the value of the driftTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDriftTime(Integer value) {
        this.driftTime = value;
    }

    /**
     * Gets the value of the autoSyncEnable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAutoSyncEnable() {
        return autoSyncEnable;
    }

    /**
     * Sets the value of the autoSyncEnable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAutoSyncEnable(Boolean value) {
        this.autoSyncEnable = value;
    }

    /**
     * Gets the value of the autoSyncLookAheadWindow property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAutoSyncLookAheadWindow() {
        return autoSyncLookAheadWindow;
    }

    /**
     * Sets the value of the autoSyncLookAheadWindow property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAutoSyncLookAheadWindow(Integer value) {
        this.autoSyncLookAheadWindow = value;
    }

    /**
     * Gets the value of the autoSyncThreshold property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAutoSyncThreshold() {
        return autoSyncThreshold;
    }

    /**
     * Sets the value of the autoSyncThreshold property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAutoSyncThreshold(Integer value) {
        this.autoSyncThreshold = value;
    }

}
