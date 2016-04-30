import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class AnalyzeImageRequest extends MasterRequest{

	@Override
	public Object execute(Object args) {
		ModelAnalysisImage analysis = (ModelAnalysisImage) args;
		InputStream rawImageBinary = RawImageBinary(analysis.getSfFileId(), analysis.getAccessToken());
		return AnalyzeImage(rawImageBinary, analysis.getCongnitiveKey(), analysis.getApiChoice());
	}

	/*
	 * Renditions will generate preview thumbnail.
	 * Send the preview thumbnail for analysis in Microsoft cognitive api
	 */
	protected InputStream RawImageBinary(String fileId, String accessToken){
		try {
				String renditionUrl = Constants.LoginUrl +String.format(Constants.RenditionEndpoint, fileId);
				
				DefaultHttpClient httpClient = new DefaultHttpClient();
				HttpGet get = new HttpGet(renditionUrl);
				get.setHeader("Content-Type", "application/json");
				get.setHeader("Authorization","Bearer "+accessToken );

				HttpResponse response = null;
				response = httpClient.execute(get);
				return response.getEntity().getContent();
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	}
	
	/*
	 * Analyze the image by invoking the cognitive api calls
	 */
	protected Object AnalyzeImage(InputStream imageBinary, String cognitiveKey, String apiSelection){
		String imageAnalysisUrl = "";
 
		try {
			
			if(apiSelection.equalsIgnoreCase("topics")){
				imageAnalysisUrl = Constants.MicrosoftCognitiveTopicsApiUrl;
			}
			else{
				imageAnalysisUrl = Constants.MicrosoftCognitiveAnalysisApiUrl;
			}
			
			InputStreamEntity entity = new InputStreamEntity(imageBinary);
			
			
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost post = new HttpPost(imageAnalysisUrl);
			
			post.setHeader("Content-Type", "application/octet-stream");
			post.setHeader("Ocp-Apim-Subscription-Key", cognitiveKey);
			
			post.setEntity(entity);			
			HttpResponse response = null;
			
			response = httpClient.execute(post);

			String resp = EntityUtils.toString(response.getEntity());
			return resp;
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
