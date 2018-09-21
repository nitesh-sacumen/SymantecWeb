
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Abstract class for all request messages that are supported by the UA Web Service. Id is a pseudo-random number used for request-response matching.
 * 
 * <p>Java class for AccountRequestAbstractType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AccountRequestAbstractType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://schemas.vip.symantec.com/2006/08/vipservice}RequestAbstractType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AuthorizerAccountId" type="{https://schemas.vip.symantec.com/2006/08/vipservice}AccountIdType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccountRequestAbstractType", propOrder = {
    "authorizerAccountId"
})
@XmlSeeAlso({
    ValidateMultipleType.class,
    SubmitTxnVerificationType.class,
    PollTxnVerificationType.class,
    DeliverTxnOTPType.class,
    VerifyTxnOTPType.class,
    GetAdapterConfigurationType.class,
    SetAdapterConfigurationType.class,
    TokenRequestType.class,
    MultipleTokensRequestType.class
})
public abstract class AccountRequestAbstractType
    extends RequestAbstractType
{

    @XmlElement(name = "AuthorizerAccountId")
    protected String authorizerAccountId;

    /**
     * Gets the value of the authorizerAccountId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorizerAccountId() {
        return authorizerAccountId;
    }

    /**
     * Sets the value of the authorizerAccountId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorizerAccountId(String value) {
        this.authorizerAccountId = value;
    }

}
