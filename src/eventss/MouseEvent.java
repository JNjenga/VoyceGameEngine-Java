package events;

import java.nio.*;
import java.util.*;

import org.lwjgl.glfw.*;

import events.handlers.*;
import window.*;

public class MouseEvent extends Event{
	
	HashMap<Integer, MouseButtonHandler> buttonPressEvents;
	HashMap<Integer, MouseButtonHandler> buttonReleaseEvents;
	HashMap<Integer, MouseDragHandler> dragEvents;
	List< MouseScrollHandler> scrollEvents;
	List <MouseMoveHandler> mouseMoveEvents;
	
	double xpos,ypos;
	double [] dx,dy;
	boolean firstMouse = true;

	
	public MouseEvent() {
		super();

		
		buttonPressEvents = new HashMap<Integer, MouseButtonHandler>();
		buttonReleaseEvents = new HashMap<Integer, MouseButtonHandler>();
		dragEvents = new HashMap<Integer, MouseDragHandler>();
		scrollEvents = new ArrayList<MouseScrollHandler>();
		mouseMoveEvents = new ArrayList< MouseMoveHandler>();
		
		xpos = 0;
		ypos = 0;
		dx = new double[1];
		dy = new double[1];
 	}
	
	public void onMouseButtonPressEvent(int button, MouseButtonHandler e) {
		buttonPressEvents.put(button, e);
	}
	public void onMouseButtonReleaseEvent(int button, MouseButtonHandler e) {
		buttonReleaseEvents.put(button, e);
	}
	
	public void onMouseDragEvent(int button,MouseDragHandler e) {
		dragEvents.put(button, e);
	}
	
	public void onMouseScollEvent(MouseScrollHandler e) {
		scrollEvents.add( e);
	}
	
	public void onMouseMoved(MouseMoveHandler e) {
		mouseMoveEvents.add(e);
	}
	
	public void startListener() {
		GLFW.glfwSetMouseButtonCallback(Window.window, (win,button,action,mods) ->{
			if (action == GLFW.GLFW_PRESS) {
				handleMouseButtonPressEvent(button);
				
				
			}else if (action == GLFW.GLFW_RELEASE) {
				handleMouseButtonReleaseEvent(button);
				handleDragEvent(button);
			} 

			 
			
		});
		GLFW.glfwSetCursorPosCallback(Window.window, (window,xpos,ypos)->{
			
 			
			if (firstMouse) {
				
				 this.xpos = xpos;
				 this.ypos = ypos;
				 firstMouse = false;
			}
			
			handleMouseMoveEvent(xpos, ypos, xpos - this.xpos, this.ypos - ypos);
			this.xpos = xpos;
			this.ypos = ypos;
		});
		
		GLFW.glfwSetScrollCallback(Window.window,(window,xoffset,yoffset)->{
			handleScrollEvent(xoffset, yoffset);
		});
		
	}
	
 
 
	private void handleMouseMoveEvent(double xpos,double ypos,double xoffset,double yoffset) {
		 mouseMoveEvents.forEach((e)->{e.handle(xpos, ypos, xoffset, yoffset);});
	}
	 

	private void handleDragEvent(int button) {
		if (dragEvents.containsKey(button)) {
			dragEvents.get(button).handle(button,xpos,ypos,dx[0],dy[0]);
		}
	}
	
	public void handleScrollEvent(double xoffset,double yoffset) {
		 scrollEvents.forEach((e)->{e.handle(xoffset, yoffset);});

	}

	private void handleMouseButtonPressEvent(int button) {
		if (buttonPressEvents.containsKey(button)) {
			buttonPressEvents.get(button).handle();
		}
	}
	
	private void handleMouseButtonReleaseEvent(int button) {
		 
		if (buttonReleaseEvents.containsKey(button)) {
			buttonReleaseEvents.get(button).handle();
		}
	}
}
