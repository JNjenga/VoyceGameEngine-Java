package nuklear;

import org.lwjgl.*;
import org.lwjgl.nuklear.*;
import org.lwjgl.opengl.*;

import utility.*;
import window.*;

public class ModelWidget extends Widget {

	
	//Text color
	NkColor white = NkColor.create().r((byte)0xFF).g((byte)0xFF).b((byte)0xFF).a((byte)0xFF);

	public ModelWidget() {
		super("Model Debugger", 0, 0, 350, 350);
	}

	@Override
	protected void layout(NkContext ctx) {
  		Nuklear.nk_layout_row_dynamic(ctx, 30, 2);
  		
 		
	
	}

	@Override
	protected void updateProperties() {
		
	}
	
}
