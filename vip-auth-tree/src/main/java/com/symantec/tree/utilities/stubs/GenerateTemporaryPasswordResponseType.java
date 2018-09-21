
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Response to generate a temporary password for a Token.
 * 
 * <p>Java class for GenerateTemporaryPasswordResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GenerateTemporaryPasswordResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://schemas.vip.symantec.com/2006/08/vipservice}ResponseWithStatusType"&gt;
 *       &lt;sequence minOccurs="0"&gt;
 *         &lt;element name="TemporaryPassword" type="{https://schemas.vip.symantec.com/2006/08/vipservice}TempPwdType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GenerateTemporaryPasswordResponseType", propOrder = {
    "temporaryPassword"
})
public class GenerateTemporaryPasswordResponseType
    extends ResponseWithStatusType
{

    @XmlElement(name = "TemporaryPassword")
    protected String temporaryPassword;

    /**
     * Gets the value of the temporaryPassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemporaryPassword() {
        return temporaryPassword;
    }

    /**
     * Sets the value of the temporaryPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemporaryPassword(String value) {
        this.temporaryPassword = value;
    }

}
