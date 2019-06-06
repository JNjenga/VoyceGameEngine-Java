package render;

import org.lwjgl.opengl.*;

public class Renderer {
	
	public void clear() {
		//Util.LOG("EVENT", "RENDERER :: Clearing screen");
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		GL11.glClearColor(0, 1, 0, 1);
	}

}
