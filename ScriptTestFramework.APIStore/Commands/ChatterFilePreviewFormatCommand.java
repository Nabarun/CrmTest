
public class ChatterFilePreviewFormatCommand {
	public static Object execute(String fileId, String formatType, String accessToken) {
		
		ChatterFileApiInterface chatterApi = new ChatterFile(accessToken);
		return chatterApi.getFileWithFormatAvailability(fileId, formatType);
	}
}
