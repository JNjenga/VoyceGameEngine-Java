package model;

import org.lwjgl.opengl.*;

import texture.*;
import utility.*;

@SuppressWarnings("unused")
public class Model {

	int VBO;
	VAO vao;
	String shaderName;
	String textureName;
	
	public Model(String shaderName,String textureName,float vertices[],int indices[],float textureCoordinates[]) {
		this.shaderName = shaderName;
		this.textureName = textureName;
 		vao = new VAO(vertices,indices,textureCoordinates);
	}
	
	
	public void draw(boolean polygonMode) {
		ResourceManager.getInstance().getTexture(textureName).enable();
		ResourceManager.getInstance().getShader(shaderName).enableShader();
		
		vao.enableVao();
		vao.draw();
		vao.disableVao();
		
		ResourceManager.getInstance().getShader(shaderName).disableShader();
		ResourceManager.getInstance().getTexture(textureName).disable();
		
	}

}
