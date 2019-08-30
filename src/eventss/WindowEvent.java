package events;

import org.lwjgl.glfw.*;

import events.handlers.*;

public class WindowEvent extends Event {
		
	public WindowEvent() {
		super();

 	}
	
	public void onClose(WindowCloseHandler e) {
		GLFW.glfwSetWindowCloseCallback(windowHandle, (widnow) ->{
			e.handle(widnow);
			e.handle();
		});
	}
	
	public void onResize(WindowResizeHandler e){
		GLFW.glfwSetFramebufferSizeCallback(windowHandle, (window,width,height)->{
			e.handle(window, width, height);
			e.handle(width,height);
		});
	}
	
}


