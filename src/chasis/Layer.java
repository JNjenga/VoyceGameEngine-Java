package chasis;

import org.joml.*;

public abstract class Layer {
	
	 boolean isVisible = true;
	
	boolean isLocked = false;
	
	Matrix4f projectionMatrix = new Matrix4f();
	
	public Layer() {
		onInit();
 	}
	protected abstract void onInit();
	
	protected abstract void onUpdate();
	
	protected abstract void onRender();
	
	protected abstract void onClose();
}
