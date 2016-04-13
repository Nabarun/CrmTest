
public interface AzureStorageInterface {
	public Object getBlobObject(String azureStorageAccountName, String azureStorageAccountKey, String containerName, String fileName, String feedDescription, String accessToken);
}
