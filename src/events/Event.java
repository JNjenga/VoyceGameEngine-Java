package events;

import window.*;

public abstract class Event {
	
	long windowHandle;
	private boolean occured = false;
	
	public Event() {
		windowHandle = Window.getWindowHandle();
 	}
	
	public abstract void init() ;
	
	public void setOccured(boolean occured) {
		this.occured = occured;
	}
	
	public boolean isOccured() {
		return occured;
	}
}
