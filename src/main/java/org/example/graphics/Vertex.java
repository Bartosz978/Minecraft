package org.example.graphics;


import org.example.math.Vector2f;
import org.example.math.Vector3f;


public class Vertex {
    private Vector3f position,color;
    private Vector2f positionTexture;



    public Vertex(Vector3f position,Vector2f positionTexture) {
        this.position = position;
     //   this.color = color;
        this.positionTexture = positionTexture;
    }
    public Vector2f getPositionTexture() {
        return positionTexture;
    }
    public Vector3f getPosition() {
        return position;
    }

    public Vector3f getColor() {
        return color;
    }

}