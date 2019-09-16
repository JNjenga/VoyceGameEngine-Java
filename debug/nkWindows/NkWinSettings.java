package nkWindows;

import java.awt.*;

import org.lwjgl.nuklear.*;

import nuklear.*;

public class NkWinSettings extends Widget{

	
	
	public NkWinSettings( int x, int y, float width, float height) {
		super("Settings", Window.WIDTH - (int)width, y, width, height);
 	}

	@Override
	protected void layout(NkContext ctx) {
 		
	}

	@Override
	protected void updateProperties() {
 		
	}

}
