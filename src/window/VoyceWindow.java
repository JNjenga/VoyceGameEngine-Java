package window;

import java.nio.*;

import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import utility.*;

public class VoyceWindow {
	
	boolean fulscreen = false;
	
	int width
			,height;
	
	String title;
	
	long windowHandle;
	
	public VoyceWindow(String title, int width, int height,boolean fullscreen) {
		
		this.title = title;
		this.width = width; 
		this.height = height;
		
		
		
 		this.fulscreen = fullscreen;
		
		
		createWindow();
 	

	}
	
	private void createWindow() {
 		BugTracker.LOG("EVENT", "WINDOW :: Attempting to create window");
 		
 		if (!GLFW.glfwInit()) {
			BugTracker.LOG("ERROR", "WINDOW :: Failed to initialize window");
			
			System.exit(0);
		}
 		
 		GLFW.glfwDefaultWindowHints();
 		
 		GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GLFW.GLFW_FALSE);
		GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MAJOR, 3);
		GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MINOR, 3);
		GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_PROFILE, GLFW.GLFW_OPENGL_CORE_PROFILE);
		
		if (fulscreen) {
			
			windowHandle = GLFW.glfwCreateWindow(width, height, title, GLFW.glfwGetPrimaryMonitor(), MemoryUtil.NULL);
		}else {
			windowHandle = GLFW.glfwCreateWindow(width, height, title, MemoryUtil.NULL, MemoryUtil.NULL);
			
		}
		
		if (windowHandle == MemoryUtil.NULL) {
			
			// TODO : Handle window errors
			
			BugTracker.LOG("ERROR", "WINDOW :: Unable to create window");
			
			System.exit(1);
			
		}
		 
			
			try(MemoryStack stack = MemoryStack.stackPush()){
				
				IntBuffer pWidth = stack.mallocInt(1);
				IntBuffer pHeight = stack.mallocInt(1);
				
				GLFW.glfwGetWindowSize(windowHandle, pWidth, pHeight);
				
				GLFWVidMode vidMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
				
				GLFW.glfwSetWindowPos(windowHandle, 
						(vidMode.width()	- pWidth.get(0)) / 2,
						(vidMode.height()	- pHeight.get(0)) / 2);
				
			}
			
			
		
		
		
		GLFW.glfwMakeContextCurrent(windowHandle);
		
		GLFW.glfwSwapInterval(1);
		
		GLFW.glfwShowWindow(windowHandle);
		
		BugTracker.LOG("SUCCESS", "WINDOW :: Window successfully created");
		
		GL.createCapabilities();
		
		GL11.glViewport(0, 0, width, height);
	}
	
	public void updateWindow() {
		GLFW.glfwSwapBuffers(windowHandle);

	}
	
	public void terminateWindow() {
 		GLFW.glfwSetWindowShouldClose(windowHandle, true);
	}
	
	public boolean shouldWindowClose() {
		return GLFW.glfwWindowShouldClose(windowHandle);
	}
	
}
