package chasis;

import org.lwjgl.glfw.*;

import render.*;
import utility.*;
import window.*;

public class BaseEngine {
	
	public static boolean running = false;
	
	private static VoyceWindow window;
	
	

	@SuppressWarnings("unused")
	private final VoyceGame game;
	
	

	public BaseEngine(VoyceGame game) {
		this.game = game;
	}
	
	public void start() {
		BugTracker.LOG("EVENT", "GAME :: Starting up engine");
		
		running = true;
		
//		Create Window
		setWindow(new VoyceWindow(game.getTitle(),game.getWidth(),game.getHeight(),game.isFullscreen()));
		
		
		game.onStart();
		
		run();
 	}

	private void run() {
		
		while (running && game.running) {
			window.updateWindow();
			GLFW.glfwPollEvents();
			
			if (window.shouldWindowClose()) {
				running = false;
				game.running = false;
			}
			
 			
			
			Renderer.getInstance().clear();
			
			game.render();
			
			game.onUpdate();
			
			
			
		}
		
		game.onClose();
		window.terminateWindow();
		
	}
	
	public static VoyceWindow getWindow() {
		return window;
	}

	public static void setWindow(VoyceWindow pWindow) {
		window = pWindow;
	}
	
}
