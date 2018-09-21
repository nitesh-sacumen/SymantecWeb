
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Contains the information of an account.
 * 
 * <p>Java class for FeatureListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FeatureListType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TokenShared" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FeatureListType", propOrder = {
    "tokenShared"
})
public class FeatureListType {

    @XmlElement(name = "TokenShared")
    protected boolean tokenShared;

    /**
     * Gets the value of the tokenShared property.
     * 
     */
    public boolean isTokenShared() {
        return tokenShared;
    }

    /**
     * Sets the value of the tokenShared property.
     * 
     */
    public void setTokenShared(boolean value) {
        this.tokenShared = value;
    }

}
