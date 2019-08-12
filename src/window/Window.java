package window;

import java.nio.*;

import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import utility.*;


public class Window {
	//The window handle
	public static long window;
	
	//Size specifire of the window
	private int WIDTH,HEIGHT;
	
 
	//Tile of the window
	private String TITLE;

	
	private boolean running = false;
	 	
	public void createWindow(String title , int width,int height) {
		WIDTH = width;
		HEIGHT = height;
		TITLE = title;
		
		BugTracker.LOG("EVENT", "Creating window");

		if(!GLFW.glfwInit()) {
			BugTracker.LOG("ERROR", "WINDOW :: Failed to intitialize GLFW");
		}
		
		GLFW.glfwDefaultWindowHints();
		GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GLFW.GLFW_FALSE);
		GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MAJOR, 3);
		GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MINOR, 3);
		GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_PROFILE, GLFW.GLFW_OPENGL_CORE_PROFILE);

		window = GLFW.glfwCreateWindow(WIDTH, HEIGHT, TITLE, MemoryUtil.NULL, MemoryUtil.NULL);
		
		if (window == MemoryUtil.NULL) {
			BugTracker.LOG("ERROR", "WINDOW :: Unable to create window");

		}
		
		
		try (MemoryStack stack = MemoryStack.stackPush()){
			
			IntBuffer pWidth = stack.mallocInt(1);			
			IntBuffer pHeight = stack.mallocInt(1);
			
			GLFW.glfwGetWindowSize(window, pWidth, pHeight);
			
			GLFWVidMode vidMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
			
			GLFW.glfwSetWindowPos(
					window,
					(vidMode.width()	- pWidth.get(0)) / 2,
					(vidMode.height()	- pHeight.get(0)) / 2);
			
		}
		running = true;
		startWindow();
		
	}

	private void startWindow() {
		 
		
		GLFW.glfwMakeContextCurrent(window);
		
		GLFW.glfwSwapInterval(1);
		
		GLFW.glfwShowWindow(window);
		
		BugTracker.LOG("SUCCESS", "WINDOW :: Window created successfully");
		
		GL.createCapabilities();
		
		GL11.glViewport(0, 0, WIDTH, HEIGHT);
		
	}
	public void updateWindow() {
		
		GLFW.glfwSwapBuffers(window);
		GLFW.glfwPollEvents();
		
		if(GLFW.glfwWindowShouldClose(window)) {
			running = false;
			
			BugTracker.LOG("EVENT", "WINDOW :: Closing window...");
			 
			GLFW.glfwTerminate();
			
		}
		
		
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public long getWindow() {
 		return window;
	}
}
