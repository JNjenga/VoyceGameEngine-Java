package model.modelLoader;

import static org.lwjgl.assimp.Assimp.*;

import java.nio.*;
import java.util.*;

import org.joml.*;
import org.lwjgl.*;
import org.lwjgl.assimp.*;

import model.*;
import texture.*;
import utility.*;


public class ModelLoader {
	
	private static ModelLoader INSTANCE;

	
	public static synchronized ModelLoader getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new ModelLoader();
		}
		
		return INSTANCE;
	}
	
	
	 public Model  load(String modelName, String textureDir) {
		 return new Model(load (modelName,"/res/models",aiProcess_JoinIdenticalVertices | aiProcess_Triangulate | aiProcess_FixInfacingNormals));
	 }

	 
	private Mesh[] load(String modelName, String textureDir, int flags) {
 		
		
		//Load model with selected flags
		AIScene aiScene = aiImportFile("tests/res/models/lamb.obj", flags);
		if (aiScene == null) {
			BugTracker.LOG("ERROR", "Error while loading model");
		}
		
		int numMaterials = aiScene.mNumMaterials();
		PointerBuffer aiMaterials = aiScene.mMaterials();
		List<Material> materials = new ArrayList<>();
		
		for (int i = 0; i < numMaterials; i++) {
			AIMaterial aiMaterial = AIMaterial.create(aiMaterials.get(i));
			processMaterial(aiMaterial,materials,textureDir);
		}
		
		int numMeshes = aiScene.mNumMeshes();
		PointerBuffer aiMeshes = aiScene.mMeshes();
		Mesh[] meshes = new Mesh[numMeshes];
		
		for (int i = 0; i < numMeshes; i++) {
			AIMesh aiMesh = AIMesh.create(aiMeshes.get(i));
			Mesh mesh = processMesh(aiMesh,materials);
			meshes[i] = mesh;
			
		}
		
		return meshes;
	}


	private Mesh processMesh(AIMesh aiMesh, List<Material> materials) {
		List<Float> vertices = new ArrayList<>();
        List<Float> textures = new ArrayList<>();
        List<Float> normals = new ArrayList<>();
        List<Integer> indices = new ArrayList<>();

        processVertices(aiMesh, vertices);
        processNormals(aiMesh, normals);
        processTextCoords(aiMesh, textures);
        processIndices(aiMesh, indices);

        Mesh vaos = new Mesh(Utility.listToArray(vertices),
        		Utility.listIntToArray(indices),
        		Utility.listToArray(textures),
        		Utility.listToArray(normals)
        );
        Material material;
        int materialIdx = aiMesh.mMaterialIndex();
        if (materialIdx >= 0 || materialIdx < materials.size()) {
            material = materials.get(materialIdx);
        } else {
            material = new Material();
        }
//        vaos.setMaterial(material);

        return vaos;
 	}


	protected static void processIndices(AIMesh aiMesh, List<Integer> indices) {
		int numFaces = aiMesh.mNumFaces();
        AIFace.Buffer aiFaces = aiMesh.mFaces();
        for (int i = 0; i < numFaces; i++) {
            AIFace aiFace = aiFaces.get(i);
            IntBuffer buffer = aiFace.mIndices();
            while (buffer.remaining() > 0) {
                indices.add(buffer.get());
            }
        }		
	}

	protected static void processTextCoords(AIMesh aiMesh, List<Float> textures) {
        AIVector3D.Buffer textCoords = aiMesh.mTextureCoords(0);
        int numTextCoords = textCoords != null ? textCoords.remaining() : 0;
        for (int i = 0; i < numTextCoords; i++) {
            AIVector3D textCoord = textCoords.get();
            textures.add(textCoord.x());
            textures.add(1 - textCoord.y());
        }		
	}

	protected static void processNormals(AIMesh aiMesh, List<Float> normals) {
		  AIVector3D.Buffer aiNormals = aiMesh.mNormals();
	        while (aiNormals != null && aiNormals.remaining() > 0) {
	            AIVector3D aiNormal = aiNormals.get();
	            normals.add(aiNormal.x());
	            normals.add(aiNormal.y());
	            normals.add(aiNormal.z());
	        }		
	}

	protected static void processVertices(AIMesh aiMesh, List<Float> vertices) {
	    AIVector3D.Buffer aiVertices = aiMesh.mVertices();
        while (aiVertices.remaining() > 0) {
            AIVector3D aiVertex = aiVertices.get();
            vertices.add(aiVertex.x());
            vertices.add(aiVertex.y());
            vertices.add(aiVertex.z());
        }		
	}
	private void processMaterial(AIMaterial aiMaterial, List<Material> materials, String textureDir) {
		AIColor4D color = AIColor4D.create();
		AIString path = AIString.calloc();
		
		//	Loading Materails
		aiGetMaterialTexture(aiMaterial, aiTextureType_DIFFUSE, 0, path,(IntBuffer) null, null, null, null, null, null);
		
		String texturePath = path.dataString();
		
		Texture texture = null;
		
		if (texturePath != null && texturePath.length() > 0) {
			ResourceManager.getInstance().getTexture( texturePath);
			
		}
		
		Vector4f ambient = Material.DEFAULT_COLOUR;
        int result = aiGetMaterialColor(aiMaterial, AI_MATKEY_COLOR_AMBIENT, aiTextureType_NONE, 0, color);
        if (result == 0) {
            ambient = new Vector4f(color.r(), color.g(), color.b(), color.a());
        }

        Vector4f diffuse = Material.DEFAULT_COLOUR;
        result = aiGetMaterialColor(aiMaterial, AI_MATKEY_COLOR_DIFFUSE, aiTextureType_NONE, 0, color);
        if (result == 0) {
            diffuse = new Vector4f(color.r(), color.g(), color.b(), color.a());
        }

        Vector4f specular = Material.DEFAULT_COLOUR;
        result = aiGetMaterialColor(aiMaterial, AI_MATKEY_COLOR_SPECULAR, aiTextureType_NONE, 0, color);
        if (result == 0) {
            specular = new Vector4f(color.r(), color.g(), color.b(), color.a());
        }
        Material material = new Material(ambient, diffuse, specular, 1.0f);
	        material.setTexture(texture);
        materials.add(material);
		
	}
}
