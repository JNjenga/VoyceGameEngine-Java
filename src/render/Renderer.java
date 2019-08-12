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

}
