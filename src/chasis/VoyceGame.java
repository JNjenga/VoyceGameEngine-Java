package chasis;

import java.util.*;

public abstract class VoyceGame {

	boolean running = true;
	
	String title;
	int width,height;
	
	private HashMap<String, Layer> layers;
	
	boolean fullscreen;
	
	public VoyceGame(String title, int width, int height,boolean fullscreen) {
 		this.title = title;
		this.width = width;
		this.height = height;
		
		this.layers = new HashMap<String,Layer>();
		this.fullscreen = fullscreen;
	}

	protected abstract void onStart();
	
	protected abstract void onUpdate();
	
	protected abstract void render();
	
	protected abstract void onClose();

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public void pushLayer(String layerName,Layer layer) {
		layers.put(layerName, layer);
	}
	
	public void removeLayer(String layername,Layer layer){
		layers.remove(layername);
	}
	
	public void getLayer(String layername){
		layers.get(layername);
	}
	
	public boolean isFullscreen() {
		return fullscreen;
	}

	public void setFullscreen(boolean fullscreen) {
		this.fullscreen = fullscreen;
	}

	public void renderLayers( ){
		layers.forEach((layername,layer)->{
			if (layer.isVisible) {
				layer.onRender();
			}
		});
	}
}
