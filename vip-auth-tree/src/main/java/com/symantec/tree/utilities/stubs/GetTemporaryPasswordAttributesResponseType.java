
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetTemporaryPasswordAttributesResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetTemporaryPasswordAttributesResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://schemas.symantec.com/vip/2011/04/vipuserservices}BaseResponseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tempPwdAttributes" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}TemporaryPasswordAttributesType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetTemporaryPasswordAttributesResponseType", propOrder = {
    "tempPwdAttributes"
})
public class GetTemporaryPasswordAttributesResponseType
    extends BaseResponseType
{

    protected TemporaryPasswordAttributesType tempPwdAttributes;

    /**
     * Gets the value of the tempPwdAttributes property.
     * 
     * @return
     *     possible object is
     *     {@link TemporaryPasswordAttributesType }
     *     
     */
    public TemporaryPasswordAttributesType getTempPwdAttributes() {
        return tempPwdAttributes;
    }

    /**
     * Sets the value of the tempPwdAttributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link TemporaryPasswordAttributesType }
     *     
     */
    public void setTempPwdAttributes(TemporaryPasswordAttributesType value) {
        this.tempPwdAttributes = value;
    }

}
