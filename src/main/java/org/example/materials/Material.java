package org.example.materials;


import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

<<<<<<< HEAD
=======
import java.io.IOException;
>>>>>>> 9a9917782dabc99c787fbb4acdf55f6a177255c3

public class Material {
    private Texture texture;
    private float width,height;
    private int TextureID;

    public Material(String File) {
        try{
<<<<<<< HEAD
        texture =TextureLoader.getTexture(File.split("[.]")[1],Material.class.getResourceAsStream(File), GL11.GL_LINEAR);
        }catch (Exception e){
=======
            texture = TextureLoader.getTexture(File.split("[.]")[1],Material.class.getResourceAsStream(File), GL11.GL_LINEAR);
        }catch (IOException e){
>>>>>>> 9a9917782dabc99c787fbb4acdf55f6a177255c3
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
