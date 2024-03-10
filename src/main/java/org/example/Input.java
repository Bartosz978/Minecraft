package org.example;

import org.lwjgl.glfw.*;

public class Input {
    private static boolean[] keys = new boolean[GLFW.GLFW_KEY_LAST];
    private static boolean[] buttons = new boolean[GLFW.GLFW_MOUSE_BUTTON_LAST];
    private GLFWKeyCallback keyboard;
    private GLFWMouseButtonCallback mouseButton;
    private GLFWCursorPosCallback  mouseMove;
    private static double moveX,moveY;

    public Input() {
        keyboard = new GLFWKeyCallback() {
            @Override
            public void invoke(long window, int key, int scancode, int actions, int moods) {
                    keys[key] = (actions != GLFW.GLFW_RELEASE);
            }
        };
        mouseMove = new GLFWCursorPosCallback() {
            @Override
            public void invoke(long window, double x, double Y) {
                moveX = x;
                moveY = Y;
            }
        };
        mouseButton = new GLFWMouseButtonCallback() {
            @Override
            public void invoke(long window, int button, int action, int mods) {
                buttons[button] = (action != GLFW.GLFW_RELEASE);
            }
        };
    }
    public static boolean isKeyDown(int key){
        return keys[key];
    }
    public static  boolean isButtonDown(int button){
        return buttons[button];
    }
    public void  delete(){
        keyboard.free();
        mouseButton.free();
        mouseMove.free();
    }
    public GLFWKeyCallback getKeyboard() {
        return keyboard;
    }



    public GLFWMouseButtonCallback getMouseButton() {
        return mouseButton;
    }



    public GLFWCursorPosCallback getMouseMove() {
        return mouseMove;
    }



    public static double getMoveX() {
        return moveX;
    }

    public static double getMoveY() {
        return moveY;
    }


}
