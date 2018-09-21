
package com.symantec.tree.utilities.stubs;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Contains the information about a token.
 * 
 * <p>Java class for TokenInformationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TokenInformationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://schemas.symantec.com/vip/2011/04/vipuserservices}TokenId"/&gt;
 *         &lt;element name="TokenKind" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element ref="{https://schemas.symantec.com/vip/2011/04/vipuserservices}Adapter"/&gt;
 *         &lt;element ref="{https://schemas.symantec.com/vip/2011/04/vipuserservices}TokenStatus"/&gt;
 *         &lt;element name="ExpirationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="TempPasswordExpirationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="TempPasswordOneTimeUse" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="LastUpdate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="ServerOTPExpires" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="TokenGroupId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Owner" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="ReportedReason" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}ReasonType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TokenInformationType", propOrder = {
    "tokenId",
    "tokenKind",
    "adapter",
    "tokenStatus",
    "expirationDate",
    "tempPasswordExpirationDate",
    "tempPasswordOneTimeUse",
    "lastUpdate",
    "serverOTPExpires",
    "tokenGroupId",
    "owner",
    "reportedReason"
})
public class TokenInformationType {

    @XmlElement(name = "TokenId", required = true)
    protected TokenIdType tokenId;
    @XmlElement(name = "TokenKind")
    protected String tokenKind;
    @XmlElement(name = "Adapter", required = true)
    @XmlSchemaType(name = "string")
    protected AdapterType adapter;
    @XmlElement(name = "TokenStatus", required = true)
    @XmlSchemaType(name = "string")
    protected TokenStatusType tokenStatus;
    @XmlElement(name = "ExpirationDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expirationDate;
    @XmlElement(name = "TempPasswordExpirationDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar tempPasswordExpirationDate;
    @XmlElement(name = "TempPasswordOneTimeUse")
    protected Boolean tempPasswordOneTimeUse;
    @XmlElement(name = "LastUpdate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastUpdate;
    @XmlElement(name = "ServerOTPExpires")
    protected BigInteger serverOTPExpires;
    @XmlElement(name = "TokenGroupId")
    protected String tokenGroupId;
    @XmlElement(name = "Owner")
    protected Boolean owner;
    @XmlElement(name = "ReportedReason")
    @XmlSchemaType(name = "string")
    protected ReasonType reportedReason;

    /**
     * Gets the value of the tokenId property.
     * 
     * @return
     *     possible object is
     *     {@link TokenIdType }
     *     
     */
    public TokenIdType getTokenId() {
        return tokenId;
    }

    /**
     * Sets the value of the tokenId property.
     * 
     * @param value
     *     allowed object is
     *     {@link TokenIdType }
     *     
     */
    public void setTokenId(TokenIdType value) {
        this.tokenId = value;
    }

    /**
     * Gets the value of the tokenKind property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTokenKind() {
        return tokenKind;
    }

    /**
     * Sets the value of the tokenKind property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTokenKind(String value) {
        this.tokenKind = value;
    }

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

    /**
     * Gets the value of the tokenStatus property.
     * 
     * @return
     *     possible object is
     *     {@link TokenStatusType }
     *     
     */
    public TokenStatusType getTokenStatus() {
        return tokenStatus;
    }

    /**
     * Sets the value of the tokenStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link TokenStatusType }
     *     
     */
    public void setTokenStatus(TokenStatusType value) {
        this.tokenStatus = value;
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
     * Gets the value of the tempPasswordExpirationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTempPasswordExpirationDate() {
        return tempPasswordExpirationDate;
    }

    /**
     * Sets the value of the tempPasswordExpirationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTempPasswordExpirationDate(XMLGregorianCalendar value) {
        this.tempPasswordExpirationDate = value;
    }

    /**
     * Gets the value of the tempPasswordOneTimeUse property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTempPasswordOneTimeUse() {
        return tempPasswordOneTimeUse;
    }

    /**
     * Sets the value of the tempPasswordOneTimeUse property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTempPasswordOneTimeUse(Boolean value) {
        this.tempPasswordOneTimeUse = value;
    }

    /**
     * Gets the value of the lastUpdate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastUpdate() {
        return lastUpdate;
    }

    /**
     * Sets the value of the lastUpdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastUpdate(XMLGregorianCalendar value) {
        this.lastUpdate = value;
    }

    /**
     * Gets the value of the serverOTPExpires property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getServerOTPExpires() {
        return serverOTPExpires;
    }

    /**
     * Sets the value of the serverOTPExpires property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setServerOTPExpires(BigInteger value) {
        this.serverOTPExpires = value;
    }

    /**
     * Gets the value of the tokenGroupId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTokenGroupId() {
        return tokenGroupId;
    }

    /**
     * Sets the value of the tokenGroupId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTokenGroupId(String value) {
        this.tokenGroupId = value;
    }

    /**
     * Gets the value of the owner property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOwner() {
        return owner;
    }

    /**
     * Sets the value of the owner property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOwner(Boolean value) {
        this.owner = value;
    }

    /**
     * Gets the value of the reportedReason property.
     * 
     * @return
     *     possible object is
     *     {@link ReasonType }
     *     
     */
    public ReasonType getReportedReason() {
        return reportedReason;
    }

    /**
     * Sets the value of the reportedReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReasonType }
     *     
     */
    public void setReportedReason(ReasonType value) {
        this.reportedReason = value;
    }

}
