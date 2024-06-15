package org.example;

import org.example.IO.Input;
import org.example.Texture.Texture;
import org.example.generate.Generate_World;
import org.example.graphics.Mesh;
import org.example.graphics.Renderer;
import org.example.graphics.Vertex;
import org.example.materials.Material;
import org.example.math.Vector2f;
import org.example.math.Vector3f;
import org.example.object.Camera;
import org.example.object.GameObject;
import org.example.graphics.Shader;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.ARBVertexArrayObject.glGenVertexArrays;

public class Main {    Shader shaders = new Shader("C:\\Users\\User\\Desktop\\Minecraft\\resources\\shaders\\mainVertex.glsl", "C:\\Users\\User\\Desktop\\Minecraft\\resources\\shaders\\mainFragment.glsl");



    public Camera camera = new Camera(new Vector3f(10000, 32, 10000f), new Vector3f(0, 0, 0));
    public Renderer renderer;
    Generate_World generateWorld = new Generate_World((int)camera.getPosition().getX(),(int)camera.getPosition().getY(),(int)camera.getPosition().getZ());
    Window window = new Window(1600, 700, "Minecraft");

    public void run() {


        renderer = new Renderer(shaders, window);
        window.setBackgroundColor(0.53f , 0.81f, 0.98f);
        window.create();
       Texture.InitAlltexture();

        shaders.create();

        while (!window.shouldClose()) {
            update();
            render();

            if (Input.isKeyDown(GLFW_KEY_ESCAPE))
                return;

            if (Input.isButtonDown(GLFW_MOUSE_BUTTON_LEFT)) window.mouseState(true);
        }
    }

    private void render() {
        generateWorld.Generate_new_space(renderer,camera);

        window.swapBuffers();

    }

    private void update() {
        window.update(camera);
        camera.update();
    }

    public static void main(String[] args) {
        new Main().run();
    }


}
/**
 *  public  static Mesh mesh2 = new Mesh(new Vertex[]{
 *             //Back face
 *             new Vertex(new Vector3f(-0.5f, 0.5f, -0.5f), new Vector2f(0.75f, 0.25f)),
 *             new Vertex(new Vector3f(-0.5f, -0.5f, -0.5f), new Vector2f(0.75f, 0.5f)),
 *             new Vertex(new Vector3f(0.5f, -0.5f, -0.5f), new Vector2f(1.0f, 0.5f)),
 *             new Vertex(new Vector3f(0.5f, 0.5f, -0.5f), new Vector2f(1.0f, 0.25f)),
 *
 *             //Front face
 *             new Vertex(new Vector3f(-0.5f, 0.5f, 0.5f), new Vector2f(0.0f, 0.0f)),
 *             new Vertex(new Vector3f(-0.5f, -0.5f, 0.5f), new Vector2f(0.0f, 1.0f)),
 *             new Vertex(new Vector3f(0.5f, -0.5f, 0.5f), new Vector2f(1.0f, 1.0f)),
 *             new Vertex(new Vector3f(0.5f, 0.5f, 0.5f), new Vector2f(1.0f, 0.0f)),
 *
 *             //Right face
 *             new Vertex(new Vector3f(0.5f, 0.5f, -0.5f), new Vector2f(0.0f, 0.0f)),
 *             new Vertex(new Vector3f(0.5f, -0.5f, -0.5f), new Vector2f(0.0f, 1.0f)),
 *             new Vertex(new Vector3f(0.5f, -0.5f, 0.5f), new Vector2f(1.0f, 1.0f)),
 *             new Vertex(new Vector3f(0.5f, 0.5f, 0.5f), new Vector2f(1.0f, 0.0f)),
 *
 *             //Left face
 *             new Vertex(new Vector3f(-0.5f, 0.5f, -0.5f), new Vector2f(0.0f, 0.0f)),
 *             new Vertex(new Vector3f(-0.5f, -0.5f, -0.5f), new Vector2f(0.0f, 1.0f)),
 *             new Vertex(new Vector3f(-0.5f, -0.5f, 0.5f), new Vector2f(1.0f, 1.0f)),
 *             new Vertex(new Vector3f(-0.5f, 0.5f, 0.5f), new Vector2f(1.0f, 0.0f)),
 *
 *             //Top face
 *             new Vertex(new Vector3f(-0.5f, 0.5f, 0.5f), new Vector2f(0.6666f, 0.0f)),
 *             new Vertex(new Vector3f(-0.5f, 0.5f, -0.5f), new Vector2f(0.6666f, 1.0f)),
 *             new Vertex(new Vector3f(0.5f, 0.5f, -0.5f), new Vector2f(1.0f, 1.0f)),
 *             new Vertex(new Vector3f(0.5f, 0.5f, 0.5f), new Vector2f(1.0f, 0.0f)),
 *
 *             //Bottom face
 *             new Vertex(new Vector3f(-0.5f, -0.5f, 0.5f), new Vector2f(0.0f, 0.0f)),
 *             new Vertex(new Vector3f(-0.5f, -0.5f, -0.5f), new Vector2f(0.0f, 1.0f)),
 *             new Vertex(new Vector3f(0.5f, -0.5f, -0.5f), new Vector2f(1.0f, 1.0f)),
 *             new Vertex(new Vector3f(0.5f, -0.5f, 0.5f), new Vector2f(1.0f, 0.0f)),
 *     }, new int[]{
 *             //Back face
 *             0, 1, 3,
 *             3, 1, 2,
 *
 *             //Front face
 *             4, 5, 7,
 *             7, 5, 6,
 *
 *             //Right face
 *             8, 9, 11,
 *             11, 9, 10,
 *
 *             //Left face
 *             12, 13, 15,
 *             15, 13, 14,
 *
 *             //Top face
 *             16, 17, 19,
 *             19, 17, 18,
 *
 *             //Bottom face
 *             20, 21, 23,
 *             23, 21, 22
 *     }, new Material("C:\\Users\\User\\Desktop\\Minecraft\\resources\\texture\\t2.png"));
 */