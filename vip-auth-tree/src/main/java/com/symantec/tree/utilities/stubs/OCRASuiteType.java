
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OCRASuiteType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OCRASuiteType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="type" use="required"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;enumeration value="OCRA-1:HOTP-SHA1-6:QN06"/&gt;
 *             &lt;enumeration value="OCRA-1:HOTP-SHA1-8:QN06"/&gt;
 *             &lt;enumeration value="OCRA-1:HOTP-SHA1-6:QN08"/&gt;
 *             &lt;enumeration value="OCRA-1:HOTP-SHA1-8:QN08"/&gt;
 *             &lt;enumeration value="OCRA-1:HOTP-SHA1-6:QH40"/&gt;
 *             &lt;enumeration value="OCRA-1:HOTP-SHA1-8:QH40"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OCRASuiteType")
public class OCRASuiteType {

    @XmlAttribute(name = "type", required = true)
    protected String type;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

}
