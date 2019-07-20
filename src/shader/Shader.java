package shader;

import javax.swing.*;

import org.lwjgl.opengl.*;

import utility.*;

public class Shader {
	
	private int programID;
	
	
	
	public Shader(String shaderPath) {
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

}
