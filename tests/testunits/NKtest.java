package testunits;

import org.lwjgl.glfw.*;
import org.lwjgl.nuklear.*;
import org.lwjgl.system.*;

import static org.lwjgl.nuklear.Nuklear.*;
import static org.lwjgl.system.MemoryUtil.*;

import java.nio.*;

import chasis.*;
import model.*;
import nuklear.*;
import render.*;
import utility.*;

public class NKtest implements Game{
     
 
	private NuklearManager m;
	private Model model;

	@Override
	public void onStart() {
		m = new NuklearManager();
		
		m.addWidgets(new Logger());
		m.addWidgets(new Demo());
	     
		
		float vertices[] = {
		        -0.5f, -0.5f, -0.5f,  
		         0.5f, -0.5f, -0.5f,  
		         0.5f,  0.5f, -0.5f,  
		         0.5f,  0.5f, -0.5f,  
		        -0.5f,  0.5f, -0.5f,  
		        -0.5f, -0.5f, -0.5f,  
                                      
		        -0.5f, -0.5f,  0.5f,  
		         0.5f, -0.5f,  0.5f,  
		         0.5f,  0.5f,  0.5f,  
		         0.5f,  0.5f,  0.5f,  
		        -0.5f,  0.5f,  0.5f,  
		        -0.5f, -0.5f,  0.5f,  
                                      
		        -0.5f,  0.5f,  0.5f,  
		        -0.5f,  0.5f, -0.5f,  
		        -0.5f, -0.5f, -0.5f,  
		        -0.5f, -0.5f, -0.5f,  
		        -0.5f, -0.5f,  0.5f,  
		        -0.5f,  0.5f,  0.5f,  
                                      
		         0.5f,  0.5f,  0.5f,  
		         0.5f,  0.5f, -0.5f,  
		         0.5f, -0.5f, -0.5f,  
		         0.5f, -0.5f, -0.5f,  
		         0.5f, -0.5f,  0.5f,  
		         0.5f,  0.5f,  0.5f,  
                                      
		        -0.5f, -0.5f, -0.5f,  
		         0.5f, -0.5f, -0.5f,  
		         0.5f, -0.5f,  0.5f,  
		         0.5f, -0.5f,  0.5f,  
		        -0.5f, -0.5f,  0.5f,  
		        -0.5f, -0.5f, -0.5f,  
                                      
		        -0.5f,  0.5f, -0.5f,  
		         0.5f,  0.5f, -0.5f,  
		         0.5f,  0.5f,  0.5f,  
		         0.5f,  0.5f,  0.5f,  
		        -0.5f,  0.5f,  0.5f,  
		        -0.5f,  0.5f, -0.5f,  
		    };
		float texcoords [] = {
				0.0f, 0.0f,
				1.0f, 0.0f,
				1.0f, 1.0f,
				1.0f, 1.0f,
				0.0f, 1.0f,
				0.0f, 0.0f,
				           
				0.0f, 0.0f,
				1.0f, 0.0f,
				1.0f, 1.0f,
				1.0f, 1.0f,
				0.0f, 1.0f,
				0.0f, 0.0f,
				           
				1.0f, 0.0f,
				1.0f, 1.0f,
				0.0f, 1.0f,
				0.0f, 1.0f,
				0.0f, 0.0f,
				1.0f, 0.0f,
				           
				1.0f, 0.0f,
				1.0f, 1.0f,
				0.0f, 1.0f,
				0.0f, 1.0f,
				0.0f, 0.0f,
				1.0f, 0.0f,
				           
				0.0f, 1.0f,
				1.0f, 1.0f,
				1.0f, 0.0f,
				1.0f, 0.0f,
				0.0f, 0.0f,
				0.0f, 1.0f,
				           
				0.0f, 1.0f,
				1.0f, 1.0f,
				1.0f, 0.0f,
				1.0f, 0.0f,
				0.0f, 0.0f,
				0.0f, 1.0f 
		};
		int indices[] = {
			    0,1,2,
			    2,3,0
			};
  		model = new Model("triangle","testtex.png",vertices,indices,texcoords,false);
 	}

	@Override
	public void onUpdate() {
 		
	}

	@Override
	public void render() {
		
 		m.render();
 		model.render();
   		
 	}

	@Override
	public void onClose() {
 		m.kill();
	}

	public static void main(String[] args) {
		new Engine("test", 1080, 720, new NKtest()).start();;
	}
	 
}

 
