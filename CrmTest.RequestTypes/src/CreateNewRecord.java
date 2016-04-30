
public class CreateNewRecord implements CreateNewRecordInterface{
	String accessToken;
	
	public CreateNewRecord(String accessToken){
		this.accessToken = accessToken;
	}
	
	@Override
	public String createNewAccountRecord(String recordName) {
		// Invoke Observer call
		RestRequestData restApiSubject = new RestRequestData();
		MainHttpRequest postRequest = new PostHttpRequest(restApiSubject);
		postRequest.setMethodCall(Constants.IdentifierCreateRecords);
		
		ModelRecordDetails details = new ModelRecordDetails();
		details.setRecordName(recordName);
		details.setAccessToken(accessToken);
		restApiSubject.setRequest(details);
		
		String recordId = (String)postRequest.getResponse();
		return recordId;
	}
	
}
