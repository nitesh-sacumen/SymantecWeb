
package com.symantec.tree.utilities.stubs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PushAuthDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PushAuthDataType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://schemas.symantec.com/vip/2011/04/vipuserservices}AbstractAuthDataType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="displayParameters" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}KeyValuePairType" maxOccurs="20" minOccurs="0"/&gt;
 *         &lt;element name="requestParameters" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}KeyValuePairType" maxOccurs="20" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PushAuthDataType", propOrder = {
    "displayParameters",
    "requestParameters"
})
public class PushAuthDataType
    extends AbstractAuthDataType
{

    protected List<KeyValuePairType> displayParameters;
    protected List<KeyValuePairType> requestParameters;

    /**
     * Gets the value of the displayParameters property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the displayParameters property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDisplayParameters().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KeyValuePairType }
     * 
     * 
     */
    public List<KeyValuePairType> getDisplayParameters() {
        if (displayParameters == null) {
            displayParameters = new ArrayList<KeyValuePairType>();
        }
        return this.displayParameters;
    }

    /**
     * Gets the value of the requestParameters property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the requestParameters property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRequestParameters().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KeyValuePairType }
     * 
     * 
     */
    public List<KeyValuePairType> getRequestParameters() {
        if (requestParameters == null) {
            requestParameters = new ArrayList<KeyValuePairType>();
        }
        return this.requestParameters;
    }

}
