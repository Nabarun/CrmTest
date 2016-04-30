import org.junit.Assert;
import org.junit.Test;

public class AzureStorageTest extends MasterTestObject{
	@Test
	public void testForAzureBob() {
		String azureStorageAccountName = TestUtility.getAzureStorageAccountName();
		String azureStorageAccountKey = TestUtility.getAzureStorageAccountKey();
		String azureContainer = TestUtility.getAzureContainerName();
		String azureBlob = "<<filename with extension>>";
		String fileDescription="This is a Simple pdf";
		String accessToken = this.getAccessToken();
	
		String response = (String)AzureStorageCommand.getBlob(azureStorageAccountName, azureStorageAccountKey, azureContainer, azureBlob, fileDescription, accessToken);
		Assert.assertTrue(response != null);
	}
}
