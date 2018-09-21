
package com.symantec.tree.utilities.stubs;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TokenCategoryDetailsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TokenCategoryDetailsType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CategoryId" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="FormFactor" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}FormFactorType"/&gt;
 *         &lt;element name="MovingFactor" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}MovingFactorType"/&gt;
 *         &lt;element name="OtpGeneratedBy" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}OtpGeneratedByType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TokenCategoryDetailsType", propOrder = {
    "categoryId",
    "formFactor",
    "movingFactor",
    "otpGeneratedBy"
})
public class TokenCategoryDetailsType {

    @XmlElement(name = "CategoryId", required = true)
    protected BigInteger categoryId;
    @XmlElement(name = "FormFactor", required = true)
    protected String formFactor;
    @XmlElement(name = "MovingFactor", required = true)
    @XmlSchemaType(name = "string")
    protected MovingFactorType movingFactor;
    @XmlElement(name = "OtpGeneratedBy", required = true)
    @XmlSchemaType(name = "string")
    protected OtpGeneratedByType otpGeneratedBy;

    /**
     * Gets the value of the categoryId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCategoryId() {
        return categoryId;
    }

    /**
     * Sets the value of the categoryId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCategoryId(BigInteger value) {
        this.categoryId = value;
    }

    /**
     * Gets the value of the formFactor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormFactor() {
        return formFactor;
    }

    /**
     * Sets the value of the formFactor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormFactor(String value) {
        this.formFactor = value;
    }

    /**
     * Gets the value of the movingFactor property.
     * 
     * @return
     *     possible object is
     *     {@link MovingFactorType }
     *     
     */
    public MovingFactorType getMovingFactor() {
        return movingFactor;
    }

    /**
     * Sets the value of the movingFactor property.
     * 
     * @param value
     *     allowed object is
     *     {@link MovingFactorType }
     *     
     */
    public void setMovingFactor(MovingFactorType value) {
        this.movingFactor = value;
    }

    /**
     * Gets the value of the otpGeneratedBy property.
     * 
     * @return
     *     possible object is
     *     {@link OtpGeneratedByType }
     *     
     */
    public OtpGeneratedByType getOtpGeneratedBy() {
        return otpGeneratedBy;
    }

    /**
     * Sets the value of the otpGeneratedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link OtpGeneratedByType }
     *     
     */
    public void setOtpGeneratedBy(OtpGeneratedByType value) {
        this.otpGeneratedBy = value;
    }

}
