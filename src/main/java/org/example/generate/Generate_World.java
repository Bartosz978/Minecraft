package org.example.generate;

import org.example.Texture.BLOCK;
import org.example.Texture.Texture;
import org.example.graphics.Mesh;
import org.example.graphics.Renderer;
import org.example.math.Vector3f;
import org.example.object.Camera;
import org.example.object.GameObject;

import java.util.HashMap;
import java.util.Random;

public class Generate_World {
    /**
     * Perlin Noise wporzłrzedne
     */
    private  static  int Yfinal;
    private static final int offset = 123;
    private final double   increment = 0.05f;
        NoiseGenerator noiseGenerator = new NoiseGenerator(offset);
    private final int MaxHeight = 40;


    int Test = 10000;
    private  final int DistanceMap = 500;
    private int box = 15;
    private int X, Y, Z;
    private Mesh mesh;

    public static HashMap<Integer, HashMap<Integer, HashMap<Integer, GameObject>>> flat_WordX = new HashMap<>();


    public Generate_World(int x, int y, int z, Mesh mesh) {

        this.mesh = mesh;
        X = x;
        Y = y;
        Z = z;

        for (int i = Test - DistanceMap; i < Test + DistanceMap ; i++) {
            HashMap<Integer, HashMap<Integer, GameObject>> flat_wordZ = new HashMap<>();
            for (int j = Test - DistanceMap; j < Test  + DistanceMap; j++) {
                HashMap<Integer, GameObject> flat_wordY = new HashMap<>();
                for (int g = 0; g < MaxHeight; g++) {
                    GameObject gameObject;
                    if(g==0) {
                        Yfinal = NoiseHeightReturn(i,j);
                        gameObject = new GameObject(new Vector3f(i, Yfinal, j), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), Texture.returnMesh(BLOCK.GRASS));

                    }else{
                        Yfinal--;
                        gameObject = new GameObject(new Vector3f(i, Yfinal, j), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), Texture.returnMesh(BLOCK.STONE));

                    }
                    flat_wordY.put( Yfinal, gameObject);
                }
                flat_wordZ.put(j, flat_wordY);
            }
            flat_WordX.put(i, flat_wordZ);
        }
        Tree tree = new Tree(Test,DistanceMap,box,MaxHeight);
        tree.genereteTree();
    }



    public void Generate_new_space(Renderer renderer, Camera camera) {
        int actualX = (int) camera.getPosition().getX();
        int actualZ = (int) camera.getPosition().getZ();
        int actualY = (int)camera.getPosition().getY();
        for (int i = actualX - box; i < actualX + box; i++) {
            HashMap<Integer, HashMap<Integer,GameObject>> innerMap = flat_WordX.get(i);
            if (innerMap != null) {
                for (int j = actualZ - box; j < actualZ + box; j++) {
                    HashMap<Integer,GameObject> gameObject = innerMap.get(j);
                    if (gameObject != null) {

                        for(int g = actualY - box; g < actualY + box; g++){
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

    private int NoiseHeightReturn(int x , int y){
        double returnY = noiseGenerator.noise(x * increment,y * increment) * MaxHeight;
        return (int)returnY;
    }




}



