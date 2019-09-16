package testunits;

import chasis.*;
import model.*;
import nuklear.*;

public class NKtest implements Game{
     
 
	private NuklearManager m;
	private Model model;

	@Override
	public void onStart() {
		m = new NuklearManager();
		
		m.addWidgets(new Demo());
		m.addWidgets(new Logger());
 	     
		
//		float vertices[] = {
//				0.0f,
//				0.5f, 0.0f,
//				-0.5f, -0.5f, 0.0f,
//				0.5f, -0.5f, 0.0f
//                                      
//		         
//		    };
//		float texcoords [] = {
//				0.0f, 0.0f,
//				1.0f, 0.0f,
//				1.0f, 1.0f, 
//				         
//		};
//		int indices[] = {
//			    0,1,2,
//			     
//			};
		
		float [] vertices = new float[] {
				// VO
				-0.5f,
				0.5f, 0.5f,
				-0.5f, -0.5f, 0.5f,
				// V1
				// V2
				0.5f, -0.5f,
				0.5f,
				// V3
				0.5f,
				0.5f,
				0.5f,
				// V4
				-0.5f,
				0.5f, -0.5f,
				// V5
				0.5f,
				0.5f, -0.5f,
				// V6
				-0.5f, -0.5f, -0.5f,
				// V7
				0.5f, -0.5f, -0.5f,
				};
		int[] indices = new int[]{
				// Front face
				0, 1, 3, 3, 1, 2,
				// Top Face
				4, 0, 3, 5, 4, 3,
				// Right face
				3, 2, 7, 5, 3, 7,
				// Left face
				6, 1, 0, 6, 0, 4,
				// Bottom face
				2, 1, 6, 2, 6, 7,
				// Back face
				7, 6, 4, 7, 4, 5,
				};
		float[] textureCoordinates = new float[]{
				1.0f, 0.0f, 0.0f,
				0.0f, 1.0f, 0.0f,
				0.0f, 0.0f, 1.0f,
				0.0f, 1.0f, 1.0f,
				1.0f, 0.0f, 0.0f,
				0.0f, 1.0f, 0.0f,
				0.0f, 0.0f, 1.0f,
				0.0f, 1.0f, 1.0f,
				};
  		model = new Model("triangle","batman.jpg",vertices,indices,textureCoordinates,false);
 	}

	@Override
	public void onUpdate() {
 		
	}

	@Override
	public void render() {
		
 		model.render();
   		
 		m.render();
 	}

	@Override
	public void onClose() {
 		m.kill();
	}

	public static void main(String[] args) {
		new Engine("test", 1080, 720, new NKtest()).start();;
	}
	 
}

 
