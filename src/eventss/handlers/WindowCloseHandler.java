package events.handlers;

public interface WindowCloseHandler {
 		void handle(long window);
 		
 		default void handle() {
 			System.out.println("Close event occured");
 		}
}
