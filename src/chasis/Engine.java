package chasis;

import org.lwjgl.glfw.*;

import events.*;
import render.*;
import utility.*;
import window.*;

public class Engine extends Renderer{

	private Game game;
	
	public static boolean running = false;
	
	private Window window ;
	
	private Timmer timmer;
	
	 static EventManager eventManager;
	
 	public Engine(String title, int width,int height,Game game) {
 		this.game = game;
 		
		window = ResourceManager.getInstance().getWindow();
		timmer = ResourceManager.getInstance().getTimmer();

		running = true;
		
		BugTracker.LOG("EVENT", "GAME :: Starting up game");
		
		
		ResourceManager.getInstance().getWindow().createWindow(title,width,height);
		
		eventManager = new EventManager();
		 

	}
	public void start() {
		
		game.onStart();
		loop();
	}
	
	public void loop() {
		
		timmer.init();
		
		eventManager.init();
		
 		while(window.isRunning() && running) {
 			
 			//Update window
 			ResourceManager.getInstance().getWindow().updateWindow();
 			
 			
 			//Render
 			clear();
 			game.render();
 			
 			//Update game
 			game.onUpdate();
 
 			 eventManager.pollEvents();
 			eventManager.processEvents();
		}
 		
 		terminate();
 		game.onClose();

	}
	
	public static  void terminate() {
 		GLFW.glfwSetWindowShouldClose(Window.window, true);
	}
	
	public static EventManager getEventManager() {
		return eventManager;
	}
	
	 
}
