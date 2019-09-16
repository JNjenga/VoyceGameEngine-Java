package model;

import java.util.*;

import org.lwjgl.opengl.*;

public class Mesh {
	int vaoID;
	
	List<Integer> Vbos;
	
	private final int VERTEX_BUFFER_POSITION = 0;
	private final int TEXTURE_BUFFER_POSITION = 1;
	private final int NORMAL_BUFFER_POSITION = 2;
	private final int INDICES_BUFFER_POSITION = 3;
	
	int vertexCount = 0;
	boolean textured ;
	
	public int getVertexCount() {
		return vertexCount;
	}

	public Mesh(float vertices[],int  indices[],float textureCoordinates[]){
		Vbos = new ArrayList<Integer>();
		
		vertexCount = vertices.length;
		
//		Create vertex array
		vaoID =GL30.glGenVertexArrays();
		
//		Select the vao
		enableVao();
		
		
//		VERTEX
 		Vbos.add(GL15.glGenBuffers());
		
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, Vbos.get(VERTEX_BUFFER_POSITION));
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, vertices, GL15.GL_STATIC_DRAW);
		GL30.glVertexAttribPointer(VERTEX_BUFFER_POSITION, 3, GL11.GL_FLOAT, false, 0, 0);
		
		GL30.glEnableVertexAttribArray(VERTEX_BUFFER_POSITION);
		
//		TEXTURE
		textured = true;
		Vbos.add(GL15.glGenBuffers());
		
 		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, Vbos.get(TEXTURE_BUFFER_POSITION));
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, textureCoordinates, GL15.GL_STATIC_DRAW);
		GL30.glVertexAttribPointer(TEXTURE_BUFFER_POSITION, 2, GL11.GL_FLOAT, false, 0, 0);
		
		GL30.glEnableVertexAttribArray(TEXTURE_BUFFER_POSITION);
		
//		IBO
		Vbos.add(GL15.glGenBuffers());
		
		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, Vbos.get(2));
		GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, indices, GL15.GL_STATIC_DRAW);
		
		
 		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
 		GL30.glBindVertexArray(0);		
	}

	public Mesh(float vertices[],int  indices[],float textureCoordinates[],float normals[] ){
		Vbos = new ArrayList<Integer>();
		
		vertexCount = vertices.length;
		
//		Create vertex array
		vaoID =GL30.glGenVertexArrays();
		
//		Select the vao
		enableVao();
		
		
//		VERTEX
 		Vbos.add(GL15.glGenBuffers());
		
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, Vbos.get(VERTEX_BUFFER_POSITION));
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, vertices, GL15.GL_STATIC_DRAW);
		GL30.glVertexAttribPointer(VERTEX_BUFFER_POSITION, 3, GL11.GL_FLOAT, false, 0, 0);
		
		GL30.glEnableVertexAttribArray(VERTEX_BUFFER_POSITION);
		
//		TEXTURE
		textured = true;
		Vbos.add(GL15.glGenBuffers());
		
 		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, Vbos.get(TEXTURE_BUFFER_POSITION));
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, textureCoordinates, GL15.GL_STATIC_DRAW);
		GL30.glVertexAttribPointer(TEXTURE_BUFFER_POSITION, 2, GL11.GL_FLOAT, false, 0, 0);
		
		GL30.glEnableVertexAttribArray(TEXTURE_BUFFER_POSITION);
		
		
//		NORMALS
 		Vbos.add(GL15.glGenBuffers());
		
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, Vbos.get(NORMAL_BUFFER_POSITION));
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, normals, GL15.GL_STATIC_DRAW);
		GL30.glVertexAttribPointer(NORMAL_BUFFER_POSITION, 3, GL11.GL_FLOAT, false, 0, 0);
		
		GL30.glEnableVertexAttribArray(NORMAL_BUFFER_POSITION);
//		IBO
		Vbos.add(GL15.glGenBuffers());
		
		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, Vbos.get(INDICES_BUFFER_POSITION));
		GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, indices, GL15.GL_STATIC_DRAW);
		
		
 		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
 		GL30.glBindVertexArray(0);		
	}

	
	
 	 public void draw() {
		GL11.glDrawElements(GL11.GL_TRIANGLES, vertexCount,GL11.GL_UNSIGNED_INT,0);

	}
	
	public void enableVao(){
		if (textured) {
			// GL30.glBindTexture(GL30.GL_TEXTURE_2D, Vbos.get(TEXTURE_BUFFER_POSITION));
		}

		GL30.glBindVertexArray(vaoID);
		
		GL30.glEnableVertexAttribArray(VERTEX_BUFFER_POSITION);
		GL30.glEnableVertexAttribArray(TEXTURE_BUFFER_POSITION);
		GL30.glEnableVertexAttribArray(INDICES_BUFFER_POSITION);

	}
	
	public void disableVao(){
		 

		GL30.glDisableVertexAttribArray(VERTEX_BUFFER_POSITION);
		GL30.glDisableVertexAttribArray(TEXTURE_BUFFER_POSITION);
		GL30.glDisableVertexAttribArray(INDICES_BUFFER_POSITION);
		GL30.glBindVertexArray(0);
	}
	
	public boolean isTextured() {
		return textured;
	}
}
