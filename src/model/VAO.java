package model;

import java.util.*;

import org.lwjgl.opengl.*;

public class VAO {
	int vaoID;
	
	List<Integer> Vbos;
	
	private final int VERTEX_BUFFER_POSITION = 0;
	private final int TEXTURE_BUFFER_POSITION = 1;
	private final int INDICES_BUFFER_POSITION = 2;
	
	int vertexCount = 0;
	boolean textured ;
	
	public int getVertexCount() {
		return vertexCount;
	}

	public VAO(float vertices[],int  indices[],float textureCoordinates[]){
		
		Vbos = new ArrayList<Integer>();
		
		vertexCount = vertices.length;
		
		vaoID =GL30.glGenVertexArrays();
		
		textured = false;

		Vbos.add(GL15.glGenBuffers());
		
		enableVao();
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, Vbos.get(VERTEX_BUFFER_POSITION));
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, vertices, GL15.GL_STATIC_DRAW);
		GL30.glVertexAttribPointer(VERTEX_BUFFER_POSITION, 3, GL11.GL_FLOAT, false, 0, 0);
		GL30.glEnableVertexAttribArray(VERTEX_BUFFER_POSITION);
		
		Vbos.add(GL15.glGenBuffers());
		textured = true;
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, Vbos.get(TEXTURE_BUFFER_POSITION));
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, textureCoordinates, GL15.GL_STATIC_DRAW);
		GL30.glVertexAttribPointer(TEXTURE_BUFFER_POSITION, 2, GL11.GL_FLOAT, false, 0, 0);
		GL30.glEnableVertexAttribArray(TEXTURE_BUFFER_POSITION);
		
		disableVao();

		Vbos.add(GL15.glGenBuffers());
		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, Vbos.get(INDICES_BUFFER_POSITION));
		GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, indices, GL15.GL_STATIC_DRAW);
		
		
	}
	
	public void draw() {
		GL11.glDrawElements(GL11.GL_TRIANGLES, vertexCount,GL11.GL_UNSIGNED_INT,0);

	}
	
	void enableVao(){
		if (textured) {
			GL30.glBindTexture(GL30.GL_TEXTURE_2D, Vbos.get(TEXTURE_BUFFER_POSITION));
		}

		GL30.glBindVertexArray(vaoID);
	}
	
	void disableVao(){
		GL30.glBindVertexArray(vaoID);
	}
}
