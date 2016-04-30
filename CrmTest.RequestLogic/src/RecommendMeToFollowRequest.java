import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class RecommendMeToFollowRequest extends MasterRequest{

	@Override
	public Object execute(Object args) {
		this.accessToken = (String)args;
		
		// Get the recommended user from Salesforce
		// Create a recommender object and assign each one to them
		Object response = getRecommendationFromSalesforceAPI();
		return response;
		
		
		//Do an async Twitter Search for the same user
		//Assign it to the recommender object
		
		//Do an async Linkedin Search for the user
		//Assign it to the recommender object
		
		//Do an async Facebook Search for the user
		//Assign it to the recommender object
		
		//Do an IBM watson analysis on all the messages and give behavioral analysis
		//Assign it to recommender object
		

	}
	
	private Object getRecommendationFromSalesforceAPI(){
		try {
			String renditionUrl = Constants.LoginUrl +String.format(Constants.RecommendMeToFollowEndpoint);
			
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet get = new HttpGet(renditionUrl);
			get.setHeader("Content-Type", "application/json");
			get.setHeader("Authorization","Bearer "+accessToken );
	
			HttpResponse response = null;
			response = httpClient.execute(get);
			return EntityUtils.toString(response.getEntity());
		
		}catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	 	} catch (IOException e) {
	 		// TODO Auto-generated catch block
	 		e.printStackTrace();
	 	}
		return null;
	}
	
	
	private ArrayList<String> getTweetsForTheRecommendedUser(String userName, String twitterApiKey){
		
		return null;
	}
	
	private Object getLinkedinPostForRecommendedUser(){
		return null;
	}
	
	private Object getFacebookPostForRecommendedUser(){
		return null;
	}
}
