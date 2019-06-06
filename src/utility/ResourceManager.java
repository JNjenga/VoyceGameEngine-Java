package utility;

import java.util.*;

import model.*;
import shader.*;
import texture.*;
import window.*;

public class ResourceManager {
	
	private static ResourceManager INSTANCE;
	
	private Window window;
	
	private Timmer timmer;
	
	HashMap<String, Shader> shaders;
	
	final String shaderPath = "/res/shaders/";

	private HashMap<String , Model> models;
	public ResourceManager() {
		window = new Window();
		timmer = new Timmer();
		shaders = new HashMap<>();
		models = new HashMap<>();
 	}
	
	public static synchronized ResourceManager getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new ResourceManager();
		}
		
		return INSTANCE;
	}
	
	
	public Window getWindow() {
		if (window == null) {
			window = new Window();
		}
		return window;
	}
	
	public Timmer getTimmer() {	 
		return timmer;
	}
	
	public Shader getShader(String shaderName) {
		
		if (shaders.get(shaderName) == null) {
			shaders.put(shaderName,new Shader(shaderPath+shaderName));
			
		}
		return shaders.get(shaderName);
	}
	
	public Texture getTexture() {
		
		return null;
	}
}
