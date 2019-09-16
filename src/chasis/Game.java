package chasis;

import java.util.*;

public interface Game {
	boolean running = false;
	
	HashMap<String, Layer> layers = new HashMap<>();
	
//	Game Properties
	
	void onStart();
	
	void onUpdate();
	
	void render();
	
	void onClose();
	
	
	
	default void pushLayer(String layername,Layer layer){
		layers.put(layername, layer);
	}
	
	default void removeLayer(String layername,Layer layer){
		layers.remove(layername);
	}
	
	default void getLayer(String layername){
		layers.get(layername);
	}
	
	default void renderLayers( ){
		layers.forEach((layername,layer)->{
			if (layer.isVisible) {
				layer.onRender();
			}
		});
	}
}

