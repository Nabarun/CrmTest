
public class ModelAzureStorage {

	private String storageAccountName;
	private String storageAccountKey;
	private String containerName;
	private String fileName;
	private String fileDescription;
	private String accessToken;
	
	protected String getStorageAccountName() {
		return storageAccountName;
	}
	protected void setStorageAccountName(String storageAccountName) {
		this.storageAccountName = storageAccountName;
	}
	
	protected String getStorageAccountKey() {
		return storageAccountKey;
	}
	protected void setStorageAccountKey(String storageAccountKey) {
		this.storageAccountKey = storageAccountKey;
	}
	
	protected String getContainerName() {
		return containerName;
	}
	protected void setContainerName(String containerName) {
		this.containerName = containerName;
	}
	
	protected String getFileName() {
		return fileName;
	}
	protected void setFileName(String fileName) {
		this.fileName = fileName;
	}
	protected String getAccessToken() {
		return accessToken;
	}
	protected void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	protected String getFileDescription() {
		return fileDescription;
	}
	protected void setFileDescription(String fileDescription) {
		this.fileDescription = fileDescription;
	}

	
}
