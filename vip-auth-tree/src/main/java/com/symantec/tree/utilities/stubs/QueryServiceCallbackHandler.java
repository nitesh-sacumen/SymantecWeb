
/**
 * QueryServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.symantec.tree.utilities.stubs;

    /**
     *  QueryServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class QueryServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public QueryServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public QueryServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getTemporaryPasswordAttributes method
            * override this method for handling normal response from getTemporaryPasswordAttributes operation
            */
           public void receiveResultgetTemporaryPasswordAttributes(
                    QueryServiceStub.GetTemporaryPasswordAttributesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getTemporaryPasswordAttributes operation
           */
            public void receiveErrorgetTemporaryPasswordAttributes(Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getCredentialInfo method
            * override this method for handling normal response from getCredentialInfo operation
            */
           public void receiveResultgetCredentialInfo(
                    QueryServiceStub.GetCredentialInfoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCredentialInfo operation
           */
            public void receiveErrorgetCredentialInfo(Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getUserInfo method
            * override this method for handling normal response from getUserInfo operation
            */
           public void receiveResultgetUserInfo(
                    QueryServiceStub.GetUserInfoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUserInfo operation
           */
            public void receiveErrorgetUserInfo(Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getServerTime method
            * override this method for handling normal response from getServerTime operation
            */
           public void receiveResultgetServerTime(
                    QueryServiceStub.GetServerTimeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getServerTime operation
           */
            public void receiveErrorgetServerTime(Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for pollPushStatus method
            * override this method for handling normal response from pollPushStatus operation
            */
           public void receiveResultpollPushStatus(
                    QueryServiceStub.PollPushStatusResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from pollPushStatus operation
           */
            public void receiveErrorpollPushStatus(Exception e) {
            }
                


    }
    