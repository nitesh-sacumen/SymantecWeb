
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Request to set the temporary password for a Token.
 * 
 * <p>Java class for SetTemporaryPasswordType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SetTemporaryPasswordType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://schemas.vip.symantec.com/2006/08/vipservice}TokenRequestType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TemporaryPassword" type="{https://schemas.vip.symantec.com/2006/08/vipservice}TempPwdType"/&gt;
 *         &lt;element name="ExpirationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="OneTimeUseOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SetTemporaryPasswordType", propOrder = {
    "temporaryPassword",
    "expirationDate",
    "oneTimeUseOnly"
})
public class SetTemporaryPasswordType
    extends TokenRequestType
{

    @XmlElement(name = "TemporaryPassword", required = true)
    protected String temporaryPassword;
    @XmlElement(name = "ExpirationDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expirationDate;
    @XmlElement(name = "OneTimeUseOnly")
    protected Boolean oneTimeUseOnly;

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

    /**
     * Gets the value of the expirationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpirationDate() {
        return expirationDate;
    }

    /**
     * Sets the value of the expirationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpirationDate(XMLGregorianCalendar value) {
        this.expirationDate = value;
    }

    /**
     * Gets the value of the oneTimeUseOnly property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOneTimeUseOnly() {
        return oneTimeUseOnly;
    }

    /**
     * Sets the value of the oneTimeUseOnly property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOneTimeUseOnly(Boolean value) {
        this.oneTimeUseOnly = value;
    }

}
