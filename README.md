## Synopsis
CRM Test is a Node.js test framework which calls Salesforce Rest API and create simple node.js scripts to perform different actions in salesforce. Currently CrmTest has a support of running in Amazon ec2 cloud. In this ReadMe the focus is to run CrmTest in Amazon EC2 instance having Ubuntu version.

###Motivation
CRM Test has driven from the idea of Testing as a Service. The intent is to support development of E2E scenarios using simple Node.Js scripts. 

###Tested OS
Mac - OSX 10.11.1
Ubuntu

###Pre-requisites
1. Follow the instructions at http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/EC2_GetStarted.html to launch an Amazon instance with Ubuntu OS flavor.
2. Connect to the headless node.
3. Download Java using OpenJDK http://openjdk.java.net/install/
4. After installing Java verify the version of JDK (CrmTest has been built with Java version 1.8.0_73)
5. Install java node module
    npm install java

###Setup Instructions
1. After going through the pre-requisites, install the CrmTest npm
    npm install crmtest
2. Installation will download the crmtest package which can be found under node_modules -> crmtest.

###How to execute the node.js module from on-prem
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

###


###FAQs
1. I am getting invalid_grant when I am executing the oAuth method call, How to resolve it?
A. The status invalid_grant depicts that the client machine from where you are trying to invoke the script is getting ip restricted by the org. To resolve this 
   1. Go to your org.
   2. Click Setup
   3. Under Security Controls Click Network access
   4. Alternate approach is to search for Network access in Quick find box
   5. Add a range of ip address which will have your public ip address included
   6. Save it and try again.
