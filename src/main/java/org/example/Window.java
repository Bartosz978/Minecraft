package org.example;

import org.example.math.Matrix4f;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

public class Window {
    private int heigtt;
    private int width;
    private String tittle;
    private long winndow;
    Input input;
    private float backgroundR,backgroundG,backgroundB;
    private Matrix4f projection;

    public Window(int heigtt, int weight, String tittle) {
        this.heigtt = heigtt;
        this.width = weight;
        this.tittle = tittle;
        projection = Matrix4f.projection(70.0f, (float) width / (float) heigtt, 0.1f, 1000.0f);
    }

    public void create(){
        GLFW.glfwInit();
        input = new Input();
     winndow =    GLFW.glfwCreateWindow(width,heigtt,tittle,0,0);
        GLFWVidMode glfwVidMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
        GLFW.glfwMakeContextCurrent(winndow);
        GL.createCapabilities();
        GLFW.glfwSetKeyCallback(winndow,input.getKeyboardCallback());
        GLFW.glfwSetMouseButtonCallback(winndow,input.getMouseButtonsCallback());
        GLFW.glfwSetCursorPosCallback(winndow,input.getMouseMoveCallback());
        GLFW.glfwShowWindow(winndow);
    }
    public void update(){
        GL11.glClearColor(backgroundR,backgroundG,backgroundB,1.0f);
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
        GLFW.glfwPollEvents();
    }
    public void swapBuffer(){
        GLFW.glfwSwapBuffers(winndow);
    }
    public boolean Close(){
       return GLFW.glfwWindowShouldClose(winndow);

    }
    public void destroy(){
        input.destroy();
    }
    public void setBackgorung(float r,float g,float b){
        this.backgroundR = r;
        this.backgroundG = g;
        this.backgroundB = b;
    }
    public void mouseState(boolean lock) {
        GLFW.glfwSetInputMode(winndow, GLFW.GLFW_CURSOR, lock ? GLFW.GLFW_CURSOR_DISABLED : GLFW.GLFW_CURSOR_NORMAL);
    }
    public Matrix4f getProjection() {
        return projection;
    }
}
