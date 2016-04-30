/*
 * This implies the master class for decorator object.
 */
public abstract class MasterRequest {
	String methodCall = "Unknown Method Call";
	String accessToken ="";
	
	//Master logic for execute
	public abstract Object execute(Object args);
	
	public String getMethodCall() {
		return methodCall;
	}
}
