package chasis;

import org.lwjgl.glfw.*;

import nuklear.*;
import render.*;
import utility.*;
import window.*;

public class Engine extends Renderer{

	private Game game;
	
	public static boolean running = false;
	
	private Window window ;
	
	private Timmer timmer;
	
	
 	public Engine(String title, int width,int height,Game game) {
 		this.game = game;
 		
		window = ResourceManager.getInstance().getWindow();
		timmer = ResourceManager.getInstance().getTimmer();

		running = true;
		
		BugTracker.LOG("EVENT", "GAME :: Starting up game");
		
		
		ResourceManager.getInstance().getWindow().createWindow(title,width,height);
		
		 
	}
	public void start() {
		
		game.onStart();
		loop();
	}
	
	public void loop() {
		
		timmer.init();
		
		
 		while(window.isRunning() && running) {
 			
 			
 			//Update window
 			ResourceManager.getInstance().getWindow().updateWindow();
 			
 			//Render
 			clear();
 			game.render();
 			
 			//Update game
 			game.onUpdate();
		}
 		
 		terminate();
 		game.onClose();

	}
	
	public static  void terminate() {
 		GLFW.glfwSetWindowShouldClose(Window.window, true);
	}
	 
}
