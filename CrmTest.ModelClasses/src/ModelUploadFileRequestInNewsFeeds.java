
public class ModelUploadFileRequestInNewsFeeds {
	private String fileLocation;
	private String fileName;
	private String feedText;
	private String accessToken;
	private byte[] fileBinary;
	
	String getFileLocation() {
		return fileLocation;
	}

	protected void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	protected String getFileName() {
		return fileName;
	}

	protected void setFileName(String fileName) {
		this.fileName = fileName;
	}

	protected String getFeedText() {
		return feedText;
	}

	protected void setFeedText(String feedText) {
		this.feedText = feedText;
	}
	
	protected String getAccessToken() {
		return accessToken;
	}

	protected void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	protected byte[] getFileBinary() {
		return fileBinary;
	}

	protected void setFileBinary(byte[] fileBinary) {
		this.fileBinary = fileBinary;
	}
}
