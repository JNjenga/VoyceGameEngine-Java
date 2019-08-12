package testunits;

import org.lwjgl.glfw.*;

import chasis.*;
import model.*;
import window.*;

public class WindowTest implements Game{
	Model model ;
	@Override
	public void onStart() {
		
 
	}

	@Override
	public void onUpdate() {
		 
	}

	@Override
	public void render() {
 		

	}

	@Override
	public void onClose() {
 		
	}

	 
	public static void main(String[] args) {
		new Engine("", 1080,720,new WindowTest()).start();;
	}
}
