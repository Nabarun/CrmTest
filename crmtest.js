/**
 * http://usejsdoc.org/
 */
var java = require('java');

java.classpath.push('./CrmTest/target/classes');
java.classpath.push('./CrmTest/CrmTest.Api/bin');
java.classpath.push('./CrmTest/CrmTest.Commands/bin');
java.classpath.push('./CrmTest/CrmTest.Common/bin');
java.classpath.push('./CrmTest/CrmTest.ModelClasses/bin');
java.classpath.push('./CrmTest/CrmTest.RequestLogic/bin');
java.classpath.push('./CrmTest/CrmTest.RequestTypes/bin');

/*
 * GetOAuth Token
 */
exports.getoauth= function(baseUrl, username, password, clientsecret, clientid){
		loadjars();
		var loginCommand = java.import('LoginCommand');
		var oAuth = loginCommand.executeSync(baseUrl, username, password,clientsecret,clientid);
		
		//Get the OAuth Token
		return oAuth;
}

/*
 * Create an Account
 */
exports.createaccount = function(recordname, accesstoken){
	var createAccount = java.import('RecordCommand');
	var recordId = createAccount.executeSync(recordname, accesstoken);
	
	return recordId;
}

/*
 * Create a chatter feed with a file attachment
 */
exports.insertchatterfeedwithfile= function(filelocation, filename, feedtext, accesstoken){
	//Insert the chatter feed post
	var insertChatterFeedWithFile = java.import('UploadFilesInNewsFeedCommand');
	
	var response = insertChatterFeedWithFile.executeSync(filelocation, filename, feedtext, accesstoken);
	return response;
}

/*
 * Verify File and file format is present
 */
exports.fileavailability= function(fileId, fileformat, accesstoken){
		//Get the file preview
		var chatterFilePreviewFormatCommand =java.import('ChatterFilePreviewFormatCommand');
		
		var availablity = chatterFilePreviewFormatCommand.executeSync(fileId,fileformat, accesstoken);
		return availablity;
}

/*
 * Parse through the Json response for a specific String 
 */
exports.parseresponse = function(response, filter){
	var filteredResponse = java.import('ParseJsonCommand');
	
	return filteredResponse.executeSync(response, filter);
}

/*
 * Get Analysis from Preview image
 */
exports.analyzeimage = function(fileId, cognitiveKey, accessToken){

	var imageObject = java.import('AnalyzeImageCommand');
	
	var analysis = imageObject.executeSync(fileId, cognitiveKey, "analysis", accessToken);
	return analysis;
}

/*
 * Get Topics from Preview image
 */
exports.suggesttopicsinimage = function(fileId, cognitiveKey, accessToken){
	var imageObject = java.import('AnalyzeImageCommand');
	
	var topics = imageObject.executeSync(fileId, cognitiveKey, "topics", accessToken);
	return topics;
}

/*
 * Get the File from Azure blob container and upload it in Salesforce chatter feed
 */
exports.getazureblob = function(azureStorageAccountName, azureStorageAccountKey, containerName, fileName, feedText, accessToken){
	var azureObject = java.import('AzureStorageCommand');
	
	var response = azureObject.executeSync(azureStorageAccountName, azureStorageAccountKey, containerName, fileName, feedText, accessToken);
	return response;
}

/*
 * Get the Recommended users to Follow
 */
exports.getrecommendeduserstofollow = function(accessToken){
	var recommendObject = java.import('RecommendMeToFollowCommand');
	
	var response = recommendObject.recommendMeToFollow(accessToken);
	return response;
}
