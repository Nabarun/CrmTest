
import org.junit.Assert;
import org.junit.Test;

public class RecommendUserToFollowTest extends MasterTestObject{
	
	@Test
	public void testRecommendUserToFollow(){
		String accessToken = this.getAccessToken();
		RecommendMeToFollowCommand commandObject = new RecommendMeToFollowCommand(accessToken);
		Object response = commandObject.recommendMeToFollow();

		Assert.assertTrue(response != null);;
	}
}
