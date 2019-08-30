package events;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.nuklear.Nuklear.*;

import java.util.*;

import org.lwjgl.glfw.*;

import events.eventTypes.*;
import window.*;

public class KeyEvent extends Event{
	
	HashMap<Integer , KeyPressedHandler> pressedEvents;
	
	public KeyEvent() {
		super();
		pressedEvents = new HashMap<>();
 	}
	
	public void init() {
		glfwSetKeyCallback(windowHandle, (window, key, scancode, action, mods) -> {
            if (pressedEvents.containsKey(key)) {
				pressedEvents.get(key).handle();
			}
        });
	}

	public void onKeyPressed(int keyC,KeyPressedHandler e){
		
		pressedEvents.put(keyC, e);
		
	}
	public void processEvents() {
//		pressedEvents.forEach((key,handler)->{
//			if (GLFW.glfwGetKey(windowHandle, key) == GLFW.GLFW_PRESS) {
//				handler.handle();
//			}
//		});
		
	
	}
	
	

}
