package org.example;

import org.example.graphics.Mesh;
import org.example.graphics.Renderer;
import org.example.graphics.Vertex;
import org.example.math.Vector3f;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.ARBVertexArrayObject.glGenVertexArrays;

public class Main {

    public Mesh mesh = new Mesh(new Vertex[] {
            new Vertex(new Vector3f(-0.5f,  0.5f, -0.9f)),
            new Vertex(new Vector3f(-0.5f, -0.5f, 0.0f)),
            new Vertex(new Vector3f( 0.5f, -0.5f, 0.0f)),
            new Vertex(new Vector3f( 0.5f,  0.5f, 0.0f))
    }, new int[] {
            0, 1, 2,
            0, 3, 2
    });
    public Mesh mesh1 = new Mesh(new Vertex[] {
            new Vertex(new Vector3f(-0.9f,  0.9f, -0.9f)),
            new Vertex(new Vector3f(-0.6f, -0.6f, 0.0f)),
            new Vertex(new Vector3f( -0.7f, -0.9f, 0.0f)),
            new Vertex(new Vector3f( -0.5f,  -0.5f, 0.0f))
    }, new int[] {
            0, 1, 2,
            0, 3, 2
    });
    public Renderer renderer ;
    Window window = new Window(800,800,"DUPA");

public void run(){
    renderer = new Renderer();
    window.setBackgorung(1,0,0
    );
    window.create();
    mesh.create();
    mesh1.create();

    while (!window.Close()){
        window.update();
        render();

        if(Input.isKeyDown(GLFW_KEY_ENTER)){
            System.out.println("tak");
        }
        if(Input.isKeyDown(GLFW_KEY_ESCAPE))
            return;


    }
}
    private void render() {
        renderer.renderMesh(mesh);
        renderer.renderMesh(mesh1);
        window.swapBuffer();

    }
    public static void main(String[] args) {
        new Main().run();
    }

}