
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Recovery code
 * 
 * <p>Java class for GetAdminCodeResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetAdminCodeResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://schemas.vip.symantec.com/2006/08/vipservice}ResponseWithStatusType"&gt;
 *       &lt;sequence minOccurs="0"&gt;
 *         &lt;element name="RecoveryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetAdminCodeResponseType", propOrder = {
    "recoveryCode"
})
public class GetAdminCodeResponseType
    extends ResponseWithStatusType
{

    @XmlElement(name = "RecoveryCode")
    protected String recoveryCode;

    /**
     * Gets the value of the recoveryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecoveryCode() {
        return recoveryCode;
    }

    /**
     * Sets the value of the recoveryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecoveryCode(String value) {
        this.recoveryCode = value;
    }

}
