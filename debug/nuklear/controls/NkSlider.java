package nuklear.controls;

import static org.lwjgl.nuklear.Nuklear.*;

import org.lwjgl.nuklear.*;

public class NkSlider {
 
	private  float[] value;
	
	private float 	min,
					max,
					step;
	private String label;
	
	public NkSlider(String label, float min,float max, float step) {
		value = new float[1];
		value[0] = 4;
		
		this.label = label+": ";
		
		this.min =min;
		this.max = max;
		this.step = step;
 	}
	

	public void draw(NkContext ctx) {
//		nk_layout_row_dynamic(ctx, 20, 2);
//        nk_label(ctx, label, NK_TEXT_LEFT);
//        nk_label(ctx, String.valueOf(value[0]), NK_TEXT_LEFT);
//        nk_layout_row_dynamic(ctx, 25, 1);
//         nk_slider_float(ctx, min, value, max, step);
//        nk_layout_row_end(ctx);
		
		 nk_layout_row_dynamic(ctx, 25, 1);
         nk_property_float(ctx, label, 0, value, 100,0.1f, 0.1f);

	}
	
	public float getValue() {
		return value[0];
	}
	
	public void setValue(float value) {
		this.value[0] = value;
	}
}
