
public class AnalysisImage implements AnalysisImageInterface{

	@Override
	public Object getImageAnalysis(String fileId, String cognitiveKey, String requestApi, String accessToken) {
		ModelAnalysisImage imageObject = new ModelAnalysisImage();
		imageObject.setSfFileId(fileId);
		imageObject.setCongnitiveKey(cognitiveKey);
		imageObject.setApiChoice(requestApi);
		imageObject.setAccessToken(accessToken);
		
		RestRequestData restApiSubject = new RestRequestData();
		
		MainHttpRequest postRequest = new PostHttpRequest(restApiSubject);
		postRequest.setMethodCall(Constants.IdentifierAnalysisImage);
		 
		restApiSubject.setRequest(imageObject);
		return (String)postRequest.getResponse();
	}

}
