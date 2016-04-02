import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;

public class PostHttpRequest extends MainHttpRequest implements Observer{
	Observable requestSubject;
	private ArrayList<ArgumentPair> args;
	
	public PostHttpRequest(Observable requestSubject){
		this.requestSubject = requestSubject;
		requestSubject.addObserver(this);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		String accessToken; 
			if(this.getMethodCall().equals(Constants.IdentifierGetAccessToken)){
				ArrayList<ArgumentPair> args = (ArrayList<ArgumentPair>) arg;
						
				//Call the OAuthRequest to get the access Token
				MasterRequest request = new OAuthRequest();
				accessToken = (String) request.execute(args);
				this.setAccess_token(accessToken);
				
			}
			if(this.getMethodCall().equals(Constants.IdentifierCreateRecords)){
				ModelRecordDetails recordDetails = (ModelRecordDetails)arg;
				MasterRequest request = new CreateRecordRequest();
				String recordId = (String)request.execute(recordDetails);
				this.setResponse(recordId);
			}
			
			if(this.getMethodCall().equals(Constants.IdentifierInsertFileInNewsFeed)){
				ModelUploadFileRequestInNewsFeeds fileDetails = (ModelUploadFileRequestInNewsFeeds)arg;
				
				MasterRequest request = new UploadFileRequestInNewsFeeds();
				String fileId = (String) request.execute(fileDetails);
				this.setResponse(fileId);
			}
	}
}
