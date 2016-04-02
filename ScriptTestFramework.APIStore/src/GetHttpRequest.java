import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class GetHttpRequest extends MainHttpRequest implements Observer{
	Observable requestSubject;
	private RequestType requestType;
	
	public GetHttpRequest(Observable requestSubject){
		this.requestSubject = (RestRequestData)requestSubject;
		requestSubject.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		if(this.getMethodCall().equals(Constants.IdentifierGetFileThumbnail) ){
			MasterRequest request = new ChatterFilePreviewRequest();
			ModelChatterFileDetails chatterObj = (ModelChatterFileDetails) arg;

			 setResponse(request.execute(chatterObj));
		}
	}
}
