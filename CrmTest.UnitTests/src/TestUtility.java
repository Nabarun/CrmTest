
public class TestUtility {

	public final static ModelOAuthDetails getNa30OAuthDetails(){
			String oAuthUrl ="<<Instance name for ex:https://na30.salesforce.com/>>";
			String clientId="<<Salesforce Connected App Client Id>>";
			String client_secret="<<Salesforce Connected App Client Secret>>";
			String userName = "<<Salesforce login userName>>";
			String password ="<<Salesforce login password>>";
				
			ModelOAuthDetails obj = new ModelOAuthDetails();
			obj.setBaseUrl(oAuthUrl);
			obj.setClientId(clientId);
			obj.setClientSecret(client_secret);
			obj.setUserName(userName);
			obj.setPassword(password);
			
			return obj;
	}
	
	protected final static String getAzureStorageAccountName(){
		return "<<Azure Storage Account Name>>";
	}
	
	protected final static String getAzureStorageAccountKey(){
		return "<<Azure Storage Account Key>>";
	}
	
	protected final static String getAzureContainerName(){
		return "<<Azure Storage Container Name>>";
	}
	
	protected final static String getMicrosoftCognitiveApi(){
		return "<<Microsoft Cognitive Api Key>>";
	}
}
