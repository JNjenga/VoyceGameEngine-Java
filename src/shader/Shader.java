package shader;

import java.util.*;

import javax.swing.*;

import org.joml.*;
import org.joml.Math;
import org.lwjgl.opengl.*;

import utility.*;

public class Shader {
	
	private int programID;
	
	private HashMap<String ,Integer> uniforms;
	
	public Shader(String shaderPath) {
		uniforms = new HashMap<String, Integer>();
		programID = load(shaderPath);
	}
	private int load(String path) {
		String vertexSource = Utility.loadAsString(path+".vert");
		String fragmentSource = Utility.loadAsString(path+".frag");
		
		return createShader(vertexSource, fragmentSource);
	}
	private int createShader(String vertexSource,String fragmentSource){
		int programID = GL20.glCreateProgram();
		
		int vertexID = GL20.glCreateShader(GL20.GL_VERTEX_SHADER);
		int fragmentID = GL20.glCreateShader(GL20.GL_FRAGMENT_SHADER);
		
		GL20.glShaderSource(vertexID, vertexSource);
		GL20.glShaderSource(fragmentID, fragmentSource);
		
		GL20.glCompileShader(vertexID);
		checkError(vertexID,"Vertex");
		GL20.glCompileShader(fragmentID);
		checkError(vertexID,"Fragment");
		
		GL20.glAttachShader(programID, vertexID);
		GL20.glAttachShader(programID, fragmentID);
		GL20.glLinkProgram(programID);
		GL20.glValidateProgram(programID);
		checkError(programID,"Program");
		
		GL20.glDeleteShader(vertexID);
		GL20.glDeleteShader(fragmentID);
		BugTracker.LOG("SUCCESS","SHADER :: Shaders loaded and compiled successfully");

		return programID;
		
	}
	
	
	private void checkError(int shader, String type) {
		if(type.startsWith("V") || type.startsWith("F")) {
			
			if(GL20.glGetShaderi(shader, GL20.GL_COMPILE_STATUS) == 0) {
				JOptionPane.showMessageDialog(null, "ERROR :: SHADER_COMMPILATION :: "+type+"\n"
						+GL20.glGetShaderInfoLog(shader,1024));
			BugTracker.LOG("ERROR", ":: SHADER_COMPILATION :: "+type+"\n"+GL20.glGetShaderInfoLog(shader,1024));
				
			}
			
		}else {
			if(GL20.glGetProgrami(shader, GL20.GL_LINK_STATUS) == 0) {
				JOptionPane.showMessageDialog(null, "ERROR :: PROGRAM_COMMPILATION\n"
						+GL20.glGetProgramInfoLog(shader,1024));
			BugTracker.LOG(":: PROGRAM_COMPILATION\n", GL20.glGetProgramInfoLog(shader,1024));
				
			}
		}
	}
	public void enableShader() {
		GL20.glUseProgram(programID);
	}
	
	public void disableShader() {
		GL20.glUseProgram(0);
	}
	
	public int getUniformLocation(String name) {
		if (!uniforms.containsKey(name)) {
			int uniformLocation =GL20.glGetUniformLocation(programID, name);;
			
			if (uniformLocation<0) {
				BugTracker.LOG("ERROR", "The uniform '"+name+"' was not found !");
				return 0;
			}
			uniforms.put(name, uniformLocation);
		}
		
 		return uniforms.get(name);
	}
	
	public int getAttribLocation(String name) {
		
		return GL20.glGetAttribLocation(programID, name);
	}
	
	float [] d = new float[16];
	
	public void setUnifrom(String name,Matrix4f mat) {
		
		GL20.glUniformMatrix4fv(getUniformLocation(name), false, mat.get(d));
	}
	Matrix4f model = new Matrix4f().translate(0, 0, -10f);
	Matrix4f p = new Matrix4f().perspective((float)Math.toRadians(45), 1080/780, (float) 0.1f, 100);
	public void updateViewMatrix(Matrix4f viewMatrix,Matrix4f p) {
		 
		model.rotate(0.04f, 1,0,0);
		setUnifrom("m_mat", model);
		 setUnifrom("p_mat", p);
		 setUnifrom("v_mat",viewMatrix);
		
 	}

}
