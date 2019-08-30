package events;


import org.lwjgl.glfw.*;

public class EventManager {
	
	KeyEvent keyEventHandler;
	
	public EventManager() {
		keyEventHandler = new KeyEvent();
 	}
	
	public void init() {
		keyEventHandler.init();
	}
	
	public void processEvents() {
		keyEventHandler.processEvents();
	}
	

	 
	
	
	public KeyEvent getKeyEventHandler() {
		return keyEventHandler;
	}
	public void pollEvents() {
		GLFW.glfwPollEvents();
	}
}
