import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class RestRequestData extends Observable{
	private ResponseType responseType;
	
	public RestRequestData(){}

	public void notifyHttpMethods(Object args) {
		setChanged();
		if(args == null)
			notifyObservers();
		else
			notifyObservers(args);
	}
	
	/*
	 * Set the Subject Request. Notify the different observers whenever a new request comes
	 */
	public void setRequest(Object args){		
		if(args != null){
			notifyHttpMethods(args);
		}
		else{
			notifyHttpMethods(null);
		}
		
	}
	
	public ResponseType getResponseType(){
		return responseType;
	}
}
