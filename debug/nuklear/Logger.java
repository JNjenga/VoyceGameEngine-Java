package nuklear;

import java.util.*;

import org.lwjgl.nuklear.*;
import org.lwjgl.opengl.*;

import nuklear.controls.*;
import utility.*;
import window.*;

public class Logger extends Widget {

	
//	Text color
//	NkColor white = NkColor.create().r((byte)0xFF).g((byte)0xFF).b((byte)0xFF).a((byte)0xFF);
//	ctx.style().text().color().set(white);
//	
	
	NkTextProperty textItem;
	private NkSlider slider;
	private NkButton button;
	
	public Logger() {
		super("Voyce Debugger", Window.getWIDTH() * 3/4, 0, 350, 350);
		textItem = new NkTextProperty();
		 slider = new NkSlider("TRY", 0,10, 0.1f);
		 
		 button = new NkButton("Clean", ()->{System.gc();});
	}

	@Override
	protected void layout(NkContext ctx) {
		
		Nuklear.nk_layout_row_dynamic(ctx, 100, 1);
		if(Nuklear.nk_group_begin(ctx, "My Group", Nuklear.NK_WINDOW_BORDER )) {

			textItem.draw(ctx, "Os", System.getProperty("os.name"));
			
			textItem.draw(ctx, "Version", String.valueOf(Runtime.version()));
			
			textItem.draw(ctx, "Opengl version",  GL11.glGetString(GL11.GL_VERSION));
			
			textItem.draw(ctx, "Available processors", String.valueOf(Runtime.getRuntime().availableProcessors()));
			
			textItem.draw(ctx, "MemoryUsage", Long.toString(BugTracker.GETMEMEMORYUSAGE())+" mb");
			
			button.draw(ctx);
			  
			  Nuklear.nk_group_end(ctx);
			}
	}

	@Override
	protected void updateProperties() {
		
	}
	
}
