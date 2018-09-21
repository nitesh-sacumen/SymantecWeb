
package com.symantec.tree.utilities.stubs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConfirmRiskRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConfirmRiskRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://schemas.symantec.com/vip/2011/04/vipuserservices}BaseRequestWithAccountIdType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="UserId" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}UserIdType"/&gt;
 *         &lt;element name="EventId" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}EventIdType"/&gt;
 *         &lt;element name="VerifyMethod" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}VerifyMethodType" minOccurs="0"/&gt;
 *         &lt;element name="KeyValuePairs" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}KeyValuePairType" maxOccurs="20" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConfirmRiskRequestType", propOrder = {
    "userId",
    "eventId",
    "verifyMethod",
    "keyValuePairs"
})
public class ConfirmRiskRequestType
    extends BaseRequestWithAccountIdType
{

    @XmlElement(name = "UserId", required = true)
    protected String userId;
    @XmlElement(name = "EventId", required = true)
    protected String eventId;
    @XmlElement(name = "VerifyMethod")
    protected String verifyMethod;
    @XmlElement(name = "KeyValuePairs")
    protected List<KeyValuePairType> keyValuePairs;

    /**
     * Gets the value of the userId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserId(String value) {
        this.userId = value;
    }

    /**
     * Gets the value of the eventId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventId() {
        return eventId;
    }

    /**
     * Sets the value of the eventId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventId(String value) {
        this.eventId = value;
    }

    /**
     * Gets the value of the verifyMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVerifyMethod() {
        return verifyMethod;
    }

    /**
     * Sets the value of the verifyMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVerifyMethod(String value) {
        this.verifyMethod = value;
    }

    /**
     * Gets the value of the keyValuePairs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the keyValuePairs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKeyValuePairs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KeyValuePairType }
     * 
     * 
     */
    public List<KeyValuePairType> getKeyValuePairs() {
        if (keyValuePairs == null) {
            keyValuePairs = new ArrayList<KeyValuePairType>();
        }
        return this.keyValuePairs;
    }

}
