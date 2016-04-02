/**
 * http://usejsdoc.org/
 */
var crmtest = require('./crmtest.js');
var baseUrl ="<<base url>>";
console.log('\n');

//After creating a connected app in salesforce provide these info
console.log("-------------------------------------------------------------");
console.log("-----------------Get OAuth AccessToken-----------------------")
console.log("-------------------------------------------------------------");
var response = crmtest.getoauth(
		    baseUrl,
		    "<<userName>>",
			"<<password>>",
			"<<consumer secret>>",
			"<<consumer id>>");
console.log(response +'\n');
var accessToken = crmtest.parseresponse(response,"access_token");
console.log(accessToken);

console.log('\n');

//Create an account
console.log("-------------------------------------------------------------");
console.log("-------------------Account Creation--------------------------")
console.log("-------------------------------------------------------------");
response = crmtest.createaccount("Sample Account", accessToken);
console.log(response+'\n');
console.log(crmtest.parseresponse(response,"id"));

console.log('\n');

//Insert a pdf file to the chatter post
console.log("-------------------------------------------------------------");
console.log("------------Insert Chatter Feed With File--------------------")
console.log("-------------------------------------------------------------");
response = crmtest.insertchatterfeedwithfile("<<file location>>", "<<file name>>","<<file title>>", accessToken);
console.log(response+'\n');
var fileId = crmtest.parseresponse(response,"id");
console.log(fileId);

console.log('\n');

//Validation for proper file
var tryCount = 0;
console.log("-------------------------------------------------------------");
console.log("-----------------------File Preview--------------------------")
console.log("-------------------------------------------------------------");
do{
	console.log("Try: "+ ++tryCount);
	response = crmtest.fileavailability(fileId,"thumbnail", accessToken);
	console.log(response+'\n');
}while(crmtest.parseresponse(response, "status") != "Available")

