package org.example.generate;

import org.example.graphics.Mesh;
import org.example.graphics.Renderer;
import org.example.math.Vector3f;
import org.example.object.Camera;
import org.example.object.GameObject;

import java.util.HashMap;

public class Generate_World {
    int Test = 1000;
    private int box = 15;
    private int X, Y, Z;
    private int Ymapy=40;
    private Mesh mesh;

    public static HashMap<Integer, HashMap<Integer, HashMap<Integer, GameObject>>> flat_WordX = new HashMap<>();

    public Generate_World(int x, int y, int z, Mesh mesh) {

        this.mesh = mesh;
        X = x;
        Y = y;
        Z = z;

        for (int i = -Test / 2; i < Test / 2; i++) {
            HashMap<Integer, HashMap<Integer, GameObject>> flat_wordZ = new HashMap<>();
            for (int j = -Test / 2; j < Test / 2; j++) {
                HashMap<Integer, GameObject> flat_wordY = new HashMap<>();
                for (int g = 0; g < Ymapy; g++) {
                    if(g==0){
                        GameObject gameObject = new GameObject(new Vector3f(j, 0, i), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), mesh);
                        flat_wordY.put(g, gameObject);

                    }
                }
                flat_wordZ.put(j, flat_wordY);
            }
            flat_WordX.put(i, flat_wordZ);
        }
    }


    public void Generate_new_space(Renderer renderer, Camera camera) {
        int actualX = (int) camera.getPosition().getX();
        int actualY = (int) camera.getPosition().getZ();
        int actualyZ = (int)camera.getPosition().getY();
        for (int i = actualY - box; i < actualY + box; i++) {
            HashMap<Integer, HashMap<Integer,GameObject>> innerMap = flat_WordX.get(i);
            if (innerMap != null) {
                for (int j = actualX - box; j < actualX + box; j++) {
                    HashMap<Integer,GameObject> gameObject = innerMap.get(j);
                    if (gameObject != null) {

                        for(int g = actualyZ - box; g < actualyZ + box; g++){
                            GameObject gameObject1 = gameObject.get(g);
                            if(gameObject1 != null){
                                renderer.renderMesh(gameObject1, camera);
                            }
                        }
                    }
                }
            }
        }
    }





    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public int getZ() {
        return Z;
    }

    public void setZ(int z) {
        Z = z;
    }


    public void render_space() {

    }

}



