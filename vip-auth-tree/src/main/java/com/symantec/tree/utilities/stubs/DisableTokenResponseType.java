
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Response to disable a Token.
 * 
 * <p>Java class for DisableTokenResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DisableTokenResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://schemas.vip.symantec.com/2006/08/vipservice}ResponseWithStatusType"&gt;
 *       &lt;sequence minOccurs="0"&gt;
 *         &lt;element name="SameInitialState" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DisableTokenResponseType", propOrder = {
    "sameInitialState"
})
public class DisableTokenResponseType
    extends ResponseWithStatusType
{

    @XmlElement(name = "SameInitialState")
    protected Boolean sameInitialState;

    /**
     * Gets the value of the sameInitialState property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSameInitialState() {
        return sameInitialState;
    }

    /**
     * Sets the value of the sameInitialState property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSameInitialState(Boolean value) {
        this.sameInitialState = value;
    }

}
