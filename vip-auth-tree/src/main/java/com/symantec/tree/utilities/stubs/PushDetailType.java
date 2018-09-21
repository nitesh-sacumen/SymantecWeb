
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PushDetailType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PushDetailType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="pushCredentialId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="pushSent" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PushDetailType", propOrder = {
    "pushCredentialId",
    "pushSent"
})
public class PushDetailType {

    @XmlElement(required = true)
    protected String pushCredentialId;
    protected boolean pushSent;

    /**
     * Gets the value of the pushCredentialId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPushCredentialId() {
        return pushCredentialId;
    }

    /**
     * Sets the value of the pushCredentialId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPushCredentialId(String value) {
        this.pushCredentialId = value;
    }

    /**
     * Gets the value of the pushSent property.
     * 
     */
    public boolean isPushSent() {
        return pushSent;
    }

    /**
     * Sets the value of the pushSent property.
     * 
     */
    public void setPushSent(boolean value) {
        this.pushSent = value;
    }

}
