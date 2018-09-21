
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Contains the information of an account.
 * 
 * <p>Java class for AccountInformationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AccountInformationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="OrganizationName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="OrganizationUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="JurisdictionHash" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ServiceEndDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccountInformationType", propOrder = {
    "organizationName",
    "organizationUnit",
    "jurisdictionHash",
    "serviceEndDate"
})
public class AccountInformationType {

    @XmlElement(name = "OrganizationName", required = true)
    protected String organizationName;
    @XmlElement(name = "OrganizationUnit")
    protected String organizationUnit;
    @XmlElement(name = "JurisdictionHash", required = true)
    protected String jurisdictionHash;
    @XmlElement(name = "ServiceEndDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar serviceEndDate;

    /**
     * Gets the value of the organizationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrganizationName() {
        return organizationName;
    }

    /**
     * Sets the value of the organizationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrganizationName(String value) {
        this.organizationName = value;
    }

    /**
     * Gets the value of the organizationUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrganizationUnit() {
        return organizationUnit;
    }

    /**
     * Sets the value of the organizationUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrganizationUnit(String value) {
        this.organizationUnit = value;
    }

    /**
     * Gets the value of the jurisdictionHash property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJurisdictionHash() {
        return jurisdictionHash;
    }

    /**
     * Sets the value of the jurisdictionHash property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJurisdictionHash(String value) {
        this.jurisdictionHash = value;
    }

    /**
     * Gets the value of the serviceEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getServiceEndDate() {
        return serviceEndDate;
    }

    /**
     * Sets the value of the serviceEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setServiceEndDate(XMLGregorianCalendar value) {
        this.serviceEndDate = value;
    }

}
