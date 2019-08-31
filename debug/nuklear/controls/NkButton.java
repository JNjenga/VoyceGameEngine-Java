package nuklear.controls;

import static org.lwjgl.nuklear.Nuklear.*;

import org.lwjgl.nuklear.*;

public class NkButton {
	
	private String label ;
	
	NkButtonPress handler;
	
	public NkButton(String label,NkButtonPress handler) {
		
		this.label = label;
		
		this.handler = handler;
		
	}
	public void draw(NkContext ctx) {
		 nk_layout_row_static(ctx, 30, 80, 1);
         if (nk_button_label(ctx, label)) {
            handler.handle();
         }
	}
	
}


