package events.handlers;

import java.nio.*;

public interface MouseDragHandler {
	 
	void handle(int button,double xpos,double ypos,double xprev,double yprev);
	
	 
}
