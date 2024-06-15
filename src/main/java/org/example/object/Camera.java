package org.example.object;

import org.example.IO.Input;

import org.example.Main;
import org.example.Texture.BLOCK;
import org.example.Texture.Texture;
import org.example.generate.Colison;
import org.example.generate.Generate_World;
import org.example.math.Vector3f;
import org.lwjgl.glfw.GLFW;

public class Camera {
    public  Vector3f position, rotation;
    private float distanceBlock = 0.2f;
    private float moveSpeed = 0.1f, mouseSensitivity = 0.15f, distance = 2.0f, horizontalAngle = 0, verticalAngle = 0;
    public   static double oldMouseX = 0, oldMouseY = 0, newMouseX, newMouseY;

    public Camera(Vector3f position, Vector3f rotation) {
        this.position = position;
        this.rotation = rotation;
    }

    public void update() {
        newMouseX = Input.getMouseX();
        newMouseY = Input.getMouseY();

        float x = (float) Math.sin(Math.toRadians(rotation.getY())) * moveSpeed;
        float z = (float) Math.cos(Math.toRadians(rotation.getY())) * moveSpeed;



        if (Input.isKeyDown(GLFW.GLFW_KEY_A)){
            Vector3f newposition = new Vector3f(position.getX()-z,position.getY(),position.getZ()+x);
           if(Colison.changeCollision(newposition,position )){
                position = Vector3f.add(position, new Vector3f(-z, 0, x));

           }

        }
        if (Input.isKeyDown(GLFW.GLFW_KEY_D)){
            Vector3f newposition = new Vector3f(position.getX()+z,position.getY(),position.getZ()-x);
            if(Colison.changeCollision(newposition, position)){
                position = Vector3f.add(position, new Vector3f(z, 0, -x));
            }


        }
        if (Input.isKeyDown(GLFW.GLFW_KEY_W)){
            Vector3f newposition = new Vector3f(position.getX()-x,position.getY(),position.getZ()-z);
        if(Colison.changeCollision(newposition, position)){
                position = Vector3f.add(position, new Vector3f(-x, 0, -z));
          }


        }
        if (Input.isKeyDown(GLFW.GLFW_KEY_S)){
            Vector3f newposition = new Vector3f(position.getX()+x,position.getY(),position.getZ()+z);
            if(Colison.changeCollision(newposition, position)){
                position = Vector3f.add(position, new Vector3f(x, 0, z));

        }

        }
        if (Input.isKeyDown(GLFW.GLFW_KEY_SPACE)){
            Vector3f newposition = new Vector3f(position.getX(),position.getY()+moveSpeed+distanceBlock,position.getZ());
            if(Colison.changeCollision(newposition, position)){
                position = Vector3f.add(position, new Vector3f(0, moveSpeed, 0));
           }



        }
        if (Input.isKeyDown(GLFW.GLFW_KEY_LEFT_SHIFT)){
            Vector3f newposition = new Vector3f(position.getX(),position.getY()-moveSpeed-distanceBlock,position.getZ());
            if(Colison.changeCollision(newposition,position )){
                position = Vector3f.add(position, new Vector3f(0, -moveSpeed, 0));}

        }

        if (Input.isButtonDown(GLFW.GLFW_MOUSE_BUTTON_RIGHT)){
            int newX = (int) (position.getX());
            int newY = (int)    (position.getY());
            int newZ = (int) (position.getZ());

           Generate_World.flat_WordX.get(newX+1).get(newZ).put(newY,new GameObject(new Vector3f(newX+1, newY, newZ), new Vector3f(0f, 0f, 0f), new Vector3f(1f, 1f, 1f), Texture.returnMesh(BLOCK.WOOD)));
        }


        float dx = (float) (newMouseX - oldMouseX);
        float dy = (float) (newMouseY - oldMouseY);

        rotation = Vector3f.add(rotation, new Vector3f(-dy * mouseSensitivity, -dx * mouseSensitivity, 0));

        oldMouseX = newMouseX;
        oldMouseY = newMouseY;
    }



    public Vector3f getPosition() {
        return position;
    }

    public Vector3f getRotation() {
        return rotation;
    }
}


/**
 *  public void update(GameObject object) {
 *         newMouseX = Input.getMouseX();
 *         newMouseY = Input.getMouseY();
 *
 *         float dx = (float) (newMouseX - oldMouseX);
 *         float dy = (float) (newMouseY - oldMouseY);
 *
 *         if (Input.isButtonDown(GLFW.GLFW_MOUSE_BUTTON_LEFT)) {
 *             verticalAngle -= dy * mouseSensitivity;
 *             horizontalAngle += dx * mouseSensitivity;
 *         }
 *         if (Input.isButtonDown(GLFW.GLFW_MOUSE_BUTTON_RIGHT)) {
 *             if (distance > 0) {
 *                 distance += dy * mouseSensitivity / 4;
 *             } else {
 *                 distance = 0.1f;
 *             }
 *         }
 *
 *         float horizontalDistance = (float) (distance * Math.cos(Math.toRadians(verticalAngle)));
 *         float verticalDistance = (float) (distance * Math.sin(Math.toRadians(verticalAngle)));
 *
 *         float xOffset = (float) (horizontalDistance * Math.sin(Math.toRadians(-horizontalAngle)));
 *         float zOffset = (float) (horizontalDistance * Math.cos(Math.toRadians(-horizontalAngle)));
 *
 *         position.set(object.getPosition().getX() + xOffset, object.getPosition().getY() - verticalDistance, object.getPosition().getZ() + zOffset);
 *
 *         rotation.set(verticalAngle, -horizontalAngle, 0);
 *
 *         oldMouseX = newMouseX;
 *         oldMouseY = newMouseY;
 *     }
 *
 *
 *
 *
 *         public  Vector3f getCameraDirection() {
 *         float pitch = (float) Math.toRadians(rotation.getX());
 *         float yaw = (float) Math.toRadians(rotation.getY());
 *
 *         Vector3f direction = new Vector3f(0,0,0);
 *         direction.setX((float) (Math.cos(pitch) * Math.sin(yaw)));
 *         direction.setY((float) Math.sin(pitch));
 *         direction.setZ((float) (Math.cos(pitch) * Math.cos(yaw)));
 *         return direction;
 *     }
 *
 */