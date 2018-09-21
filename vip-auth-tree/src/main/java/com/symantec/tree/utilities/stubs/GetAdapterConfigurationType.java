
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Gets adapter configuration information
 * 
 * <p>Java class for GetAdapterConfigurationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetAdapterConfigurationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://schemas.vip.symantec.com/2006/08/vipservice}AccountRequestAbstractType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://schemas.vip.symantec.com/2006/08/vipservice}Adapter"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetAdapterConfigurationType", propOrder = {
    "adapter"
})
public class GetAdapterConfigurationType
    extends AccountRequestAbstractType
{

    @XmlElement(name = "Adapter", required = true)
    @XmlSchemaType(name = "string")
    protected AdapterType adapter;

    /**
     * Gets the value of the adapter property.
     * 
     * @return
     *     possible object is
     *     {@link AdapterType }
     *     
     */
    public AdapterType getAdapter() {
        return adapter;
    }

    /**
     * Sets the value of the adapter property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdapterType }
     *     
     */
    public void setAdapter(AdapterType value) {
        this.adapter = value;
    }

}
