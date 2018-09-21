
package com.symantec.tree.utilities.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Generic Status response for the UA Web Service.
 *            		    Status Response messages also contains a status indicating success or cause of failure.
 * 
 * <p>Java class for ResponseWithStatusType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResponseWithStatusType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://schemas.vip.symantec.com/2006/08/vipservice}ResponseAbstractType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Status" type="{https://schemas.vip.symantec.com/2006/08/vipservice}StatusType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseWithStatusType", propOrder = {
    "status"
})
@XmlSeeAlso({
    GetServerTimeResponseType.class,
    ActivateTokenResponseType.class,
    DeactivateTokenResponseType.class,
    EnableTokenResponseType.class,
    DisableTokenResponseType.class,
    UnlockTokenResponseType.class,
    ValidateResponseType.class,
    SynchronizeResponseType.class,
    ValidateMultipleResponseType.class,
    CheckOTPResponseType.class,
    SetTemporaryPasswordResponseType.class,
    SetTemporaryPwdExpirationResponseType.class,
    GetTemporaryPwdExpirationResponseType.class,
    GetTokenInformationResponseType.class,
    GetAdminCodeResponseType.class,
    SendOTPResponseType.class,
    RegisterResponseType.class,
    SendTemporaryPasswordResponseType.class,
    GenerateTemporaryPasswordResponseType.class,
    SubmitTxnVerificationResponseType.class,
    PollTxnVerificationResponseType.class,
    DeliverTxnOTPResponseType.class,
    VerifyTxnOTPResponseType.class,
    ValidateCRResponseType.class,
    DeliverSMSResponseType.class,
    GetAdapterConfigurationResponseType.class,
    SetAdapterConfigurationResponseType.class,
    SetTokenAttributesResponseType.class
})
public class ResponseWithStatusType
    extends ResponseAbstractType
{

    @XmlElement(name = "Status", required = true)
    protected StatusType status;

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link StatusType }
     *     
     */
    public StatusType getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusType }
     *     
     */
    public void setStatus(StatusType value) {
        this.status = value;
    }

}
