import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.json.JSONTokener;

abstract class MainHttpRequest {
	private String access_token;
	private String methodCall;
	private Object response;
	
	public String getRequestType(RequestType requestType){
		String type;
		
		switch(requestType) {
			case GET:
				type = "GET";
				break;
			case PUT:
				type ="PUT";
				break;
			case POST:
				type = "POST";
				break;
			default:
				type="";	
		}
		
		return type;
	}
	

	public String getAccess_token() {
		return access_token;
	}

	protected void setAccess_token(String access_token) {
		this.access_token = access_token;
	}


	public String getMethodCall() {
		return methodCall;
	}


	protected void setMethodCall(String methodCall) {
		this.methodCall = methodCall;
	}


	public Object getResponse() {
		return response;
	}


	protected void setResponse(Object response) {
		this.response = response;
	}
}
