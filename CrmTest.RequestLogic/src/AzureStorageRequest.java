import java.io.File;
import java.io.IOException;
import java.sql.Blob;

import com.microsoft.azure.storage.*;
import com.microsoft.azure.storage.blob.*;

public class AzureStorageRequest extends MasterRequest {

	@Override
	public Object execute(Object args) {
		ModelAzureStorage storageObject = (ModelAzureStorage)args;
		try{
			byte[] buffer =  (byte[]) getFileFromAzureStorage(storageObject.getStorageAccountName(), storageObject.getStorageAccountKey(), storageObject.getContainerName(), storageObject.getFileName());
			
			ModelUploadFileRequestInNewsFeeds fileRequest = new ModelUploadFileRequestInNewsFeeds();
			fileRequest.setFileName(storageObject.getFileName());
			fileRequest.setFileBinary(buffer);
			fileRequest.setAccessToken(storageObject.getAccessToken());
			fileRequest.setFeedText(storageObject.getFileDescription());
			UploadFileRequestInNewsFeeds uploadInstance = new UploadFileRequestInNewsFeeds();
			String response = uploadInstance.insertNewDocumentAsByteArray(fileRequest);
			return response;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * Get the file from Azure Storage
	 */
	private Object getFileFromAzureStorage(String azureStorageAccountName, String azureStorageAccountKey, String containerName, String fileName) throws Exception{
		
		byte[] buffer = null;
		try{
			//CloudStorageAccount account = CloudStorageAccount.parse(String.format(Constants.AzureStorageConnectionString, azureStorageAccountName, azureStorageAccountKey));
			
			CloudStorageAccount account = CloudStorageAccount.parse(String.format(Constants.AzureStorageConnectionString, azureStorageAccountName, azureStorageAccountKey));
            CloudBlobClient serviceClient = account.createCloudBlobClient();

            // Container name must be lower case.
            CloudBlobContainer container = serviceClient.getContainerReference(containerName);
            container.createIfNotExists();

            CloudBlockBlob blob = container.getBlockBlobReference(fileName);
            blob.downloadAttributes();
            buffer = new byte[(int) blob.getProperties().getLength()];
            
            blob.downloadToByteArray(buffer, 0);
            return buffer;
		}
		finally{
			//TODO cleanup
		}
	}

}
