import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class CreateAccountRecordTest extends MasterTestObject{

	@Test
	public void testSimpleAccountRecordCreation() {
		String recordName="Abc Industries";
		String accessToken = this.getAccessToken();
		
		CreateNewRecordInterface recordObj = new CreateNewRecord(accessToken);
		String recordId = recordObj.createNewAccountRecord(recordName);
		Assert.assertTrue(recordId.length()!=0);	
	}

	
}
