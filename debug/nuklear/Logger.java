package nuklear;

import org.lwjgl.nuklear.*;
import org.lwjgl.opengl.*;

import utility.*;
import window.*;

public class Logger extends Widget {

	
	//Text color
	NkColor white = NkColor.create().r((byte)0xFF).g((byte)0xFF).b((byte)0xFF).a((byte)0xFF);

	public Logger() {
		super("Voyce Debugger", Window.getWIDTH() * 3/4, 0, 350, 350);
	}

	@Override
	protected void layout(NkContext ctx) {
		ctx.style().text().color().set(white);
 		Nuklear.nk_layout_row_dynamic(ctx, 30, 2);
		Nuklear.nk_label(ctx,"Os : " ,Nuklear.NK_TEXT_ALIGN_LEFT);
		Nuklear.nk_label(ctx, System.getProperty("os.name"),Nuklear.NK_TEXT_ALIGN_RIGHT);
		
		Nuklear.nk_layout_row_dynamic(ctx, 30, 2);
		Nuklear.nk_label(ctx,"Version: " ,Nuklear.NK_TEXT_ALIGN_LEFT);
		Nuklear.nk_label(ctx,  String.valueOf(Runtime.version()),Nuklear.NK_TEXT_ALIGN_RIGHT);
		


		Nuklear.nk_layout_row_dynamic(ctx, 30, 2);
		Nuklear.nk_label(ctx,"Opengl version : ",Nuklear.NK_TEXT_ALIGN_LEFT);
		Nuklear.nk_label(ctx,GL11.glGetString(GL11.GL_VERSION),Nuklear.NK_TEXT_ALIGN_RIGHT);
	
		Nuklear.nk_layout_row_dynamic(ctx, 30, 2);
		Nuklear.nk_label(ctx,"Available processors : " ,Nuklear.NK_TEXT_ALIGN_LEFT);
		Nuklear.nk_label(ctx, String.valueOf(Runtime.getRuntime().availableProcessors()),Nuklear.NK_TEXT_ALIGN_RIGHT);
	
 		Nuklear.nk_layout_row_dynamic(ctx, 30, 2);
		Nuklear.nk_label(ctx,"Memory usage : ",Nuklear.NK_TEXT_ALIGN_LEFT);
		Nuklear.nk_label(ctx,Long.toString(BugTracker.GETMEMEMORYUSAGE()) + " Mb ",Nuklear.NK_TEXT_ALIGN_RIGHT);
	
	}

	@Override
	protected void updateProperties() {
		
	}
	
}
