package utility;

public class BugTracker {
	
	public static void LOG(String eventType,String log) {
		if (eventType == "ERROR") {
			System.err.println(eventType+" :: "+log);
			//System.exit(1);
			return;
		}
		System.out.println(eventType+" :: "+log);
	}
	
	public static void MEMORYUSAGE() {
		BugTracker.LOG("DEBUG", " Used memory ::"+ GETMEMEMORYUSAGE()+ "Mb" );

	}
	
	public static long GETMEMEMORYUSAGE() {
		return (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())/1_000_000;
 	}
}
