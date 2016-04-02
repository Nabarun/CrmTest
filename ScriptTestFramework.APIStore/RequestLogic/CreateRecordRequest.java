import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class CreateRecordRequest extends MasterRequest{

	
	public CreateRecordRequest(){
		this.methodCall = Constants.IdentifierCreateRecords;
	}
	
	@Override
	public Object execute(Object args) {
		ModelRecordDetails record = (ModelRecordDetails)args;
		
		Object recordId = createRecord(record.getRecordName(), record.getAccessToken());
		return recordId;
	}

	protected Object createRecord(String recordName, String accessToken) {
		
		StringBuilder urlParameters = new StringBuilder();
		HttpURLConnection con = null;
		String resp="";
		try {
			
			urlParameters.append(Constants.LoginUrl);
			urlParameters.append(Constants.CreateANewAccountRecord);
			
			
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost post = new HttpPost(urlParameters.toString());
			post.setHeader("Authorization","Bearer "+accessToken );
			post.setHeader("Content-Type", "application/json");
			
			post.setEntity(new StringEntity("{\"Name\":\""+ recordName+"\"}"));
			
			HttpResponse response = null;
			
			response = httpClient.execute(post);
			
			final int statusCode = response.getStatusLine().getStatusCode();
			
			if(statusCode == HttpStatus.SC_CREATED){
				resp = EntityUtils.toString(response.getEntity());
			}
			else{
				JSONArray jsonArr =  new JSONArray(response);
				return (jsonArr.getJSONObject(0).getString("errorCode"));
			}
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
