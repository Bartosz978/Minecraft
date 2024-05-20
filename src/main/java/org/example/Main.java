package org.example;

import org.example.graphics.Mesh;
import org.example.graphics.Renderer;
import org.example.graphics.Vertex;
import org.example.materials.Material;
import org.example.math.Vector2f;
import org.example.math.Vector3f;
import org.example.object.Camera;
import org.example.object.GameObject;
import org.example.graphics.Shader;
import org.lwjgl.glfw.GLFW;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.ARBVertexArrayObject.glGenVertexArrays;
import static org.lwjgl.opengles.GLES20.glClear;
import static org.lwjgl.opengles.GLES20.glEnable;
import static org.newdawn.slick.opengl.renderer.SGL.*;

public class Main {
    Shader shaders = new Shader("C:\\Users\\User\\Desktop\\Minecraft\\resources\\shaders\\mainVertex.glsl", "C:\\Users\\User\\Desktop\\Minecraft\\resources\\shaders\\mainFragment.glsl");
    public GameObject[] objects = new GameObject[10000];

    public Mesh mesh = new Mesh(new Vertex[] {
            //Back face
            new Vertex(new Vector3f(-0.5f,  0.5f, -0.5f), new Vector2f(0.0f, 0.0f)),
            new Vertex(new Vector3f(-0.5f, -0.5f, -0.5f), new Vector2f(0.0f, 1.0f)),
            new Vertex(new Vector3f( 0.5f, -0.5f, -0.5f), new Vector2f(1.0f, 1.0f)),
            new Vertex(new Vector3f( 0.5f,  0.5f, -0.5f), new Vector2f(1.0f, 0.0f)),

            //Front face
            new Vertex(new Vector3f(-0.5f,  0.5f,  0.5f), new Vector2f(0.0f, 0.0f)),
            new Vertex(new Vector3f(-0.5f, -0.5f,  0.5f), new Vector2f(0.0f, 1.0f)),
            new Vertex(new Vector3f( 0.5f, -0.5f,  0.5f), new Vector2f(1.0f, 1.0f)),
            new Vertex(new Vector3f( 0.5f,  0.5f,  0.5f), new Vector2f(1.0f, 0.0f)),

            //Right face
            new Vertex(new Vector3f( 0.5f,  0.5f, -0.5f), new Vector2f(0.0f, 0.0f)),
            new Vertex(new Vector3f( 0.5f, -0.5f, -0.5f), new Vector2f(0.0f, 1.0f)),
            new Vertex(new Vector3f( 0.5f, -0.5f,  0.5f), new Vector2f(1.0f, 1.0f)),
            new Vertex(new Vector3f( 0.5f,  0.5f,  0.5f), new Vector2f(1.0f, 0.0f)),

            //Left face
            new Vertex(new Vector3f(-0.5f,  0.5f, -0.5f), new Vector2f(0.0f, 0.0f)),
            new Vertex(new Vector3f(-0.5f, -0.5f, -0.5f), new Vector2f(0.0f, 1.0f)),
            new Vertex(new Vector3f(-0.5f, -0.5f,  0.5f), new Vector2f(1.0f, 1.0f)),
            new Vertex(new Vector3f(-0.5f,  0.5f,  0.5f), new Vector2f(1.0f, 0.0f)),

            //Top face
            new Vertex(new Vector3f(-0.5f,  0.5f,  0.5f), new Vector2f(0.0f, 0.0f)),
            new Vertex(new Vector3f(-0.5f,  0.5f, -0.5f), new Vector2f(0.0f, 1.0f)),
            new Vertex(new Vector3f( 0.5f,  0.5f, -0.5f), new Vector2f(1.0f, 1.0f)),
            new Vertex(new Vector3f( 0.5f,  0.5f,  0.5f), new Vector2f(1.0f, 0.0f)),

            //Bottom face
            new Vertex(new Vector3f(-0.5f, -0.5f,  0.5f), new Vector2f(0.0f, 0.0f)),
            new Vertex(new Vector3f(-0.5f, -0.5f, -0.5f), new Vector2f(0.0f, 1.0f)),
            new Vertex(new Vector3f( 0.5f, -0.5f, -0.5f), new Vector2f(1.0f, 1.0f)),
            new Vertex(new Vector3f( 0.5f, -0.5f,  0.5f), new Vector2f(1.0f, 0.0f)),
    }, new int[] {
            //Back face
            0, 1, 3,
            3, 1, 2,

            //Front face
            4, 5, 7,
            7, 5, 6,

            //Right face
            8, 9, 11,
            11, 9, 10,

            //Left face
            12, 13, 15,
            15, 13, 14,

            //Top face
            16, 17, 19,
            19, 17, 18,

            //Bottom face
            20, 21, 23,
            23, 21, 22
    }, new Material("C:\\Users\\User\\Desktop\\Minecraft\\resources\\texture\\stone.png"));

    public GameObject object = new GameObject(new Vector3f(0, 0, 0), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), mesh);

    public Camera camera = new Camera(new Vector3f(0, 0, 1f), new Vector3f(0, 0, 0));
    public Renderer renderer;
    Window window = new Window(1280, 1800, "Nasza gra");

    public void run() {
        renderer = new Renderer(shaders, window);
        window.setBackgorung(0, 10, 10);
        window.create();
        mesh.create();
        shaders.create();

        int gridSize = 100;
        // Tworzenie obiektów w płaskiej siatce
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                // Obliczanie indeksu w tablicy
                int index = i * gridSize + j;
                // Tworzenie obiektu w pozycji (x, y, z) = (50*i, 0, 50*j)
                objects[index] = new GameObject(new Vector3f(1 * i, 0, 1 * j), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), mesh);
            }
        }

        while (!window.Close()) {
            update();
            render();
            if (Input.isKeyDown(GLFW_KEY_ESCAPE))
                return;

            if (Input.isButtonDown(GLFW_MOUSE_BUTTON_LEFT)) window.mouseState(true);
        }
    }

    private void render() {

        for (GameObject obj : objects) {
            if (obj != null) {
                renderer.renderMesh(obj, camera);
            }
        }
        renderer.renderMesh(object, camera);
        window.swapBuffer();
    }

    private void update() {
        window.update();
        camera.update();
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
