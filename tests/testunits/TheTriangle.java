package testunits;

import org.lwjgl.opengl.*;

import chasis.*;
import model.*;
import render.*;
import utility.*;

public class TheTriangle implements Game{
	Model model ;
	private VAO v;
	private int vaoID;
	private int vbo;
	private float[] vertices;
	@Override
	public void onStart() {
		  vertices = new float[] {
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
				0.5f, 0.0f, 0.0f,
				0.0f, 0.5f, 0.0f,
				0.0f, 0.0f, 0.5f,
				0.0f, 0.5f, 0.5f,
				0.5f, 0.0f, 0.0f,
				0.0f, 0.5f, 0.0f,
				0.0f, 0.0f, 0.5f,
				0.0f, 0.5f, 0.5f,
				};
		  vaoID =GL30.glGenVertexArrays();
		  vbo = GL15.glGenBuffers();
		GL30.glBindVertexArray(vaoID);
		
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER,vbo);
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, vertices, GL15.GL_STATIC_DRAW);
		GL30.glVertexAttribPointer(0, 3, GL11.GL_FLOAT, false, 0, 0);
		GL30.glEnableVertexAttribArray(0);
		 
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, GL15.glGenBuffers());
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, textureCoordinates, GL15.GL_STATIC_DRAW);
		GL30.glVertexAttribPointer(1, 2, GL11.GL_FLOAT, false, 0, 0);
		GL30.glEnableVertexAttribArray(1);
		
		int ibo = GL15.glGenBuffers();
		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, ibo);
		GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, indices, GL15.GL_STATIC_DRAW);
		

 		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);

 		GL30.glBindVertexArray(0);

 		ResourceManager.getInstance().getShader("triangle");
 		ResourceManager.getInstance().getTexture("testtex.png");
  		model = new Model("triangle","testtex.png",vertices,indices,textureCoordinates,false);

  	}

	@Override
	public void onUpdate() {
	}

	@Override
	public void render() {
		Renderer.clear();
		ResourceManager.getInstance().getShader("triangle").enableShader();
		ResourceManager.getInstance().getTexture("testtex.png").enable();
		GL30.glBindVertexArray(vaoID);
		GL30.glEnableVertexAttribArray(0);
		GL30.glEnableVertexAttribArray(1);
 		GL11.glDrawElements(GL11.GL_TRIANGLES, vertices.length,GL11.GL_UNSIGNED_INT,0);
 		GL30.glDisableVertexAttribArray(0);
 		GL30.glDisableVertexAttribArray(1);
		GL30.glBindVertexArray(0);
		
 
  	}

	@Override
	public void onClose() {
 		
	}


	public static void main(String[] args) {
		new Engine("test", 1080, 720, new TheTriangle()).start();;
	}
	 
	
}
