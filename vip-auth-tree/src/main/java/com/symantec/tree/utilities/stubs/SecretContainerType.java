
package com.symantec.tree.utilities.stubs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SecretContainerType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SecretContainerType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="EncryptionMethod" type="{https://schemas.vip.symantec.com/2006/08/vipservice}EncryptionMethodType"/&gt;
 *         &lt;element name="Device" type="{https://schemas.vip.symantec.com/2006/08/vipservice}DeviceType" maxOccurs="100"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Version" use="required" type="{https://schemas.vip.symantec.com/2006/08/vipservice}VersionType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SecretContainerType", propOrder = {
    "encryptionMethod",
    "device"
})
public class SecretContainerType {

    @XmlElement(name = "EncryptionMethod", required = true)
    protected EncryptionMethodType encryptionMethod;
    @XmlElement(name = "Device", required = true)
    protected List<DeviceType> device;
    @XmlAttribute(name = "Version", required = true)
    protected String version;

    /**
     * Gets the value of the encryptionMethod property.
     * 
     * @return
     *     possible object is
     *     {@link EncryptionMethodType }
     *     
     */
    public EncryptionMethodType getEncryptionMethod() {
        return encryptionMethod;
    }

    /**
     * Sets the value of the encryptionMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link EncryptionMethodType }
     *     
     */
    public void setEncryptionMethod(EncryptionMethodType value) {
        this.encryptionMethod = value;
    }

    /**
     * Gets the value of the device property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the device property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDevice().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DeviceType }
     * 
     * 
     */
    public List<DeviceType> getDevice() {
        if (device == null) {
            device = new ArrayList<DeviceType>();
        }
        return this.device;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

}
