
package com.symantec.tree.utilities.stubs;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetCredentialInfoResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetCredentialInfoResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://schemas.symantec.com/vip/2011/04/vipuserservices}BaseResponseType"&gt;
 *       &lt;sequence minOccurs="0"&gt;
 *         &lt;element name="credentialId" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}CredentialIdType" minOccurs="0"/&gt;
 *         &lt;element name="credentialType" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}CredentialTypeEnum" minOccurs="0"/&gt;
 *         &lt;element name="credentialStatus" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}CredentialStatusType" minOccurs="0"/&gt;
 *         &lt;element name="numBindings" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="pushAttributes" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}KeyValuePairType" maxOccurs="20" minOccurs="0"/&gt;
 *         &lt;element name="userBindingDetail" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}UserBindingDetailType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetCredentialInfoResponseType", propOrder = {
    "credentialId",
    "credentialType",
    "credentialStatus",
    "numBindings",
    "pushAttributes",
    "userBindingDetail"
})
public class GetCredentialInfoResponseType
    extends BaseResponseType
{

    protected String credentialId;
    @XmlSchemaType(name = "string")
    protected CredentialTypeEnum credentialType;
    protected String credentialStatus;
    protected BigInteger numBindings;
    protected List<KeyValuePairType> pushAttributes;
    protected List<UserBindingDetailType> userBindingDetail;

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
     * Gets the value of the numBindings property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumBindings() {
        return numBindings;
    }

    /**
     * Sets the value of the numBindings property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumBindings(BigInteger value) {
        this.numBindings = value;
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

    /**
     * Gets the value of the userBindingDetail property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the userBindingDetail property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUserBindingDetail().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UserBindingDetailType }
     * 
     * 
     */
    public List<UserBindingDetailType> getUserBindingDetail() {
        if (userBindingDetail == null) {
            userBindingDetail = new ArrayList<UserBindingDetailType>();
        }
        return this.userBindingDetail;
    }

}
