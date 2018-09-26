
/**
 * ManagementServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.symantec.tree.utilities.stubs;

    /**
     *  ManagementServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class ManagementServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public ManagementServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public ManagementServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for setTemporaryPasswordAttributes method
            * override this method for handling normal response from setTemporaryPasswordAttributes operation
            */
           public void receiveResultsetTemporaryPasswordAttributes(
                    ManagementServiceStub.SetTemporaryPasswordAttributesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setTemporaryPasswordAttributes operation
           */
            public void receiveErrorsetTemporaryPasswordAttributes(Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for sendOtp method
            * override this method for handling normal response from sendOtp operation
            */
           public void receiveResultsendOtp(
                    ManagementServiceStub.SendOtpResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from sendOtp operation
           */
            public void receiveErrorsendOtp(Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateCredential method
            * override this method for handling normal response from updateCredential operation
            */
           public void receiveResultupdateCredential(
                    ManagementServiceStub.UpdateCredentialResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateCredential operation
           */
            public void receiveErrorupdateCredential(Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setTemporaryPassword method
            * override this method for handling normal response from setTemporaryPassword operation
            */
           public void receiveResultsetTemporaryPassword(
                    ManagementServiceStub.SetTemporaryPasswordResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setTemporaryPassword operation
           */
            public void receiveErrorsetTemporaryPassword(Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addCredential method
            * override this method for handling normal response from addCredential operation
            */
           public void receiveResultaddCredential(
                    ManagementServiceStub.AddCredentialResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addCredential operation
           */
            public void receiveErroraddCredential(Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for removeCredential method
            * override this method for handling normal response from removeCredential operation
            */
           public void receiveResultremoveCredential(
                    ManagementServiceStub.RemoveCredentialResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from removeCredential operation
           */
            public void receiveErrorremoveCredential(Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateUser method
            * override this method for handling normal response from updateUser operation
            */
           public void receiveResultupdateUser(
                    ManagementServiceStub.UpdateUserResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateUser operation
           */
            public void receiveErrorupdateUser(Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for clearUserPin method
            * override this method for handling normal response from clearUserPin operation
            */
           public void receiveResultclearUserPin(
                    ManagementServiceStub.ClearUserPinResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from clearUserPin operation
           */
            public void receiveErrorclearUserPin(Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for clearTemporaryPassword method
            * override this method for handling normal response from clearTemporaryPassword operation
            */
           public void receiveResultclearTemporaryPassword(
                    ManagementServiceStub.ClearTemporaryPasswordResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from clearTemporaryPassword operation
           */
            public void receiveErrorclearTemporaryPassword(Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for register method
            * override this method for handling normal response from register operation
            */
           public void receiveResultregister(
                    ManagementServiceStub.RegisterResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from register operation
           */
            public void receiveErrorregister(Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteUser method
            * override this method for handling normal response from deleteUser operation
            */
           public void receiveResultdeleteUser(
                    ManagementServiceStub.DeleteUserResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteUser operation
           */
            public void receiveErrordeleteUser(Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for createUser method
            * override this method for handling normal response from createUser operation
            */
           public void receiveResultcreateUser(
                    ManagementServiceStub.CreateUserResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createUser operation
           */
            public void receiveErrorcreateUser(Exception e) {
            }
                


    }
    