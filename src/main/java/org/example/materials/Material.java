package org.example.materials;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Material {
    private Texture texture;

    public Material(String File) {
        try{
            texture = TextureLoader.getTexture(File.split("[.]")[1],Material.class.getResourceAsStream(File), GL11.GL_LINEAR);
        }catch (Exception e){
            e.getMessage();
        }


    }



}
