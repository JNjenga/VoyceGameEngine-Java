package chasis;

public interface Structure {
	boolean running = false;
	
	void onStart();
	
	void onUpdate();
	
	void render();

}

