package shader;

import java.util.*;

import utility.*;

 
public class ShaderCache {
	
	private final String RES_PATH = "/res/shaders/";
	private static ShaderCache INSTANCE;
	
    private Map<String, Shader> shaderMap;
    
    private ShaderCache() {
    	shaderMap = new HashMap<String, Shader>();
    	
    }
    public static synchronized ShaderCache getInstance() {
        if ( INSTANCE == null ) {
            INSTANCE = new ShaderCache();
        }
        return INSTANCE;
    }
    
    public Shader getShader(String shaderName)   {
    	Shader shader = shaderMap.get(shaderName);
        if ( shader == null ) {
        	
        	BugTracker.LOG("EVENT", "SHADER :: Loading shader '"+shaderName+"'");
            shader = new Shader(RES_PATH+shaderName);
            shaderMap.put(shaderName, shader);
        	BugTracker.LOG("SUCCESS", "SHADER :: Shader '"+shaderName+"'loaded successfully ");

        	
        }
        return shader;
    }

}