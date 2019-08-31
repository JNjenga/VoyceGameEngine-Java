package nuklear.controls;

import org.lwjgl.nuklear.*;

public class NkTextProperty {
  
	public NkTextProperty( ) {
	 
 	}
 
	public void draw(NkContext ctx,String name,String value) {
		Nuklear.nk_layout_row_dynamic(ctx, 30, 2);
 
		Nuklear.nk_label(ctx,name+ " : " ,Nuklear.NK_TEXT_ALIGN_LEFT);
		Nuklear.nk_label(ctx, value,Nuklear.NK_TEXT_ALIGN_RIGHT);
	}
	public void draw(NkContext ctx,String  value,boolean right) {
		 
 		Nuklear.nk_label(ctx, value,right ? Nuklear.NK_TEXT_ALIGN_RIGHT : Nuklear.NK_TEXT_ALIGN_LEFT );
 		
	}
	
	 
	 
	
}
