
public class RecordCommand {
	public static Object execute(String recordName, String accessToken) {
		
		CreateNewRecordInterface recordObj = new CreateNewRecord(accessToken);
		return recordObj.createNewAccountRecord(recordName);
	}
}
