
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * class for all request messages that have token id
 * 
 * <p>Java class for TokenRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TokenRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://schemas.vip.symantec.com/2006/08/vipservice}AccountRequestAbstractType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://schemas.vip.symantec.com/2006/08/vipservice}TokenId"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TokenRequestType", propOrder = {
    "tokenId"
})
@XmlSeeAlso({
    ActivateTokenType.class,
    DeactivateTokenType.class,
    EnableTokenType.class,
    DisableTokenType.class,
    UnlockTokenType.class,
    ValidateType.class,
    SynchronizeType.class,
    CheckOTPType.class,
    SetTemporaryPasswordType.class,
    SetTemporaryPwdExpirationType.class,
    GetTemporaryPwdExpirationType.class,
    GetTokenInformationType.class,
    GetAdminCodeType.class,
    SendOTPType.class,
    RegisterType.class,
    SendTemporaryPasswordType.class,
    GenerateTemporaryPasswordType.class,
    DeliverSMSType.class,
    SetTokenAttributesType.class
})
public abstract class TokenRequestType
    extends AccountRequestAbstractType
{

    @XmlElement(name = "TokenId", required = true)
    protected TokenIdType tokenId;

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

}
