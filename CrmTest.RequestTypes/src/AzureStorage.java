
public class AzureStorage implements AzureStorageInterface{

	@Override
	public Object getBlobObject(String azureStorageAccountName, 
			String azureStorageAccountKey, 
			String containerName,
			String fileName, 
			String feedDescription,
			String accessToken) {
		
		ModelAzureStorage azureObject = new ModelAzureStorage();
		azureObject.setStorageAccountName(azureStorageAccountName);
		azureObject.setStorageAccountKey(azureStorageAccountKey);
		azureObject.setFileName(fileName);
		azureObject.setFileDescription(feedDescription);
		azureObject.setContainerName(containerName);
		azureObject.setAccessToken(accessToken);
		
		RestRequestData restApiSubject = new RestRequestData();
		
		MainHttpRequest getRequest = new GetHttpRequest(restApiSubject);
		getRequest.setMethodCall(Constants.IdentifierAzureStorageGetBlob);
		 
		restApiSubject.setRequest(azureObject);
		return getRequest.getResponse();
		
	}

}
