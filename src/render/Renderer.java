package render;

import org.lwjgl.opengl.*;

public class Renderer {
	
	public void clear() {
 		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		GL11.glClearColor(0, 1, 0, 1);
	}

	public static void clear(float r, float g, float b, float a) {
		GL11.glClearColor(r, g, b, a);

	}

	public static void enablePolygonMode() {
		// Turn on wireframe mode
		GL11.glPolygonMode(GL11.GL_FRONT, GL11.GL_LINE);
		GL11.glPolygonMode(GL11.GL_BACK, GL11.GL_LINE);
		
	}
	
	public static void disablePolygonMode() {
 				GL11.glPolygonMode(GL11.GL_FRONT, GL11.GL_FILL);
				GL11.glPolygonMode(GL11.GL_BACK, GL11.GL_FILL);
	}

}
