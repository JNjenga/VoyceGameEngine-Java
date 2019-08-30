package model;

import org.joml.*;

import texture.*;
import utility.*;

public class Material {

    public static final Vector4f DEFAULT_COLOUR = new Vector4f(1.0f, 1.0f, 1.0f, 1.0f);
 
    @SuppressWarnings("unused")
	private Texture texture;

	private String textureName;
    
    public Material() {
        this.texture = null;
    }

    public Material(String textureName) {
        this.textureName = textureName;
    }
 
 

    public boolean isTextured() {
        return this.textureName != null;
    }

    public Texture getTexture() {
        return ResourceManager.getInstance().getTexture(textureName);
    }

    public void setTexture(String texture) {
        this.texture = ResourceManager.getInstance().getTexture(texture);
    }
    
    public void updateUniforms(String shaderName) {
     }
    
}