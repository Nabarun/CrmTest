import org.junit.Assert;
import org.junit.Test;

public class AzureStorageTest extends MasterTestObject{
	@Test
	public void testForAzureBob() {
		String azureStorageAccountName = "crmteststore";
		String azureStorageAccountKey = "vM7qTwBkmJ1S4nbTx/Vja0c1FrjGnKQY1GfU+h7N0J/rIbJrm/IlVQ4B7zyalUwJbWy9/T/Sx+n0/i6VzHU6KA==";
		String azureContainer = "crmtestcontainer";
		String azureBlob = "pdf.pdf";
		String fileDescription="This is a Simple pdf";
		String accessToken = this.getAccessToken();
	
		String response = (String)AzureStorageCommand.getBlob(azureStorageAccountName, azureStorageAccountKey, azureContainer, azureBlob, fileDescription, accessToken);
		Assert.assertTrue(response != null);
	}
}
