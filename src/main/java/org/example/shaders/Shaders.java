package org.example.shaders;

import org.example.utils.FileUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

public abstract class Shaders {
    private int vertexID,fragmentID,programID;
    private String vertexFile,fragmentFile;
    Shaders(String vertexpath,String fragmentpath){
    this.vertexFile = FileUtils.LoadString(vertexpath);
    this.fragmentFile = FileUtils.LoadString(fragmentpath);

    }
    public void create(){
        programID = GL20.glCreateProgram();
        vertexID = GL20.glCreateShader(GL20.GL_VERTEX_SHADER);

        GL20.glShaderSource(vertexID, vertexFile);
        GL20.glCompileShader(vertexID);

        if (GL20.glGetShaderi(vertexID, GL20.GL_COMPILE_STATUS) == GL11.GL_FALSE) {
            System.err.println("Vertex Shader: " + GL20.glGetShaderInfoLog(vertexID));
            return;
        }

        fragmentID = GL20.glCreateShader(GL20.GL_FRAGMENT_SHADER);

        GL20.glShaderSource(fragmentID, fragmentFile);
        GL20.glCompileShader(fragmentID);

        if (GL20.glGetShaderi(fragmentID, GL20.GL_COMPILE_STATUS) == GL11.GL_FALSE) {
            System.err.println("Fragment Shader: " + GL20.glGetShaderInfoLog(fragmentID));
            return;
        }

        GL20.glAttachShader(programID, vertexID);
        GL20.glAttachShader(programID, fragmentID);

        GL20.glLinkProgram(programID);
        if (GL20.glGetProgrami(programID, GL20.GL_LINK_STATUS) == GL11.GL_FALSE) {
            System.err.println("Program Linking: " + GL20.glGetProgramInfoLog(programID));
            return;
        }

        GL20.glValidateProgram(programID);
        if (GL20.glGetProgrami(programID, GL20.GL_VALIDATE_STATUS) == GL11.GL_FALSE) {
            System.err.println("Program Validation: " + GL20.glGetProgramInfoLog(programID));
            return;
        }

        GL20.glDeleteShader(vertexID);
        GL20.glDeleteShader(programID);

    }
    public  void blind(){
        GL20.glUseProgram(programID);
    }
    public void unbind(){
        GL20.glUseProgram(0);
    }
    public void Delete(){
        GL20.glDeleteProgram(programID);
    }
}
