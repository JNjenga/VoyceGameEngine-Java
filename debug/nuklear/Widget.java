package nuklear;

import static org.lwjgl.nuklear.Nuklear.*;

import org.lwjgl.nuklear.*;

public abstract class Widget {
	
	protected int x;
	protected int y;
	NkRect rect = null;
	
	private String windowName = "My window";
	
	private int windowOptions = NK_WINDOW_TITLE|NK_WINDOW_BORDER|NK_WINDOW_MOVABLE| NK_WINDOW_SCALABLE | NK_WINDOW_MINIMIZABLE|NK_WINDOW_CLOSABLE;
	private float width;
	private float height;
	
	
 	public Widget(String windowName ,int x,int y,float width,float height ) {
		this.x = x;
		this.y = y;
		this.windowName = windowName;
		this.height = height;
		this.width = width;
		rect = NkRect.create().x(x).y(y).w(width).h(height);
		
 		
 	}
	
	 
	
	protected abstract void layout(NkContext ctx);
	public  void draw(NkContext ctx) {
		begin(ctx);
		layout(ctx);
		end(ctx);
		updateProperties();
	}
	protected void begin(NkContext ctx) {
		 nk_begin(
                ctx,
                windowName,
                nk_rect(x, y, width, height, rect),
                windowOptions
            );
	}
	
	public String getWindowName() {
		return windowName;
	}
	
	protected abstract void updateProperties();
	
	protected void end(NkContext ctx){
			nk_end(ctx);
		}
	
}
