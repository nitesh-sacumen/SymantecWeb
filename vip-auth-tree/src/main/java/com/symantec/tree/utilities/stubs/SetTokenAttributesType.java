
package com.symantec.tree.utilities.stubs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Sets the token attributes.
 * 
 * <p>Java class for SetTokenAttributesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SetTokenAttributesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://schemas.vip.symantec.com/2006/08/vipservice}TokenRequestType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ProofOfPossession" type="{https://schemas.vip.symantec.com/2006/08/vipservice}DigestType"/&gt;
 *         &lt;element name="Attribute" type="{https://schemas.vip.symantec.com/2006/08/vipservice}NameValuePairType" maxOccurs="16"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SetTokenAttributesType", propOrder = {
    "proofOfPossession",
    "attribute"
})
public class SetTokenAttributesType
    extends TokenRequestType
{

    @XmlElement(name = "ProofOfPossession", required = true)
    protected DigestType proofOfPossession;
    @XmlElement(name = "Attribute", required = true)
    protected List<NameValuePairType> attribute;

    /**
     * Gets the value of the proofOfPossession property.
     * 
     * @return
     *     possible object is
     *     {@link DigestType }
     *     
     */
    public DigestType getProofOfPossession() {
        return proofOfPossession;
    }

    /**
     * Sets the value of the proofOfPossession property.
     * 
     * @param value
     *     allowed object is
     *     {@link DigestType }
     *     
     */
    public void setProofOfPossession(DigestType value) {
        this.proofOfPossession = value;
    }

    /**
     * Gets the value of the attribute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attribute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttribute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NameValuePairType }
     * 
     * 
     */
    public List<NameValuePairType> getAttribute() {
        if (attribute == null) {
            attribute = new ArrayList<NameValuePairType>();
        }
        return this.attribute;
    }

}
