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
console.log("-----------------------File Preview--------------------------");
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

