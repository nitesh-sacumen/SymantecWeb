
package com.symantec.tree.utilities.stubs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * Contains the network intelligence information for a specific token.
 * 
 * <p>Java class for NetworkIntelligenceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NetworkIntelligenceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="NumberOfParties" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *         &lt;element name="TokenState" maxOccurs="5" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Total" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *                   &lt;element name="Reason" maxOccurs="100" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;int"&gt;
 *                           &lt;attribute name="type" use="required" type="{https://schemas.vip.symantec.com/2006/08/vipservice}ReasonType" /&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/simpleContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="type" use="required" type="{https://schemas.vip.symantec.com/2006/08/vipservice}TokenStatusType" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="GlobalFailureCount" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NetworkIntelligenceType", propOrder = {
    "numberOfParties",
    "tokenState",
    "globalFailureCount"
})
public class NetworkIntelligenceType {

    @XmlElement(name = "NumberOfParties")
    @XmlSchemaType(name = "unsignedShort")
    protected int numberOfParties;
    @XmlElement(name = "TokenState")
    protected List<NetworkIntelligenceType.TokenState> tokenState;
    @XmlElement(name = "GlobalFailureCount")
    @XmlSchemaType(name = "unsignedShort")
    protected int globalFailureCount;

    /**
     * Gets the value of the numberOfParties property.
     * 
     */
    public int getNumberOfParties() {
        return numberOfParties;
    }

    /**
     * Sets the value of the numberOfParties property.
     * 
     */
    public void setNumberOfParties(int value) {
        this.numberOfParties = value;
    }

    /**
     * Gets the value of the tokenState property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tokenState property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTokenState().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NetworkIntelligenceType.TokenState }
     * 
     * 
     */
    public List<NetworkIntelligenceType.TokenState> getTokenState() {
        if (tokenState == null) {
            tokenState = new ArrayList<NetworkIntelligenceType.TokenState>();
        }
        return this.tokenState;
    }

    /**
     * Gets the value of the globalFailureCount property.
     * 
     */
    public int getGlobalFailureCount() {
        return globalFailureCount;
    }

    /**
     * Sets the value of the globalFailureCount property.
     * 
     */
    public void setGlobalFailureCount(int value) {
        this.globalFailureCount = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="Total" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
     *         &lt;element name="Reason" maxOccurs="100" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;simpleContent&gt;
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;int"&gt;
     *                 &lt;attribute name="type" use="required" type="{https://schemas.vip.symantec.com/2006/08/vipservice}ReasonType" /&gt;
     *               &lt;/extension&gt;
     *             &lt;/simpleContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="type" use="required" type="{https://schemas.vip.symantec.com/2006/08/vipservice}TokenStatusType" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "total",
        "reason"
    })
    public static class TokenState {

        @XmlElement(name = "Total")
        protected int total;
        @XmlElement(name = "Reason")
        protected List<NetworkIntelligenceType.TokenState.Reason> reason;
        @XmlAttribute(name = "type", required = true)
        protected TokenStatusType type;

        /**
         * Gets the value of the total property.
         * 
         */
        public int getTotal() {
            return total;
        }

        /**
         * Sets the value of the total property.
         * 
         */
        public void setTotal(int value) {
            this.total = value;
        }

        /**
         * Gets the value of the reason property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the reason property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getReason().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link NetworkIntelligenceType.TokenState.Reason }
         * 
         * 
         */
        public List<NetworkIntelligenceType.TokenState.Reason> getReason() {
            if (reason == null) {
                reason = new ArrayList<NetworkIntelligenceType.TokenState.Reason>();
            }
            return this.reason;
        }

        /**
         * Gets the value of the type property.
         * 
         * @return
         *     possible object is
         *     {@link TokenStatusType }
         *     
         */
        public TokenStatusType getType() {
            return type;
        }

        /**
         * Sets the value of the type property.
         * 
         * @param value
         *     allowed object is
         *     {@link TokenStatusType }
         *     
         */
        public void setType(TokenStatusType value) {
            this.type = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;simpleContent&gt;
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;int"&gt;
         *       &lt;attribute name="type" use="required" type="{https://schemas.vip.symantec.com/2006/08/vipservice}ReasonType" /&gt;
         *     &lt;/extension&gt;
         *   &lt;/simpleContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Reason {

            @XmlValue
            protected int value;
            @XmlAttribute(name = "type", required = true)
            protected ReasonType type;

            /**
             * Gets the value of the value property.
             * 
             */
            public int getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             */
            public void setValue(int value) {
                this.value = value;
            }

            /**
             * Gets the value of the type property.
             * 
             * @return
             *     possible object is
             *     {@link ReasonType }
             *     
             */
            public ReasonType getType() {
                return type;
            }

            /**
             * Sets the value of the type property.
             * 
             * @param value
             *     allowed object is
             *     {@link ReasonType }
             *     
             */
            public void setType(ReasonType value) {
                this.type = value;
            }

        }

    }

}
