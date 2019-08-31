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
import nuklear.controls.*;
import render.*;
 
public class Demo extends Widget{

	 
	NkSlider slider ;
	NkButton button ;
	
	int countValue =0;
	private UIColorPicker colorPicker;
    public Demo() {
    	super("Voyce Color changer",0,0,230,250);
    	
    	colorPicker = new UIColorPicker("Background");
    	slider = new NkSlider("Demo value ",0, 100, 1);
    	button = new NkButton("Click me", ()->{
    		countValue ++;
    	});
    }

   @Override
protected boolean begin(NkContext ctx) {
 	return super.begin(ctx);
	
	
}
 
    public void layout(NkContext ctx) {
    	
    	slider.draw(ctx);
    	
    	button.draw(ctx);
    	
    	colorPicker.draw(ctx);
               
              
         
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