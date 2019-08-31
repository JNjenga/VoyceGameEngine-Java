package nuklear.controls;

import static org.lwjgl.nuklear.Nuklear.*;
import static org.lwjgl.system.MemoryStack.*;

import java.nio.*;

import org.lwjgl.nuklear.*;
import org.lwjgl.system.*;

public class UIColorPicker {
	
	private NkColorf background = NkColorf.create()
	        .r(0.10f)
	        .g(0.18f)
	        .b(0.24f)
	        .a(1.0f);
	private String label;
	
	public UIColorPicker(String label) {
		this.label = label+": ";
 	}

 	public void draw(NkContext ctx) {
 		  try(MemoryStack stack = stackPush()){
 			 nk_layout_row_dynamic(ctx, 20, 1);
             nk_label(ctx, label, NK_TEXT_LEFT);
              nk_layout_row_dynamic(ctx, 25, 1);
              if (nk_combo_begin_color(ctx, nk_rgb_cf(background, NkColor.mallocStack(stack)), NkVec2.mallocStack(stack).set(nk_widget_width(ctx), 400))) {
                  nk_layout_row_dynamic(ctx, 120, 1);
                  nk_color_picker(ctx, background, NK_RGBA);
                  nk_layout_row_dynamic(ctx, 25, 1);
                  background
                      .r(nk_propertyf(ctx, "#R:", 0, background.r(), 1.0f, 0.01f, 0.005f))
                      .g(nk_propertyf(ctx, "#G:", 0, background.g(), 1.0f, 0.01f, 0.005f))
                      .b(nk_propertyf(ctx, "#B:", 0, background.b(), 1.0f, 0.01f, 0.005f))
                      .a(nk_propertyf(ctx, "#A:", 0, background.a(), 1.0f, 0.01f, 0.005f));
                  nk_combo_end(ctx);
              }
             }
	}
	
	public NkColorf getBackground() {
		return background;
	}
	public void setBackground(NkColorf background) {
		this.background = background;
	}
}
