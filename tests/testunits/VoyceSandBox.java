package testunits;

import chasis.*;
import model.*;
import utility.*;

public class VoyceSandBox extends VoyceGame {

 
	public VoyceSandBox( ) {
		super("VOYCE SANDBOX", 1080, 720,false);
 	}

	@Override
	
	protected void onStart() {
		pushLayer("Logo", new Logo());
		pushLayer("Batman", new Batman());
		pushLayer("Bob", new Bob());
	}

	@Override
	protected void onUpdate() {
		
	}

	@Override
	protected void render() {
		renderLayers();
 	}

	@Override
	protected void onClose() {
 
	}
	
	public static void main(String[] args) {
		new BaseEngine(new VoyceSandBox()).start();
	}

}

class Batman extends Layer{

	
	
	private Model model;

	@Override
	protected void onInit() {
		float vertices[] = {
				.5f,.5f,0.0f,
				.5f,-.5f,0.0f,
				-.5f,-.5f,0.0f,
				-.5f,.5f,0.0f,
				
		         
		    };
		float textureCoordinates [] = {
				1,1,
				1,0,
				0,0,
				0,1
				         
		};
		int indices[] = {
			    0,1,3,
			     1,2,3
			};
		
		Mesh mesh = new Mesh(vertices, indices, textureCoordinates);
		model = new Model(mesh,"triangle","batman.jpg" );
 	}

	@Override
	protected void onUpdate() {
 		
	}

	@Override
	protected void onRender() {
		 
 			model.render();
		 
 	}

	@Override
	protected void onClose() {
 		
	}
	
}



class Logo extends Layer{

	
	
	private Model model;

	@Override
	protected void onInit() {
		float vertices[] = {
				.5f,.5f,0.0f,
				.5f,-.5f,0.0f,
				-.5f,-.5f,0.0f,
				-.5f,.5f,0.0f,
				
		         
		    };
		float textureCoordinates [] = {
				1,1,
				1,0,
				0,0,
				0,1
				         
		};
		int indices[] = {
			    0,1,3,
			     1,2,3
			};
		
		Mesh mesh = new Mesh(vertices, indices, textureCoordinates);
		model = new Model(mesh,"triangle","iorn_man_mask.jpg" );
		model.getModel_matrix().identity().translate(0.0f, 0.5f, 0).scale(0.7f);
	}

	@Override
	protected void onUpdate() {
 		
	}

	@Override
	protected void onRender() {
 			
 			model.render();
			
 		
 	}

	@Override
	protected void onClose() {
 		
	}
	
}

class Bob extends Layer{

	
	
	private Model model;

	@Override
	protected void onInit() {
		float vertices[] = {
				.5f,.5f,0.0f,
				.5f,-.5f,0.0f,
				-.5f,-.5f,0.0f,
				-.5f,.5f,0.0f,
				
		         
		    };
		float textureCoordinates [] = {
				1,1,
				1,0,
				0,0,
				0,1
				         
		};
		int indices[] = {
			    0,1,3,
			     1,2,3
			};
		
		Mesh mesh = new Mesh(vertices, indices, textureCoordinates);
		model = new Model(mesh,"triangle","bob_marley.jpg" );
		model.getModel_matrix().identity().translate(-0.5f,0.5f, 0);
	}

	@Override
	protected void onUpdate() {
 		
	}

	@Override
	protected void onRender() {
 			
 			model.render();
			
 		
 	}

	@Override
	protected void onClose() {
 		
	}
	
}
