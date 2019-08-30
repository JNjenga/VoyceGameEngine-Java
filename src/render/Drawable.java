package render;

import org.joml.*;

import model.*;
import shader.*;
import utility.*;

public abstract class Drawable {
	
		protected VAO vao;
		
		protected String shaderName;
		protected String textureName;
		
		protected boolean polygonMode ;
 		
		
		
		public Drawable() {
			
 			polygonMode = false;
 		}
		
//		protected abstract void draw() ;
		
		protected abstract void onRender() ;
		
		protected abstract void updateUniforms() ;
		
		public void render() {
			
			onRender();
			
			
			if (vao.isTextured()) {
				//ResourceManager.getInstance().getTexture(textureName).enable();
			}
			Shader shader = ResourceManager.getInstance().getShader(shaderName);
			shader.enableShader();
			updateUniforms();
			
			if (polygonMode) {
				
				Renderer.enablePolygonMode();

			}

			 
			vao.enableVao();
			vao.draw();
			vao.disableVao();
			
			if (polygonMode) {
				
				Renderer.disablePolygonMode();

			}
			ResourceManager.getInstance().getShader(shaderName).disableShader();
 			
		}

		public boolean isPolygonMode() {
			return polygonMode;
		}

		public void setPolygonMode(boolean polygonMode) {
			this.polygonMode = polygonMode;
		}

		public VAO getVao() {
			return vao;
		}

		public void setVao(VAO vao) {
			this.vao = vao;
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
		
		
}
