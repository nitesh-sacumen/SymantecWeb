
package com.symantec.tree.utilities.stubs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CredentialBindingDetailType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CredentialBindingDetailType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="credentialId" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}CredentialIdType"/&gt;
 *         &lt;element name="credentialType" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}CredentialTypeEnum"/&gt;
 *         &lt;element name="credentialStatus" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}CredentialStatusType" minOccurs="0"/&gt;
 *         &lt;element name="tokenCategoryDetails" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}TokenCategoryDetailsType" minOccurs="0"/&gt;
 *         &lt;element name="tokenInfo" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}TokenInformationType" minOccurs="0"/&gt;
 *         &lt;element name="bindingDetail" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}BindingDetailType"/&gt;
 *         &lt;element name="pushAttributes" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}KeyValuePairType" maxOccurs="20" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CredentialBindingDetailType", propOrder = {
    "credentialId",
    "credentialType",
    "credentialStatus",
    "tokenCategoryDetails",
    "tokenInfo",
    "bindingDetail",
    "pushAttributes"
})
public class CredentialBindingDetailType {

    @XmlElement(required = true)
    protected String credentialId;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected CredentialTypeEnum credentialType;
    protected String credentialStatus;
    protected TokenCategoryDetailsType tokenCategoryDetails;
    protected TokenInformationType tokenInfo;
    @XmlElement(required = true)
    protected BindingDetailType bindingDetail;
    protected List<KeyValuePairType> pushAttributes;

    /**
     * Gets the value of the credentialId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCredentialId() {
        return credentialId;
    }

    /**
     * Sets the value of the credentialId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCredentialId(String value) {
        this.credentialId = value;
    }

    /**
     * Gets the value of the credentialType property.
     * 
     * @return
     *     possible object is
     *     {@link CredentialTypeEnum }
     *     
     */
    public CredentialTypeEnum getCredentialType() {
        return credentialType;
    }

    /**
     * Sets the value of the credentialType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CredentialTypeEnum }
     *     
     */
    public void setCredentialType(CredentialTypeEnum value) {
        this.credentialType = value;
    }

    /**
     * Gets the value of the credentialStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCredentialStatus() {
        return credentialStatus;
    }

    /**
     * Sets the value of the credentialStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCredentialStatus(String value) {
        this.credentialStatus = value;
    }

    /**
     * Gets the value of the tokenCategoryDetails property.
     * 
     * @return
     *     possible object is
     *     {@link TokenCategoryDetailsType }
     *     
     */
    public TokenCategoryDetailsType getTokenCategoryDetails() {
        return tokenCategoryDetails;
    }

    /**
     * Sets the value of the tokenCategoryDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link TokenCategoryDetailsType }
     *     
     */
    public void setTokenCategoryDetails(TokenCategoryDetailsType value) {
        this.tokenCategoryDetails = value;
    }

    /**
     * Gets the value of the tokenInfo property.
     * 
     * @return
     *     possible object is
     *     {@link TokenInformationType }
     *     
     */
    public TokenInformationType getTokenInfo() {
        return tokenInfo;
    }

    /**
     * Sets the value of the tokenInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link TokenInformationType }
     *     
     */
    public void setTokenInfo(TokenInformationType value) {
        this.tokenInfo = value;
    }

    /**
     * Gets the value of the bindingDetail property.
     * 
     * @return
     *     possible object is
     *     {@link BindingDetailType }
     *     
     */
    public BindingDetailType getBindingDetail() {
        return bindingDetail;
    }

    /**
     * Sets the value of the bindingDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link BindingDetailType }
     *     
     */
    public void setBindingDetail(BindingDetailType value) {
        this.bindingDetail = value;
    }

    /**
     * Gets the value of the pushAttributes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pushAttributes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPushAttributes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KeyValuePairType }
     * 
     * 
     */
    public List<KeyValuePairType> getPushAttributes() {
        if (pushAttributes == null) {
            pushAttributes = new ArrayList<KeyValuePairType>();
        }
        return this.pushAttributes;
    }

}
