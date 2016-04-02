
public class LoginCommand {

	static ModelOAuthDetails oAuth;
	
	public static Object execute(String baseUrl, String userName, String password, String clientSecret, String clientId) {
		
		//First initialize the Base Url
		Constants.LoginUrl = baseUrl;
		
		oAuth = new ModelOAuthDetails();
		oAuth.setUserName(userName);
		oAuth.setPassword(password);
		oAuth.setClientId(clientId);
		oAuth.setClientSecret(clientSecret);
		
		OauthApiInterface oAuthLogic = new OAuthAuthentication();
		return oAuthLogic.getAccessToken(oAuth);
	}

}
