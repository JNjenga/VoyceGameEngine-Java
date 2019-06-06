package model;

import org.lwjgl.opengl.*;

import texture.*;
import utility.*;

@SuppressWarnings("unused")
public class Model {

	int VBO;
	VAO vao;
	String shaderName;
	Texture texture;
	public Model(String shaderName,String textureName,float vertices[],int indices[],float textureCoordinates[]) {
		this.shaderName = shaderName;
		texture = new Texture(textureName);
		vao = new VAO(vertices,indices,textureCoordinates);
	}
	
	
	public void draw(boolean polygonMode) {
		texture.enable();
		ResourceManager.getInstance().getShader(shaderName).enableShader();
		
		vao.enableVao();
		vao.draw();
		vao.disableVao();
		texture.disable();

	}

}
