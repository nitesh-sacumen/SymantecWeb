
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Gets admin code for a Token
 * 
 * <p>Java class for GetAdminCodeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetAdminCodeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://schemas.vip.symantec.com/2006/08/vipservice}TokenRequestType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://schemas.vip.symantec.com/2006/08/vipservice}RequestCode"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetAdminCodeType", propOrder = {
    "requestCode"
})
public class GetAdminCodeType
    extends TokenRequestType
{

    @XmlElement(name = "RequestCode", required = true)
    protected String requestCode;

    /**
     * Gets the value of the requestCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestCode() {
        return requestCode;
    }

    /**
     * Sets the value of the requestCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestCode(String value) {
        this.requestCode = value;
    }

}
