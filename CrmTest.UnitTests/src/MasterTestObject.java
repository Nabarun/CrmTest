
public abstract class MasterTestObject {
	protected String getAccessToken(){
		ModelOAuthDetails oAuth = TestUtility.getNa30OAuthDetails();
		LoginCommand loginCommand = new LoginCommand();
		
		Object response = LoginCommand.execute(oAuth.getBaseUrl(), oAuth.getUserName(), oAuth.getPassword(), oAuth.getClientSecret(), oAuth.getClientId());

		String accessToken = ParseJsonCommand.getParsedResponse(response.toString(), "access_token");
		return accessToken;
	}
}
