import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/*
 * 
 */
public class OAuthRequest extends MasterRequest{
	
	public OAuthRequest(){
		this.methodCall = "OAuth Call";
	}
	
	@Override
	public Object execute(Object args) {
			ArrayList<ArgumentPair> argList = (ArrayList<ArgumentPair>)args;
			Object accessToken = getAccessToken(argList);
			return accessToken;
	}
	
	protected Object getAccessToken(ArrayList<ArgumentPair> args) {
		
		StringBuilder urlParameters = new StringBuilder();
		String accessToken="";
	
		HttpURLConnection con = null;
		
		try {
			
			urlParameters.append(Constants.LoginUrl);
			urlParameters.append(Constants.OAuthUrlEndpoint);
			
			for(ArgumentPair arg: args){
				urlParameters.append("&"+arg.getKey()+"="+arg.getValue());
			}
			
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost post = new HttpPost(urlParameters.toString());
			HttpResponse response = null;
			
			response = httpClient.execute(post);
			
			final int statusCode = response.getStatusLine().getStatusCode();
			String resp = EntityUtils.toString(response.getEntity());
			return resp;
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(con != null){
				con.disconnect();
			}
			
		}
		return null;
		
	}
}
