##Synopsis
CRM Test is a Node.js test framework which calls Salesforce Rest API and create simple node.js scripts to perform different actions in salesforce. Currently CrmTest has a support of running in Amazon ec2 cloud. In this ReadMe the focus is to run CrmTest in Amazon EC2 instance having Ubuntu version.

##Motivation
CRM Test has driven from the idea of Testing as a Service. The intent is to support development of E2E scenarios using simple Node.Js scripts. 

##Tested OS
1. Mac - OSX 10.11.1, 
2. Ubuntu

##Pre-requisites
1. Follow the instructions at http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/EC2_GetStarted.html to launch an Amazon instance with Ubuntu OS flavor.
2. Connect to the headless node.
3. Download Java using OpenJDK http://openjdk.java.net/install/
4. After installing Java verify the version of JDK (CrmTest has been built with Java version 1.8.0_73)
5. Install java node module
    npm install java

##Setup Instructions
1. After going through the pre-requisites, install the CrmTest npm
    npm install crmtest
2. Installation will download the crmtest package which can be found under node_modules -> crmtest.

##How to execute the node.js module from on-prem
1. Setup your own developer organization in Salesforce by following this guide https://developer.salesforce.com/docs/atlas.en-us.api_rest.meta/api_rest/quickstart_dev_org.htm
2. After Sign up and on successful login to the developer org, not the following. The org url will show you which instance it is using to create your org. For ex: to create a developer org for myself it took na30 instance (https://na30.salesforce.com/). Also this will be our login url which we have to mention during the invocation of crmtest node modules
3. Click on Setup link in your developer org
4. From the Quick Find/Search Menu search of 'Apps'(without single quotes)
5. Under Build section link -> Create -> Click on Apps link
6. Scroll down and focus on the new button under Connected Apps Section. 
7. On clicking the New button fill all the required details
8. Please Note: Click the Enable Oauth settings under API section. This authentication mechanism will be use to connect from node modules.
9. Enter any callback address. We are not going to use the callback address
10. In the Selected OAuth Scopes select Full access
11. For further details , please refer to the help link at https://help.salesforce.com/apex/HTViewHelpDoc?id=connected_app_create.htm
12. Once the connected app is created click on it and take a note of consumer key and consumer secret
13. Open a terminal
14. Execute _npm install crmtest_
15. This will download the crmtest package which we will test to invoke different node module calls.
14. Browse to the node where you have downloaded the package
15. Go to node_modules -> CrmTest 
16. Execute the script by invoking **node crmtestclient.js**

##Tests
* First create the crmtest object
  * var crmtest = require('./crmtest.js');

* Start Invoking supported crmtest methods. Currently crmtest support following features
  * **Get OAuth access Token** : In order to get oAuth access token we should invoke the getoauth method

    ```javascript
    var response = crmtest.getoauth(
		    baseUrl,
		    "<<username>>",
			"<<password>>",
			"<<consumer secret>>",
			"<<consumer key>>");
    var accessToken = crmtest.parseresponse(response,"access_token");
    ```

  * Here baseUrl is the instance url _for ex: https://na30.salesforce.com/_
  * UserName is the username used to login to the org
  * Password in order to login to the org
  * Consumer Secret and Consumer Key can be fetched from the connected app home page.
  * Once response is received one can parse the access token by invoking the parseresponse method and querying for access_token
  
1 **Create an account record**
  ```javascript    
  response = crmtest.createaccount("Account Name", accessToken);
  var fileId = crmtest.parseresponse(response,"id");
  ```
  
  * To create an account one need to invoke createaccount method with the Account Name and accessToken received from the previous oAuth method.
  
2 **Upload a File in Chatter feed**
  ```javascript
  response = crmtest.insertChatterFeedFile("/Users/Documents/pdf.pdf", "File Name","Title", accessToken);
  var fileId = crmtest.parseresponse(response,"id");
  ```
  * In order to upload a file in chatter insertchatterfeedwithfile method is invoked
  * First parameter is the file location
  * Second parameter will be the file name
  * Third will be the file title
  * Fourth will be the oauth accesstoken
  * Once the response is recieved it can be parsed through and corresponding file id of the uploaded file can be retrieved.
   
3 **Get the status of File rendition**
  ```javascript
  response = crmtest.fileavailability(fileId,"thumbnail", accessToken);
  var staus = crmtest.parseresponse(response, "status")
  ```
  * After uploading the file in chatter feed it should spawn up rendition thread
  * Status of rendition can be verified by parsing through the response for status key.
 
_Note: Develop branch is the staging version whereas master is the release version._

##Run crmtest in Amazon ec2
1 Follow the tutorial and set up an instance http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/EC2_GetStarted.html
2 CrmTest has been verified on the **Ubuntu** version of Amazon ec2
3 Install the required Java binaries
```bash
**JDK**
sudo apt-get install openjdk-8-jdk
```
```bash
**JRE**
sudo apt-get install openjdk-8-jre
```
4 Already Node and npm will be installed in the instance, if not follow the steps at [here](https://nodejs.org/en/download/package-manager/)
5 Once Node is installed execute the following
```node
npm install java
npm install crmtest
```
6 That's it your amazon ec2 should be ready to run Salesforce e2e tests.
--In the FAQ section some common issues and troubleshoot approaches have been mentioned--

###FAQs
1. I am getting invalid_grant when I am executing the oAuth method call, How to resolve it?
A. The status invalid_grant depicts that the client machine from where you are trying to invoke the script is getting ip restricted by the org. To resolve this 
   1. Go to your org.
   2. Click Setup
   3. Under Security Controls Click Network access
   4. Alternate approach is to search for Network access in Quick find box
   5. Add a range of ip address which will have your public ip address included
   6. Save it and try again.

2. Which user should I be in order to execute this node module
A. Ideally you should be the system admin of the org. 

3. I am getting an error NoClassDefFoundError: .... How to resolve it?
A. Ideally all the jar files supported with this package should be in extracted state, but if it is not then you will get this error. To Troubleshoot this 
   * Go to ScriptTestFramework.APIStore -> target -> classes.
   * Extract the corresponding jar
   --jar -xvf httpclient-4.5.2.jar--
   * This will extract the content into org/ folder.
   * Required packages are httpclient-4.5.2.jar, httpcore-4.4.4.jar, json-20160212.jar, commons-logging-1.2.jar, org.apache.httpcomponents.httpclient_4.4.1.jar
   * There are some additional jars which are getting shipped for ongoing work support, and might not be needed.
   
###License
This is an open source initiative supported by ISC license https://opensource.org/licenses/ISC

