package testunits;

import chasis.*;
import model.*;
import nuklear.*;

public class SandBox implements Game{
     
 
	 

	@Override
	public void onStart() {
		 		
		pushLayer("DebugLayer", new DebugLayer( ));
		 pushLayer("GameLayer", new TestLayer());
		 
 	}

	@Override
	public void onUpdate() {
 		
	}

	@Override
	public void render() {
		 
		renderLayers();
		  
 	}

	@Override
	public void onClose() {
 	}

	public static void main(String[] args) {
		new Engine("test", 1080, 720, new SandBox()).start();;
	}
	 
}


class TestLayer extends Layer{
	

	
	private Model model;
	
	public TestLayer() {
		onInit();
	}

	@Override
	public void onInit() {
		float vertices[] = {
				.5f,.5f,0.0f,
				.5f,-.5f,0.0f,
				-.5f,-.5f,0.0f,
				-.5f,.5f,0.0f,
				
		         
		    };
		float texcoords [] = {
				1,1,
				1,0,
				0,0,
				0,1
				         
		};
		int indices[] = {
			    0,1,3,
			     1,2,3
			};
		
		// model = new Model("triangle","batman.jpg",vertices,indices,texcoords,false);

		
	}

	@Override
	public void onUpdate() {
		
		
	}

	@Override
	public void onRender() {
		
		model.render();
	}

	@Override
	public void onClose() {
		
		
	}
	
}

class DebugLayer extends Layer{

	private NuklearManager m;

	public DebugLayer() {
		onInit();
	}
	@Override
	public void onInit() {
		m = new NuklearManager();
		
		m.addWidgets(new Demo());
		m.addWidgets(new Logger());
		
		 
	}

	@Override
	public void onUpdate() {
 		
	}

	@Override
	public void onRender() {
 		m.render();

	}

	@Override
	public void onClose() {
 		m.kill();

	}
	
}
 
