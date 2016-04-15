
public class RecommendUser implements RecommendUserToFollow{
	String accessToken;
	public RecommendUser(String accessToken){
		this.accessToken = accessToken;
	}
	@Override
	public Object recommendMeToFollow() {
		// TODO Auto-generated method stub
		return getRecommendedUserToFollow();
	}

	public Object getRecommendedUserToFollow() {
		RestRequestData restApiSubject = new RestRequestData();
		
		MainHttpRequest getRequest = new GetHttpRequest(restApiSubject);
		getRequest.setMethodCall(Constants.IdentifierRecommendUserToFollow);
		 
		
		restApiSubject.setRequest(accessToken);
		return getRequest.getResponse();
	}
}
