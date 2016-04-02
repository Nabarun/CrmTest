# Synopsis
CRM Test is a Node.js test framework which calls Salesforce Rest API and create simple node.js scripts to perform different actions in salesforce. Currently CrmTest has a support of running in Amazon ec2 cloud. In this ReadMe the focus is to run CrmTest in Amazon EC2 instance having Ubuntu version.

###Motivation
CRM Test has driven from the idea of Testing as a Service. The intent is to support development of E2E scenarios using simple Node.Js scripts. 

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
9. For further details , please refer to the help link at https://help.salesforce.com/apex/HTViewHelpDoc?id=connected_app_create.htm
10. Once the connected app is created click on it and take a note of consumer key and consumer secret
11. Open a terminal
12. Execute 'npm install crmtest'
13. This will download the crmtest package which we will test to invoke different node module calls.
14. 
