package org.example.graphics;


import org.example.math.Vector2f;
import org.example.math.Vector3f;


public class Vertex {
    private Vector3f position;
    private Vector2f positionTexture;



    public Vertex(Vector3f position) {
        this.position = position;
      //  this.positionTexture = positionTexture;
    }
    public Vector2f getPositionTexture() {
        return positionTexture;
    }
    public Vector3f getPosition() {
        return position;
    }
}