package org.example;

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

    public Window(int heigtt, int weight, String tittle) {
        this.heigtt = heigtt;
        this.width = weight;
        this.tittle = tittle;
    }

    public void create(){
        GLFW.glfwInit();
        input = new Input();
     winndow =    GLFW.glfwCreateWindow(width,heigtt,tittle,0,0);
        GLFWVidMode glfwVidMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
        GLFW.glfwMakeContextCurrent(winndow);
        GL.createCapabilities();
        GLFW.glfwSetKeyCallback(winndow,input.getKeyboard());
        GLFW.glfwSetMouseButtonCallback(winndow,input.getMouseButton());
        GLFW.glfwSetCursorPosCallback(winndow,input.getMouseMove());
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
        input.delete();
    }
    public void setBackgorung(float r,float g,float b){
        this.backgroundR = r;
        this.backgroundG = g;
        this.backgroundB = b;
    }
}
