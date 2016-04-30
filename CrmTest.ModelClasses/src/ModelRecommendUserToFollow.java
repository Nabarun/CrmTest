import java.util.List;

public class ModelRecommendUserToFollow {
	private String userName;
	private String companyName;
	private String userId;
	private String title;
	private String reasonForRecommendation;
	private String photoUrl;
	private String accessToken;
	
    private List<String> twitterMessages;
    private List<String> linkedinMessages;
    private List<String> facebookMessages;
    
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<String> getTwitterMessages() {
		return twitterMessages;
	}

	public void setTwitterMessages(List<String> twitterMessages) {
		this.twitterMessages = twitterMessages;
	}

	public List<String> getLinkedinMessages() {
		return linkedinMessages;
	}

	public void setLinkedinMessages(List<String> linkedinMessages) {
		this.linkedinMessages = linkedinMessages;
	}

	public List<String> getFacebookMessages() {
		return facebookMessages;
	}

	public void setFacebookMessages(List<String> facebookMessages) {
		this.facebookMessages = facebookMessages;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReasonForRecommendation() {
		return reasonForRecommendation;
	}

	public void setReasonForRecommendation(String reasonForRecommendation) {
		this.reasonForRecommendation = reasonForRecommendation;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
	
}
