
package com.symantec.tree.utilities.stubs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * class for all request messages that have token id
 * 
 * <p>Java class for MultipleTokensRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MultipleTokensRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://schemas.vip.symantec.com/2006/08/vipservice}AccountRequestAbstractType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TokenIds" type="{https://schemas.vip.symantec.com/2006/08/vipservice}TokenIdType" maxOccurs="5"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MultipleTokensRequestType", propOrder = {
    "tokenIds"
})
@XmlSeeAlso({
    ValidateCRType.class
})
public abstract class MultipleTokensRequestType
    extends AccountRequestAbstractType
{

    @XmlElement(name = "TokenIds", required = true)
    protected List<TokenIdType> tokenIds;

    /**
     * Gets the value of the tokenIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tokenIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTokenIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TokenIdType }
     * 
     * 
     */
    public List<TokenIdType> getTokenIds() {
        if (tokenIds == null) {
            tokenIds = new ArrayList<TokenIdType>();
        }
        return this.tokenIds;
    }

}
