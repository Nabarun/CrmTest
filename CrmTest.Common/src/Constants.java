
public class Constants {
	public static String LoginUrl="";
	public static String OAuthUrlEndpoint="services/oauth2/token?grant_type=password";
	public static String FilePreviewEndpoint = "services/data/v36.0/connect/files/%s/previews/%s";
	public static String CreateANewAccountRecord = "services/data/v36.0/sobjects/Account/";
	public static String InsertNewDocument = "services/data/v25.0/chatter/feeds/news/me/feed-items";
	public static String RenditionEndpoint = "services/data/v29.0/chatter/files/%s/rendition?type=THUMB120BY90";
	
	public static String FeedItemFileUpload ="feedItemFileUpload";
	public static String FeedItemFileName = "fileName";
	public static String FeedItemText = "text";
	
	public static String IdentifierGetAccessToken ="GetAccessToken";
	public static String IdentifierGetFileThumbnail = "GetFileThumbnail";
	public static String IdentifierCreateRecords = "CreateRecord";
	public static String IdentifierInsertFileInNewsFeed = "InsertFileInNewsFeed";
	public static String IdentifierAnalysisImage = "ImageAnalysis";
	public static String IdentifierAzureStorageGetBlob = "GetAzureStorageBlob";
	
	public static String MicrosoftCognitiveAnalysisApiUrl = "https://api.projectoxford.ai/vision/v1.0/analyze?visualFeatures=Description,Tags";
	public static String IMageAnalysisResponseMainNode ="categories";
			
	public static String MicrosoftCognitiveTopicsApiUrl = "https://api.projectoxford.ai/vision/v1.0/describe?maxCandidates=1";
	public static String ImageDescriptionMainNode = "description";
	public static String ImageTopicNode="tags";
	
	public static String AzureStorageConnectionString = "DefaultEndpointsProtocol=http;"
	        + "AccountName=%s;"
	        + "AccountKey=%s";
}
