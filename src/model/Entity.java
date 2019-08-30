package model;

import org.joml.*;

public class Entity {
	
	private Model model;


	private Vector3f position;
	
	private Matrix4f p_mat;
	private Matrix4f m_mat;
	private Matrix4f v_mat;
	
	public Entity(String shaderName, String textureName, float[] vertices, int[] indices, float[] textureCoordinates) {
		//model = new Model(shaderName, textureName, vertices, indices, textureCoordinates);
	}
	public Entity(Model model) {
		this.model = model;
	}
	public void render() {
		
	}
}
