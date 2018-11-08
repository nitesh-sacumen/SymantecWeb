<!--
 * The contents of this file are subject to the terms of the Common Development and
 * Distribution License (the License). You may not use this file except in compliance with the
 * License.
 *
 * You can obtain a copy of the License at legal/CDDLv1.0.txt. See the License for the
 * specific language governing permission and limitations under the License.
 *
 * When distributing Covered Software, include this CDDL Header Notice in each file and include
 * the License file at legal/CDDLv1.0.txt. If applicable, add the following below the CDDL
 * Header, with the fields enclosed by brackets [] replaced by your own identifying
 * information: "Portions copyright [year] [name of copyright owner]".
 *
 * Copyright ${data.get('yyyy')} ForgeRock AS.
-->
# VipAuthTreeNode

A simple authentication node for ForgeRock's [Identity Platform][forgerock_platform] 5.5 and above.

## Information

VIP Forgerock offers secondary authentication along with the authentication offered by the openam. Following are the authentication mechanisms available: 1) Push 2) OTP

## Installation

The VIP OpenAM tree nodes will be packaged as a jar file using the maven build tool and will be deployed in to the ForgeRock Access Management (AM)6 application WEB-INF/lib folder which is running on tomcat server.

## Steps

1) Configure Maven to be able to access the OpenAM repositories

2) Setup a Maven Project for building the Custom Authentication Node I.e. vip-auth-tree

3) Write the custom logic inside tree nodes to communicate with vip services

4) Change to the root directory of the Maven project of the vip Tree Node Run the mvn package command.

5) The project will generate a .jar file containing our custom nodes I.e . VIP OpenAM Tree Nodes, In the form of vip-auth-tree-1.0.jar.

6) Copy the vip-auth-tree-1.0.jar file to the WEB-INF/lib/ folder where AM is deployed

7) Restart the AM for the new plug-in to become available.

The vip tree nodes are now available in the tree designer to add to authentication trees

Following are the nodes that will be available after deploying the jar file:

![nodes-1](https://user-images.githubusercontent.com/20396535/48183641-6883e600-e355-11e8-8e07-421f399cc55b.PNG)

![nodes-2](https://user-images.githubusercontent.com/20396535/48184091-f01e2480-e356-11e8-8707-962a3fc1110a.PNG)


* VIP Add Credential
```js
This node will add credentials as credential id associtaed with user in VIP Database. There are no configurable attributes to it.
```

* VIP Add More Credentials
```js
This node gives you a screen where you can choose yes/no for add more credentilas in VIP. There are no configurable attributes to it.
```

* VIP AddCred with VerifyCode
```js
This node will add credentials as credential id and OTP  or phone number and OTP associtaed with user in VIP Database. There are no configurable attributes to it.
```

* VIP Authenticate Push Credentals
```js
This node will authenticate push credentials during registration.
Attributes to be configured are:
 * Push Display Message Text: The message which should be display on push event. Ex. VIP Push Cred
 * Push Display Message Title: The message title which should be display on push event. Ex. VIP Push
 * Push Display Message Profile. The message profile. Ex www.vip.com
```
![auth-push](https://user-images.githubusercontent.com/20396535/48187242-7c811500-e360-11e8-8bee-a7d7668aed8c.PNG)

* VIP Check Symantec OTP
```js
This node will verify OTP with username. There are no configurable attributes to it.
```

* VIP Display Creds
```js
This node gives you a screen where you need choose your credential type. Where you can choose VIP/SMS/VOICE.
Attributes to be configured are:
 * List of Creds : You need to configure key-value pair as
    0 - VIP
    1 - SMS
    2 - VOICE
```
![display](https://user-images.githubusercontent.com/20396535/48187643-b0106f00-e361-11e8-9d25-e6a6b0b38f49.PNG)


* VIP Enter CredentialID
```js
This node gives you a screen where you need to enter credential id generated on vip app. There are no configurable attributes to it.
```

* VIP Enter Phone Number
```js
This node gives you a screen where you need to enter phone number. There are no configurable attributes to it.
```

* VIP Enter SecurityCode/OTP
```js
This node gives you a screen where you need to enter OTP, which appears on given phone number . There are no configurable attributes to it.
```

* VIP OTPAuth Creds
```js
This node gives you a screen where you need choose your authentication credential type. Where you can choose SMS/VOICE.
Attributes to be configured are:
 * List of Creds : You need to configure key-value pair as
    0 - SMS
    1 - VOICE
```
![otp-auth](https://user-images.githubusercontent.com/20396535/48188130-f914f300-e362-11e8-8a38-61f611ad8450.PNG)


* VIP Poll Push Auth
```js
This node get poll push request status during authentication. There are no configurable attributes to it.
```

* VIP Poll Push Reg
```js
This node get poll push request status during registraton. There are no configurable attributes to it.
```

* VIP Push Auth User
```js
This node will authenticate push credentials during authentication.
Attributes to be configured are:
 * Push Display Message Text: The message which should be display on push event. Ex. VIP Push Cred
 * Push Display Message Title: The message title which should be display on push event. Ex. VIP Push
 * Push Display Message Profile. The message profile. Ex www.vip.com
```
![auth-push-1](https://user-images.githubusercontent.com/20396535/48188528-f8c92780-e363-11e8-95c9-480ee7f63aca.PNG)


* VIP Register User
```js
This node register user in VIP, If user dont exist. There are no configurable attributes to it.
```

** VIP Search User
```js
This node search user in VIP and get user info, if user exits. There are no configurable attributes to it.
```

## Configure the trees as follows

 * Navigate to **Realm** > **Authentication** > **Trees** > **Create Tree**
 
 ![tree](https://user-images.githubusercontent.com/20396535/48189113-66c21e80-e365-11e8-8045-326786a41aca.PNG)


## Configuring VIP Auth Tre
```js
this section depicts configuration of VIP Auth Tree
```
* Configure VIP Auth Tree as shown below

![final-tree](https://user-images.githubusercontent.com/20396535/48221988-81be7e00-e3b9-11e8-8489-d790faa833f4.PNG)


```js
 Nodes To be Configured:
    * VIP Display Creds
    * VIP OTPAuth Creds
    * VIP Authenticate Push Credentials
    * VIP Push Auth User
```

* Now access the protected site by OpenAM

![login](https://user-images.githubusercontent.com/20396535/48189557-7c841380-e366-11e8-8050-f1b54e3d8e1c.PNG)









        






 




