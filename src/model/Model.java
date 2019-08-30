package model;

import org.joml.*;

import render.*;
import utility.*;

@SuppressWarnings("unused")
public class Model extends Drawable{

	private Matrix4f m_mat;
	
	public Model(String shaderName,String textureName,float vertices[],int indices[],float textureCoordinates[],boolean polygonMode) {
  		setShaderName(shaderName);
		setTextureName(textureName);
		setPolygonMode(polygonMode);
		
		setVao( new VAO(vertices,indices,textureCoordinates));
		m_mat = new Matrix4f();
		
 	}
	
	
 
	
	@Override
	protected void onRender() {
 		
	}

	


	@Override
	protected void updateUniforms() {
		
		//m_mat.rotate(0.02f, 0, 0, 1);
		//ResourceManager.getInstance().getShader(shaderName).setUnifrom("m_mat", m_mat);
		
	}
	
	

}
