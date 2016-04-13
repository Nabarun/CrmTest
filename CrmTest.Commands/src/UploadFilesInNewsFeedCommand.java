
public class UploadFilesInNewsFeedCommand {
	public static Object execute(String fileLocation, String fileName, String feedText, String accessToken) {
		
		ChatterFileApiInterface insertFile = new ChatterFile(accessToken);
		ModelUploadFileRequestInNewsFeeds fileRequest = new ModelUploadFileRequestInNewsFeeds();

		fileRequest.setFileLocation(fileLocation);
		fileRequest.setFileName(fileName);
		fileRequest.setFeedText(feedText);
		
		return insertFile.insertFileInNewsFeed(fileRequest);
	}
}
