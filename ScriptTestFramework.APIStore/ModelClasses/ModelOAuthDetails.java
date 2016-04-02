
public class ModelOAuthDetails {
	private String baseUrl;
	private String userName;
	private String password;
	private String clientId;
	private String clientSecret;
	private String redirectUri;
	
	String getBaseUrl() {
		return baseUrl;
	}

	void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	protected String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	protected String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	protected String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	protected String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	protected String getRedirectUri() {
		return redirectUri;
	}

	void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}
}
