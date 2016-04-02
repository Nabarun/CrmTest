import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.nio.charset.Charset;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.json.JSONTokener;

/*
 * Upload Files In News Feeds
 */
public class UploadFileRequestInNewsFeeds extends MasterRequest{
	
	public UploadFileRequestInNewsFeeds(){
		this.methodCall = "Upload File In News Feed Call";
	}
	
	@Override
	public Object execute(Object args) {
			ModelUploadFileRequestInNewsFeeds arguments = (ModelUploadFileRequestInNewsFeeds)args;
			return insertNewDocument(arguments);
	}
	
	protected String insertNewDocument(ModelUploadFileRequestInNewsFeeds fileRequest) {

		try {
				File file = new File(fileRequest.getFileLocation());
				FileBody fileBody = new FileBody(file);
				
				String filesUploadEndpointUrl = Constants.LoginUrl + Constants.InsertNewDocument;
				String boundary = "-----------------" + System.currentTimeMillis();
				
				DefaultHttpClient httpClient = new DefaultHttpClient();
	            HttpPost httpPost = new HttpPost(Constants.LoginUrl+Constants.InsertNewDocument);
	            MultipartEntity reqEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);

	            
	            reqEntity.addPart("feedItemFileUpload", fileBody);
	            reqEntity.addPart("fileName", new StringBody(fileRequest.getFileName(), "text/plain", Charset.defaultCharset()));
	            reqEntity.addPart("text", new StringBody(fileRequest.getFeedText(), "text/plain", Charset.defaultCharset()));
	            reqEntity.addPart("feedItemFileUpload", new FileBody(file, fileRequest.getFileName(), "application/octet-stream", Charset.defaultCharset().toString()));
	            
	            httpPost.setEntity(reqEntity);
	            httpPost.setHeader("Authorization", "OAuth " + fileRequest.getAccessToken());
	
				
				String response = EntityUtils.toString(httpClient.execute(httpPost).getEntity(),"UTF-8");
				return response;
			
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
