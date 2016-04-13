import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * Get the preview from the file which 
 */
public class ChatterFile implements ChatterFileApiInterface{
	private String accessToken;
	
	public ChatterFile(String accessToken){
		this.accessToken = accessToken;
	}

	@Override
	public String getFileWithFormatAvailability(String fileId, String formatType) {
		RestRequestData restApiSubject = new RestRequestData();
		
		MainHttpRequest getRequest = new GetHttpRequest(restApiSubject);
		getRequest.setMethodCall(Constants.IdentifierGetFileThumbnail);
		 
		ModelChatterFileDetails chatterField = new ModelChatterFileDetails();
		chatterField.setFileId(fileId);
		chatterField.setFormatType(formatType);
		chatterField.setAccessToken(accessToken);
		
		restApiSubject.setRequest(chatterField);
		return (String)getRequest.getResponse();
	}

	@Override
	public String insertFileInNewsFeed(ModelUploadFileRequestInNewsFeeds fileDetails) {
		// TODO Auto-generated method stub
		RestRequestData restApiSubject = new RestRequestData();
		MainHttpRequest postRequest = new PostHttpRequest(restApiSubject);
		postRequest.setMethodCall(Constants.IdentifierInsertFileInNewsFeed);
		
		fileDetails.setAccessToken(accessToken);
		restApiSubject.setRequest(fileDetails);
		
		return (String)postRequest.getResponse();
	}
}
