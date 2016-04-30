import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class LoginOauthTokenTest extends MasterTestObject{
	
	@Test
	public void testForAccessToken() {
		String accessToken = this.getAccessToken();
		Assert.assertTrue(accessToken.length()!=0);	
	}

}
