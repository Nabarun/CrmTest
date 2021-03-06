/**
 * http://usejsdoc.org/
 */
var crmtest = require('./CrmTest/crmtest.js');
var baseUrl ="example https://na30.salesforce.com/";
console.log('\n');

//After creating a connected app in salesforce provide these info
console.log("-------------------------------------------------------------");
console.log("-----------------Get OAuth AccessToken-----------------------")
console.log("-------------------------------------------------------------");
var response = crmtest.getoauth(
		        baseUrl,
		        "<<Salesforce User Name>>",
			"<<Salesforce User Password>>",
			"<<Salesforce Connected App Client Secret>>",
			"<<Salesforce Connected App Client Id>>");
console.log(response +'\n');
var accessToken = crmtest.parseresponse(response,"access_token");
console.log(accessToken);
