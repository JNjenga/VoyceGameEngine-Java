package events;

import window.*;

public  class Event {
	
 	long windowHandle;
	boolean occured;
	
	public Event() {
		windowHandle = Window.window;
 	}
	
	public void setOccured(boolean occured) {
		this.occured = occured;
	}
	
	public boolean isOccured() {
		return occured;
	}
	
	public void registerEvent() {
 	}
}
