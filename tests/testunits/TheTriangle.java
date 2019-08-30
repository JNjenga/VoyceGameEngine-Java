package testunits;

import chasis.*;
import model.*;

public class TheTriangle implements Game{
	Model model ;
	@Override
	public void onStart() {
		float vertices[] = {
				-0.5f, -0.5f, 0.0f,
			     0.5f, -0.5f, 0.0f,
			     0.5f,  0.5f, 0.0f,
			     -0.5f,  0.5f, 0.0f
			};
		float texCoords[] = {
			    0.0f, 0.0f,  // lower-left corner  
			    1.0f, 0.0f,  // lower-right corner
			    1.0f, 1.0f,   // top-center corner
			    0.0f, 1.0f,  // lower-right corner
			};
		int indices[] = {
			    0,1,2,
			    2,3,0
			};
  		model = new Model("triangle","batman.jpg",vertices,indices,texCoords,false);
	}

	@Override
	public void onUpdate() {
	}

	@Override
	public void render() {
 		
		model.render( );
 	}

	@Override
	public void onClose() {
 		
	}


	public static void main(String[] args) {
		new Engine("test", 1080, 720, new TheTriangle()).start();;
	}
	 
	
}
