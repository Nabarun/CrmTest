/**
 * http://usejsdoc.org/
 */
var java = require('java');

java.classpath.push('target/classes');

/*
 * GetOAuth Token
 */
exports.getoauth= function(baseUrl, username, password, clientsecret, clientid){
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