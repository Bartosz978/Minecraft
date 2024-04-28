package org.example.materials;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import java.io.IOException;

public class Material {
    private Texture texture;
    private float width,height;
    private int TextureID;

    public Material(String File) {
        try{
            texture = TextureLoader.getTexture(File.split("[.]")[1],Material.class.getResourceAsStream(File), GL11.GL_LINEAR);
        }catch (IOException e){
            e.getMessage();
        }


    }
    public void create(){
        width = texture.getWidth();
        height = texture.getHeight();
        TextureID = texture.getTextureID();

    }
    public void destroy(){
        GL13.glDeleteTextures(TextureID);
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public int getTextureID() {
        return TextureID;
    }
}
