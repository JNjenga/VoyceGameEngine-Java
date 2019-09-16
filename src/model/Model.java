package model;

import java.lang.Math;

import org.joml.*;

import render.*;
import shader.*;
import utility.*;

@SuppressWarnings("unused")
public class Model extends VoyceDrawable{

	private Matrix4f model_matrix = new Matrix4f();
	
	public Model (Mesh mesh,String shaderName) {
		setShaderName(shaderName);
		addMesh(mesh);
		
	}
	
	public Model (Mesh mesh,String shaderName,String textureName) {
		setShaderName(shaderName);
		addMesh(mesh);
		setTextureName(textureName);
	}
	
	public Model(Mesh mesh []) {
		
	}
	@Override
	protected void onRender() {
 		
	}

	 

	public Matrix4f getModel_matrix() {
		return model_matrix;
	}

	public void setModel_matrix(Matrix4f model_matrix) {
		this.model_matrix = model_matrix;
	}

	@Override
	protected void updateUniforms() {
 		ShaderCache.getInstance().getShader(getShaderName()).setUnifrom("m_mat", model_matrix);
		
	}

//	private Matrix4f m_mat;
//	private Matrix4f p_mat;
//	
//	public Model(String shaderName,String textureName,float vertices[],int indices[],float textureCoordinates[],boolean polygonMode) {
//  		setShaderName(shaderName);
//		setTextureName(textureName);
//		setPolygonMode(polygonMode);
//		
//		setVao( new Mesh(vertices,indices,textureCoordinates));
//		m_mat = new Matrix4f().translate(0, 0, 0);
//		//p_mat = new Matrix4f().perspective((float)Math.toRadians(45), 1080/720, 0.01f, 100);
//		
// 	}
//	
//	
// 
//	
//	public Model(Mesh[] vaos) {
//		this.vaos = vaos;
//		
//		setShaderName("triangle");
// 		setPolygonMode(false);
//		m_mat = new Matrix4f().translate(0, 0, 0);
//
// 	}
//
//
//
//
//	@Override
//	protected void onRender() {
// 		
//	}
//
//	
//
//
//	@Override
//	protected void updateUniforms() {
// 		 m_mat.rotate(0.02f, 0, 0, 1).identity(); 
//		ResourceManager.getInstance().getShader(shaderName).setUnifrom("m_mat", m_mat);
//		
//	}
//	
//	

}
