
public class ModelRecordDetails {
	private String RecordName;
	private String accessToken;
	
	String getRecordName() {
		return RecordName;
	}

	public void setRecordName(String recordName) {
		RecordName = recordName;
	}

	protected String getAccessToken() {
		return accessToken;
	}

	protected void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
}
