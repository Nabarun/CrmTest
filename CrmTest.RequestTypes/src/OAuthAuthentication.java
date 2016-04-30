import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/*
 * This class will help as an utility to login to the org and get the oauth token
 */
public class OAuthAuthentication implements OauthApiInterface{
	
	public String getAccessToken(ModelOAuthDetails authDetails){
		RestRequestData restApiSubject = new RestRequestData();
		MainHttpRequest postRequest = new PostHttpRequest(restApiSubject);
		postRequest.setMethodCall(Constants.IdentifierGetAccessToken);
		
		ArrayList<ArgumentPair> arguments = getArgumentPair(authDetails);
		
		restApiSubject.setRequest(arguments);
		return postRequest.getAccess_token();
	}
	
	protected ArrayList<ArgumentPair> getArgumentPair(ModelOAuthDetails detailObject){
		ArrayList<ArgumentPair> args = new ArrayList<ArgumentPair>();
		args.add(new Argument<String, String>("client_id", detailObject.getClientId()));
		args.add(new Argument<String, String>("client_secret", detailObject.getClientSecret()));
		args.add(new Argument<String, String>("username", detailObject.getUserName()));
		args.add(new Argument<String, String>("password", detailObject.getPassword()));
		return args;
	}
	
	
}
