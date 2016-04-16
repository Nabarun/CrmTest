/**
 * http://usejsdoc.org/
 */
var crmtest = require('./crmtest.js');
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

console.log('\n');

/*
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
response = crmtest.insertchatterfeedwithfile("<<File location>>", "<<File Name>>","<<File description>>", accessToken);
console.log(response+'\n');
var fileId = crmtest.parseresponse(response,"id");
console.log(fileId);

console.log('\n');


//Post a chatter feed with a file in Azure blob
console.log("-------------------------------------------------------------");
console.log("--------------Upload a file from Azure Blob------------------")
console.log("-------------------------------------------------------------");
response = crmtest.getazureblob(
		"<<azure storage account name>>", 
		"<<azure storage account key>>", 
		"<<azure container name>>",
		"<<fileName>>", 
		"<<file Description/ FeedText>>", accessToken);
console.log(response+'\n');
var fileId = crmtest.parseresponse(response,"id");
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
}while(crmtest.parseresponse(response, "status") != "Available");


//Analyze preview image
console.log("-------------------------------------------------------------");
console.log("-----------Analyze the generated file preview----------------")
console.log("-------------------------------------------------------------");
response = crmtest.analyzeimage(fileId, "<<Microsoft Cognitive Api Key>>", accessToken);
console.log(response+'\n');
*/

//Recommend me to Follow User 
console.log("-------------------------------------------------------------");
console.log("------------------Recommend Me to Follow---------------------")
console.log("-------------------------------------------------------------");
response = crmtest.getrecommendeduserstofollow(accessToken);
console.log(response+'\n');
