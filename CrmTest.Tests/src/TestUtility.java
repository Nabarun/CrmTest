
public class TestUtility {

	public static ModelOAuthDetails getNa30OAuthDetails(){
			String oAuthUrl ="https://na30.salesforce.com/";
			String clientId="3MVG9uudbyLbNPZNutwN5A08ykqQvi6EaM8PX0PyyR3NI0W5TFiNDhnI_TOM8Rfg9WuacsmIkApyEOTXaoyGk";
			String client_secret="7979963995394557396";
			String userName = "nabarun1@salesforce.com";
			String password ="Nabjsr123";
				
			ModelOAuthDetails obj = new ModelOAuthDetails();
			obj.setBaseUrl(oAuthUrl);
			obj.setClientId(clientId);
			obj.setClientSecret(client_secret);
			obj.setUserName(userName);
			obj.setPassword(password);
			
			return obj;
	}
}
