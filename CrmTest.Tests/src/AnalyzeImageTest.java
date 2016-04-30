import org.junit.Assert;
import org.junit.Test;

public class AnalyzeImageTest extends MasterTestObject{
	@Test
	public void testForImageAnalysis() {
		String congnitiveApiKey = "fae3ef43d2cb4ec3a4915ec13f623a2a";
		String fileId = "06936000000c7WY";
		String accessToken = this.getAccessToken();
		
		AnalyzeImageCommand analysisCommand = new AnalyzeImageCommand();
		Object response = AnalyzeImageCommand.execute(
				fileId,
				congnitiveApiKey,
				"analysis",
				accessToken);
		String analysis = response.toString();
		Assert.assertTrue(response.toString().length()>1);
	}
	
	
	@Test
	public void testForSuggestedTopicsInImage() {
		String congnitiveApiKey = "fae3ef43d2cb4ec3a4915ec13f623a2a";
		String fileId = "06936000000c7WY";
		String accessToken = this.getAccessToken();
		
		AnalyzeImageCommand analysisCommand = new AnalyzeImageCommand();
		Object response = AnalyzeImageCommand.execute(
				fileId,
				congnitiveApiKey,
				"topics",
				accessToken
				);
		String topicsSuggested = response.toString();
		Assert.assertTrue(topicsSuggested!=null);
	}
}
