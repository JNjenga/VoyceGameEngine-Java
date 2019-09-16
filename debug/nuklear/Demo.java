/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 */
package nuklear;

import static org.lwjgl.nuklear.Nuklear.*;

import java.nio.*;

import org.lwjgl.nuklear.*;

import nuklear.controls.*;
import render.*;
import utility.*;
import window.*;
 
public class Demo extends Widget{

	 
	NkSlider slider ;
	NkButton button ;
	
	int countValue =0;
	private UIColorPicker colorPicker;
	
	ByteBuffer buffer = ByteBuffer.allocate(1024).flip();
	NkImage image = NkImage.create();
	
    public Demo() {
    	super("Voyce Color changer",0,0,Window.getWIDTH()/5,Window.getHEIGHT());
    	
    	colorPicker = new UIColorPicker("Background");
    	slider = new NkSlider("Demo value ",0, 100, 1);
    	button = new NkButton("Click me", ()->{
    		countValue ++;
    	});
     	image.handle(it -> it.id(0)); // See NkImage for details

     }

   @Override
protected boolean begin(NkContext ctx) {
 	return super.begin(ctx);
	
	
}
 
    public void layout(NkContext ctx) {
         	if(nk_tree_image_push_hashed(ctx, NK_TREE_TAB,image, "Camera", NK_MINIMIZED, buffer, 0)) {
        		slider.draw(ctx);
        		
        		button.draw(ctx);
        		
        		colorPicker.draw(ctx);
        		
        		nk_tree_pop(ctx);
        		
        	}
        
		
              
         
    }

	@Override
	protected void updateProperties() {
		Renderer.clear(
				colorPicker.getBackground().r(),
				colorPicker.getBackground().g(),
				colorPicker.getBackground().b(),
				colorPicker.getBackground().a()
				);
	}

}