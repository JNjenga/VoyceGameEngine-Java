package events;

import java.util.*;

import org.lwjgl.glfw.*;

import events.handlers.*;
import window.*;

public class KeyEvent extends Event{
	
	HashMap<Integer,KeyHandler> pressedEvents;
	HashMap<Integer,KeyHandler> releasedEvents;
	
	public KeyEvent() {
		super();

		pressedEvents = new HashMap<Integer, KeyHandler>();
		releasedEvents = new HashMap<Integer, KeyHandler>();
 	}
	
	public void onKeyPressed(int keyC,KeyHandler e){
		pressedEvents.put(keyC, e);
		
	}
	
	public void onKeyRelease(int keyC,KeyHandler e){
		releasedEvents.put(keyC, e);
 		 
	}
	
	public void start() {
		GLFW.glfwSetKeyCallback(Window.window, (win, key, scancode, action, mods) ->{
			
			if(action == GLFW.GLFW_PRESS)
				handlePressedKeyEvents(key, scancode, action, mods);
			else if(action == GLFW.GLFW_RELEASE)
				handleReleasedKeyEvents(key, scancode, action, mods);
			
		}); 
	}
	private void  handlePressedKeyEvents(int key, int scancode , int  action, int mods) {
		if(pressedEvents.containsKey(key))
			pressedEvents.get(key).handle(Window.window, key, scancode, action, mods);;
	}
	
	private void  handleReleasedKeyEvents(int key, int scancode , int  action, int mods) {
		if(releasedEvents.containsKey(key))
			releasedEvents.get(key).handle(Window.window, key, scancode, action, mods);
	}
}
