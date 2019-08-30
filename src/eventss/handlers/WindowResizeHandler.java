package events.handlers;

import org.lwjgl.opengl.*;

public interface WindowResizeHandler {
	void handle(long window, int width, int height);
	default void handle( int width, int height) {
			GL11.glViewport(0, 0, width, height);				

	}
	
 }
