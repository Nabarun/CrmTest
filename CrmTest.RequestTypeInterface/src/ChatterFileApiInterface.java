/*
 * This api interface will deal with everything in chatter file api
 */
public interface ChatterFileApiInterface {
	public String getFileWithFormatAvailability(String fileId, String formatType);
	
	public String insertFileInNewsFeed(ModelUploadFileRequestInNewsFeeds fileDetails);
}
