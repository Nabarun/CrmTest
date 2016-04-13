import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class AnalyzeImageCommand {
	public static Object execute(String fileId, String microsoftCoginitiveKey, String requestApi, String accessToken) {
			AnalysisImageInterface analyzeImage = new AnalysisImage();
			return analyzeImage.getImageAnalysis(fileId, microsoftCoginitiveKey, requestApi, accessToken);
		}
}
