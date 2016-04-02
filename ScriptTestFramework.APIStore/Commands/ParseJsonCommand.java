import org.json.JSONObject;
import org.json.JSONTokener;

public class ParseJsonCommand{

	public static Object execute(String jsonResponse, String filterString) {

		return getParsedResponse(jsonResponse, filterString);
	}
	
	public static String getParsedResponse(String jsonResponse, String filterString){
		try{
			JSONObject jsonObject = (JSONObject) new JSONTokener(jsonResponse).nextValue();
			
			if(!jsonObject.has("error")){
				if(jsonObject.has("attachment") && filterString.equals("id")){
					//When a file is uploaded, the id to interact with chatter feed can be retrieved inside the attachment object
					return jsonObject.getJSONObject("attachment").getString(filterString).substring(0, 15);
				}
				return jsonObject.getString(filterString);
			}
			else{
				return jsonObject.getString("error");
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
}