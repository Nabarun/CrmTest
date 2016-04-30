
public class AzureStorageCommand {
	public static Object getBlob(String azureStorageAccountName, String azureStorageAccountKey, String containerName, String fileName, String feedDescription, String accessToken) {
		AzureStorageInterface storage = new AzureStorage();
		return storage.getBlobObject(azureStorageAccountName, azureStorageAccountKey, containerName, fileName, feedDescription, accessToken);
	}
}
