
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Acts as the base type for all the requests that are sent on behalf of another account ID. In such cases,
 * 			the sender will either be a super admin or a parent of the onBehalfOfAccountId.
 * 
 * <p>Java class for BaseRequestWithAccountIdType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BaseRequestWithAccountIdType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://schemas.symantec.com/vip/2011/04/vipuserservices}BaseRequestType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="onBehalfOfAccountId" type="{https://schemas.symantec.com/vip/2011/04/vipuserservices}AccountIdType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseRequestWithAccountIdType", propOrder = {
    "onBehalfOfAccountId"
})
@XmlSeeAlso({
    GetServerTimeRequestType.class,
    CreateUserRequestType.class,
    UpdateUserRequestType.class,
    DeleteUserRequestType.class,
    ClearUserPinRequestType.class,
    AddCredentialRequestType.class,
    UpdateCredentialRequestType.class,
    RemoveCredentialRequestType.class,
    GetUserInfoRequestType.class,
    GetCredentialInfoRequestType.class,
    AuthenticateUserRequestType.class,
    SetTemporaryPasswordRequestType.class,
    ClearTemporaryPasswordRequestType.class,
    SetTemporaryPasswordAttributesRequestType.class,
    GetTemporaryPasswordAttributesRequestType.class,
    SendOtpRequestType.class,
    RegisterRequestType.class,
    EvaluateRiskRequestType.class,
    ConfirmRiskRequestType.class,
    DenyRiskRequestType.class,
    CheckOtpRequestType.class,
    AuthenticateUserWithPushRequestType.class,
    AuthenticateCredentialsRequestType.class,
    PollPushStatusRequestType.class
})
public abstract class BaseRequestWithAccountIdType
    extends BaseRequestType
{

    protected String onBehalfOfAccountId;

    /**
     * Gets the value of the onBehalfOfAccountId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnBehalfOfAccountId() {
        return onBehalfOfAccountId;
    }

    /**
     * Sets the value of the onBehalfOfAccountId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnBehalfOfAccountId(String value) {
        this.onBehalfOfAccountId = value;
    }

}
