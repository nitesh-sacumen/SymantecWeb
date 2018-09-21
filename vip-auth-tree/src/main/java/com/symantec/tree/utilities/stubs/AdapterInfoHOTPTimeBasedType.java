
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Contains the configuration information about the HOTP Time based Adapter Type.
 * 
 * <p>Java class for AdapterInfoHOTPTimeBasedType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdapterInfoHOTPTimeBasedType"&gt;
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
 *         &lt;element name="ValidationRuntimeWindow" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *               &lt;minInclusive value="2"/&gt;
 *               &lt;maxInclusive value="64"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="RunTimeSyncWindow" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *               &lt;minInclusive value="16"/&gt;
 *               &lt;maxInclusive value="256"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="AutoSyncEnable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="RunTimeAutoSyncWindow" minOccurs="0"&gt;
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
 *         &lt;element name="SuccessiveTimeStep" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *               &lt;minInclusive value="1"/&gt;
 *               &lt;maxInclusive value="4"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="InitialValidationWindow" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *               &lt;minInclusive value="2"/&gt;
 *               &lt;maxInclusive value="400"/&gt;
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
@XmlType(name = "AdapterInfoHOTPTimeBasedType", propOrder = {
    "maxFailedAttempts",
    "validationRuntimeWindow",
    "runTimeSyncWindow",
    "autoSyncEnable",
    "runTimeAutoSyncWindow",
    "autoSyncThreshold",
    "successiveTimeStep",
    "initialValidationWindow"
})
public class AdapterInfoHOTPTimeBasedType {

    @XmlElement(name = "MaxFailedAttempts")
    protected Integer maxFailedAttempts;
    @XmlElement(name = "ValidationRuntimeWindow")
    protected Integer validationRuntimeWindow;
    @XmlElement(name = "RunTimeSyncWindow")
    protected Integer runTimeSyncWindow;
    @XmlElement(name = "AutoSyncEnable")
    protected Boolean autoSyncEnable;
    @XmlElement(name = "RunTimeAutoSyncWindow")
    protected Integer runTimeAutoSyncWindow;
    @XmlElement(name = "AutoSyncThreshold")
    protected Integer autoSyncThreshold;
    @XmlElement(name = "SuccessiveTimeStep")
    protected Integer successiveTimeStep;
    @XmlElement(name = "InitialValidationWindow")
    protected Integer initialValidationWindow;

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
     * Gets the value of the validationRuntimeWindow property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getValidationRuntimeWindow() {
        return validationRuntimeWindow;
    }

    /**
     * Sets the value of the validationRuntimeWindow property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setValidationRuntimeWindow(Integer value) {
        this.validationRuntimeWindow = value;
    }

    /**
     * Gets the value of the runTimeSyncWindow property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRunTimeSyncWindow() {
        return runTimeSyncWindow;
    }

    /**
     * Sets the value of the runTimeSyncWindow property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRunTimeSyncWindow(Integer value) {
        this.runTimeSyncWindow = value;
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
     * Gets the value of the runTimeAutoSyncWindow property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRunTimeAutoSyncWindow() {
        return runTimeAutoSyncWindow;
    }

    /**
     * Sets the value of the runTimeAutoSyncWindow property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRunTimeAutoSyncWindow(Integer value) {
        this.runTimeAutoSyncWindow = value;
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

    /**
     * Gets the value of the successiveTimeStep property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSuccessiveTimeStep() {
        return successiveTimeStep;
    }

    /**
     * Sets the value of the successiveTimeStep property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSuccessiveTimeStep(Integer value) {
        this.successiveTimeStep = value;
    }

    /**
     * Gets the value of the initialValidationWindow property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getInitialValidationWindow() {
        return initialValidationWindow;
    }

    /**
     * Sets the value of the initialValidationWindow property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setInitialValidationWindow(Integer value) {
        this.initialValidationWindow = value;
    }

}
