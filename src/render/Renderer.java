package render;

import org.joml.*;
import org.lwjgl.opengl.*;

import utility.*;

public class Renderer {
	
	
 	static Vector4f color = new Vector4f(1,0,1,1);
	private static Renderer INSTANCE;
	
 	public static synchronized Renderer getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new Renderer();
		}
		
		return INSTANCE;
	}
 	
	public   void clear() {
 		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
 		//GL11.glClear(GL11.GL_DEPTH_BUFFER_BIT);
 		//GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glClearColor(color.x, color.y, color.z, color.w);
	}

	public static void clear(float r, float g, float b, float a) {
		color.x = r;
		color.y = g;
		color.z = b;
		color.w = a;


	}

	// Turn on wireframe mode
	public static void enablePolygonMode() {
		GL11.glPolygonMode(GL11.GL_FRONT, GL11.GL_LINE);
		GL11.glPolygonMode(GL11.GL_BACK, GL11.GL_LINE);
		
	}
	
	public static void disablePolygonMode() {
 				GL11.glPolygonMode(GL11.GL_FRONT, GL11.GL_FILL);
				GL11.glPolygonMode(GL11.GL_BACK, GL11.GL_FILL);
	}
	
	
	 
}
