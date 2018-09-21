
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DeviceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeviceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Secret" type="{https://schemas.vip.symantec.com/2006/08/vipservice}SecretType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeviceType", propOrder = {
    "secret"
})
public class DeviceType {

    @XmlElement(name = "Secret", required = true)
    protected SecretType secret;

    /**
     * Gets the value of the secret property.
     * 
     * @return
     *     possible object is
     *     {@link SecretType }
     *     
     */
    public SecretType getSecret() {
        return secret;
    }

    /**
     * Sets the value of the secret property.
     * 
     * @param value
     *     allowed object is
     *     {@link SecretType }
     *     
     */
    public void setSecret(SecretType value) {
        this.secret = value;
    }

}
