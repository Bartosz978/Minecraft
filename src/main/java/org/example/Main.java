package org.example;

import org.example.graphics.Mesh;
import org.example.graphics.Renderer;
import org.example.graphics.Vertex;
import org.example.math.Vector3f;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.ARBVertexArrayObject.glGenVertexArrays;

public class Main {

    public Mesh mesh = new Mesh(new Vertex[] {
            new Vertex(new Vector3f(-0.5f,  0.5f, 0.0f)),
            new Vertex(new Vector3f(-0.5f, -0.5f, 0.0f)),
            new Vertex(new Vector3f( 0.5f, -0.5f, 0.0f)),
            new Vertex(new Vector3f( 0.5f,  0.5f, 0.0f))
    }, new int[] {
            0, 1, 2,
            0, 3, 2
    });
    public Renderer renderer ;
    Window window = new Window(800,800,"DUPA");
    private void render() {
        renderer.renderMesh(mesh);
        window.swapBuffer();
    }
public void run(){
    renderer = new Renderer();
    window.init();
    window.create();
    window.setBackgorung(0,1,0
    );
    while (!window.Close()){
        window.update();
        render();
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