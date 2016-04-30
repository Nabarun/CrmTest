import org.junit.Assert;
import org.junit.Test;

public class ChatterFileFormatPreviewTest extends MasterTestObject{
	
	@Test
	public void testForValidFilePreviewFormat() {
		String fileId="069R00000005zW8";
		String formatType ="thumbnail";
		String accessToken = this.getAccessToken();
		
		String availability = ParseJsonCommand.getParsedResponse(ChatterFilePreviewFormatCommand.execute(fileId, formatType, accessToken).toString(), "status");
		
		Assert.assertEquals(availability, "Available");	
	}
	
	@Test
	public void testForInValidFilePreviewFormat() {
		String fileId="06936000000besYAAQ";
		String formatType ="thumb";
		String accessToken = this.getAccessToken();

		String availability = ParseJsonCommand.getParsedResponse(ChatterFilePreviewFormatCommand.execute(fileId, formatType, accessToken).toString(), "status");
		Assert.assertEquals(availability, "NOT_FOUND");	
	}
	
	@Test
	public void testForInsertPdfFile() {
		String fileName="Profile";
		String fileLocation ="/Users/nabarunsengupta/Documents/pdf.pdf";
		String feedText = "My Image";
		String accessToken = this.getAccessToken();
		
		ModelUploadFileRequestInNewsFeeds fileRequest = new ModelUploadFileRequestInNewsFeeds();
		fileRequest.setFeedText(feedText);
		fileRequest.setFileLocation(fileLocation);
		fileRequest.setFileName(fileName);
		
		ChatterFileApiInterface chatterObj = new ChatterFile(accessToken);
		String fileId = ParseJsonCommand.getParsedResponse(chatterObj.insertFileInNewsFeed(fileRequest),"id");
		
		Assert.assertTrue(fileId.length()!=0);	
	}
}
