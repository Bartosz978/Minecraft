package org.example;

import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import java.nio.*;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.ARBVertexArrayObject.glBindVertexArray;
import static org.lwjgl.opengl.ARBVertexArrayObject.glGenVertexArrays;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

public class Main {
public void run(){
    Window window = new Window(800,800,"DUPA");
    window.init();
    window.create();
    window.setBackgorung(0,1,0);
    while (!window.Close()){
        window.update();
        window.swapBuffer();
        if(Input.isKeyDown(GLFW_KEY_ENTER)){
            System.out.println("tak");
        }
        if(Input.isKeyDown(GLFW_KEY_ESCAPE))
            return;


    }
}

    public static void main(String[] args) {
        new Main().run();
    }

}