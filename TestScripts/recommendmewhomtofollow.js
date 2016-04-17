/**
 * http://usejsdoc.org/
 */
var crmtest = require(‘./CrmTest/crmtest.js');
var baseUrl ="https://na30.salesforce.com/";
console.log('\n');

//After creating a connected app in salesforce provide these info
console.log("-------------------------------------------------------------");
console.log("-----------------Get OAuth AccessToken-----------------------")
console.log("-------------------------------------------------------------");
var response = crmtest.getoauth(
		    baseUrl,
		    "nabarun1@salesforce.com",
			"Nabjsr123",
			"7979963995394557396",
			"3MVG9uudbyLbNPZNutwN5A08ykqQvi6EaM8PX0PyyR3NI0W5TFiNDhnI_TOM8Rfg9WuacsmIkApyEOTXaoyGk");
console.log(response +'\n');
var accessToken = crmtest.parseresponse(response,"access_token");
console.log(accessToken);

//Recommend me to Follow User 
console.log("-------------------------------------------------------------");
console.log("------------------Recommend Me to Follow---------------------")
console.log("-------------------------------------------------------------");
response = crmtest.getrecommendeduserstofollow(accessToken);
console.log(response+'\n');
