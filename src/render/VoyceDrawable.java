package render;

import java.util.*;

import org.joml.*;

import model.*;
import shader.*;
import texture.*;

/**
 * 
 * This is an abstract class to represent anything that can be rendered to the screen
 * It's main difference with Mesh,
 * Mesh contains the vertex data, this one contains one or more meshes
 * It also incorporates shaders : uniforms and textures
 * 
 */
public abstract class VoyceDrawable {
	
	protected List<Mesh> meshes;
	
	protected String shaderName = null;
	protected String textureName = null;
	
	protected boolean polygonMode;
	
	public VoyceDrawable() {
		
		polygonMode = false;
		meshes = new ArrayList<>();
		
	}
	public VoyceDrawable(String shaderName) {
		 
		this.shaderName = shaderName;
		
		polygonMode = false;
		meshes = new ArrayList<>();
		
	}
	
	public VoyceDrawable(String shaderName,String textureName) {
		 
		this.shaderName = shaderName;
		this.textureName = textureName;
		
		polygonMode = false;
		meshes = new ArrayList<>();
		
	}
	
	protected abstract void onRender();
 	protected abstract void updateUniforms();
	
	
	public void render() {
 		onRender();
		
 		if (meshes.size() == 1) {
			
 			/** Bind texture */
 				if (textureName != null) {
					
 					TextureCache.getInstance().getTexture(textureName).enable();

 				}
 				
 				
 	 		/** Bind Shader */
 				if (shaderName != null) {
					
 					ShaderCache.getInstance().getShader(shaderName).enableShader();

 				}
 	 	 	/** Update uniforms */
 				updateUniforms();
 	 	 	
 			/** TODO : Enable/Disable polygon mode*/
 			
 	 	 	/** Draw */
 				
 	 			meshes.get(0).enableVao();;
 	 			meshes.get(0).draw();;
 	 			meshes.get(0).disableVao();

 	 		/** TODO : Enable/Disable polygon mode*/
 	 		
 	 		/** Bind texture */
 				if (textureName != null) {
					
 					TextureCache.getInstance().getTexture(textureName).disable();
				}
 	 		/** Bind Shader */
 				if (shaderName != null) {

 					ShaderCache.getInstance().getShader(shaderName).disableShader();
 				}
		}
		
	}
	public String getShaderName() {
		return shaderName;
	}
	public void setShaderName(String shaderName) {
		this.shaderName = shaderName;
	}
	public String getTextureName() {
		return textureName;
	}
	public void setTextureName(String textureName) {
		this.textureName = textureName;
	}
	public boolean isPolygonMode() {
		return polygonMode;
	}
	public void setPolygonMode(boolean polygonMode) {
		this.polygonMode = polygonMode;
	}
	
	public void addMesh(Mesh mesh) {
		meshes.add(mesh);
	}
	 
}
