package texture;

import java.util.*;

import utility.*;

 
public class TextureCache {
	
	private final String RES_PATH = "/res/textures/";

	
	private static TextureCache INSTANCE;
	
    private Map<String, Texture> textureMap;
    
    private TextureCache() {
    	textureMap = new HashMap<String, Texture>();
    	
    }
    public static synchronized TextureCache getInstance() {
        if ( INSTANCE == null ) {
            INSTANCE = new TextureCache();
        }
        return INSTANCE;
    }
    
    @SuppressWarnings("unused")
	public Texture getTexture(String textureName) {
    	Texture texture = textureMap.get(textureName);
        if ( texture == null ) {
        	BugTracker.LOG("EVENT", "Texture :: Loading Texture '"+textureName+"'");
            texture = Texture.loadTexture(RES_PATH+textureName);
            
 				
            	textureMap.put(textureName, texture);
            	BugTracker.LOG("SUCCESS", "Texture :: Texture '"+textureName+"' loaded successfully ");
			 

        }
//        System.out.println(textureName + texture);
        return texture;
    }

}