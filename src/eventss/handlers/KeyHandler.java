package events.handlers;

import org.lwjgl.glfw.*;

import chasis.*;

public interface KeyHandler  {
	void handle(long win, int key, int scancode , int  action, int mods);
	
	default void handle(int key, int scancode , int  action, int mods) {
		if(action == GLFW.GLFW_PRESS && key == GLFW.GLFW_KEY_ESCAPE)
			Engine.terminate();
	};
}
