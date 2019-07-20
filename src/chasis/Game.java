package chasis;

public interface Game {
	boolean running = false;
	
	void onStart();
	
	void onUpdate();
	
	void render();
	
	void onClose();
}

