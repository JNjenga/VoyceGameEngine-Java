/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 */
package nuklear;

import static org.lwjgl.nuklear.Nuklear.*;
import static org.lwjgl.system.MemoryStack.*;

import java.nio.*;

import org.lwjgl.*;
import org.lwjgl.nuklear.*;
import org.lwjgl.system.*;

import nuklear.*;
import render.*;
 
public class Demo extends Widget{

	public NkColorf background = NkColorf.create()
	        .r(0.10f)
	        .g(0.18f)
	        .b(0.24f)
	        .a(1.0f);
    public Demo() {
    	super("Voyce Color changer",0,0,230,250);
    }

   @Override
protected void begin(NkContext ctx) {
	// TODO Auto-generated method stub
	super.begin(ctx);
	
	
}

   String weapons[] = {"Fist","Pistol","Shotgun","Plasma","BFG"};
   PointerBuffer items  = BufferUtils.createPointerBuffer(5);
    public void layout(NkContext ctx) { 
              try(MemoryStack stack = stackPush()){
                nk_layout_row_static(ctx, 30, 80, 1);
                if (nk_button_label(ctx, "button")) {
                    System.out.println("button pressed");
                }
                nk_layout_row_dynamic(ctx, 20, 1);
                nk_label(ctx, "background:", NK_TEXT_LEFT);
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

	@Override
	protected void updateProperties() {
		Renderer.clear(background.r(),
 				background.g(),
 				background.b(),
 				background.a());
	}

}