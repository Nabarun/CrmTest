import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class ChatterFilePreviewRequest extends MasterRequest{
	
	public ChatterFilePreviewRequest(){
		this.methodCall = "Chatter File Preview Call";
	}
	
	@Override
	public Object execute(Object args) {
		ModelChatterFileDetails chatterDetails = (ModelChatterFileDetails)args;
		return getFormatAvailability(chatterDetails.getFileId(), chatterDetails.getFormatType(), chatterDetails.getAccessToken());
	}

	
	@SuppressWarnings("deprecation")
	protected Object getFormatAvailability(String fileId, String format, String accessToken) {
		
		// Create a Http Get request 
		try {
				String url = Constants.LoginUrl + String.format(Constants.FilePreviewEndpoint, fileId, format);
				HttpGet req = new HttpGet(url);
				req.setHeader("Authorization","Bearer "+accessToken );
				
				DefaultHttpClient client = new DefaultHttpClient();
				HttpResponse resp = client.execute(req);
				HttpEntity respObj = resp.getEntity();
				String responseString = EntityUtils.toString(respObj);
				
				final int statusCode = resp.getStatusLine().getStatusCode();
				
				if(statusCode == HttpStatus.SC_OK){
					return (responseString);
				}
				else{
					JSONArray jsonArr =  new JSONArray(responseString);
					return (jsonArr.getJSONObject(0).getString("errorCode"));
				}
				
		} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
			//Get the response code
		catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
			
		return null;
	}
}
