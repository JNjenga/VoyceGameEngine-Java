package events;

import org.lwjgl.glfw.*;

import window.*;

public class EventManager {
	
	KeyEvent keyEvents;
	
	MouseEvent mouseEvents;
	
	WindowEvent windowEvents;
	
	public EventManager() {
		
		keyEvents = new KeyEvent();
		mouseEvents = new MouseEvent();
		windowEvents= new WindowEvent();
		
		
 	}
	
	public void pollEvents() {
		keyEvents.pressedEvents.forEach((key,handler)->{
			if (GLFW.glfwGetKey(Window.window	, key) == GLFW.GLFW_PRESS) {
			handler.handle(key, 0, GLFW.GLFW_PRESS, 0);
		}});
	}
	
	public void startListeners() {
		keyEvents.start();
		mouseEvents.startListener();
		
	}
	
	
	 

	public KeyEvent getKeyEvents() {
		return keyEvents;
	}




	public void setKeyEvents(KeyEvent keyEvents) {
		this.keyEvents = keyEvents;
	}




	public MouseEvent getMouseEvents() {
		return mouseEvents;
	}




	public void setMouseEvents(MouseEvent mouseEvents) {
		this.mouseEvents = mouseEvents;
	}




	public WindowEvent getWindowEvents() {
		return windowEvents;
	}




	public void setWindowEvents(WindowEvent windowEvents) {
		this.windowEvents = windowEvents;
	}
}
