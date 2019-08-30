package model;

import java.lang.Math;

import org.joml.*;

import render.*;
import utility.*;

@SuppressWarnings("unused")
public class Model extends Drawable{

	private Matrix4f m_mat;
	private Matrix4f p_mat;
	
	public Model(String shaderName,String textureName,float vertices[],int indices[],float textureCoordinates[],boolean polygonMode) {
  		setShaderName(shaderName);
		setTextureName(textureName);
		setPolygonMode(polygonMode);
		
		setVao( new VAO(vertices,indices,textureCoordinates));
		m_mat = new Matrix4f().translate(0, 0, 0);
		//p_mat = new Matrix4f().perspective((float)Math.toRadians(45), 1080/720, 0.01f, 100);
		
 	}
	
	
 
	
	@Override
	protected void onRender() {
 		
	}

	


	@Override
	protected void updateUniforms() {
 		m_mat.rotate(0.02f, 0, 0, 1); 
		ResourceManager.getInstance().getShader(shaderName).setUnifrom("m_mat", m_mat);
		
	}
	
	

}
