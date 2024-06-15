package org.example.Texture;

import org.example.graphics.Mesh;
import org.example.graphics.Vertex;
import org.example.materials.Material;
import org.example.math.Vector2f;
import org.example.math.Vector3f;

public class Texture {
    private static final int ALL_Block = 4;
    private static final int[] ArrayActive= {0,0,0,0};
    private static final Mesh[] ArrayMesh = new Mesh[ALL_Block];

    private static String pathResource = "C:\\Users\\User\\Desktop\\Minecraft\\resources\\texture\\";


    private static String[] PathArray = {
            pathResource + "grass.jpeg",pathResource + "stone.png",pathResource + "wood.jpeg",pathResource + "leaves.jpeg"

    };


    private static void createMesh(int choose){
        if(ArrayActive[choose] == 0){
            ArrayActive[choose] = 1;
            if(choose == 0){
                ArrayMesh[choose] = new Mesh(new Vertex[]{
                        //Back face
                        new Vertex(new Vector3f(0.0f, 1.0f, 0.0f), new Vector2f(0.0f, 0.0f)),
                        new Vertex(new Vector3f(0.0f, 0.0f, 0.0f), new Vector2f(0.0f, 1.0f)),
                        new Vertex(new Vector3f(1.0f, 0.0f, 0.0f), new Vector2f(0.25f, 1.0f)),
                        new Vertex(new Vector3f(1.0f, 1.0f, 0.0f), new Vector2f(0.25f, 0.0f)),

                        // Front face
                        new Vertex(new Vector3f(0.0f, 1.0f, 1.0f), new Vector2f(0.0f, 0.0f)),
                        new Vertex(new Vector3f(0.0f, 0.0f, 1.0f), new Vector2f(0.0f, 1.0f)),
                        new Vertex(new Vector3f(1.0f, 0.0f, 1.0f), new Vector2f(0.25f, 1.0f)),
                        new Vertex(new Vector3f(1.0f, 1.0f, 1.0f), new Vector2f(0.25f, 0.0f)),

                        // Right face
                        new Vertex(new Vector3f(1.0f, 1.0f, 0.0f), new Vector2f(0.0f, 0.0f)),
                        new Vertex(new Vector3f(1.0f, 0.0f, 0.0f), new Vector2f(0.0f, 1.0f)),
                        new Vertex(new Vector3f(1.0f, 0.0f, 1.0f), new Vector2f(0.25f, 1.0f)),
                        new Vertex(new Vector3f(1.0f, 1.0f, 1.0f), new Vector2f(0.25f, 0.0f)),

                        // Left face
                        new Vertex(new Vector3f(0.0f, 1.0f, 0.0f), new Vector2f(0.0f, 0.0f)),
                        new Vertex(new Vector3f(0.0f, 0.0f, 0.0f), new Vector2f(0.0f, 1.0f)),
                        new Vertex(new Vector3f(0.0f, 0.0f, 1.0f), new Vector2f(0.25f, 1.0f)),
                        new Vertex(new Vector3f(0.0f, 1.0f, 1.0f), new Vector2f(0.25f, 0.0f)),

                        // Top face
                        new Vertex(new Vector3f(0.0f, 1.0f, 1.0f), new Vector2f(0.25f, 0.0f)),
                        new Vertex(new Vector3f(0.0f, 1.0f, 0.0f), new Vector2f(0.25f, 1.0f)),
                        new Vertex(new Vector3f(1.0f, 1.0f, 0.0f), new Vector2f(0.5f, 1.0f)),
                        new Vertex(new Vector3f(1.0f, 1.0f, 1.0f), new Vector2f(0.5f, 0.0f)),

                        // Bottom face
                        new Vertex(new Vector3f(0.0f, 0.0f, 1.0f), new Vector2f(0.75f, 0.0f)),
                        new Vertex(new Vector3f(0.0f, 0.0f, 0.0f), new Vector2f(0.75f, 1.0f)),
                        new Vertex(new Vector3f(1.0f, 0.0f, 0.0f), new Vector2f(1.0f, 1.0f)),
                        new Vertex(new Vector3f(1.0f, 0.0f, 1.0f), new Vector2f(1.0f, 0.0f))
                }, new int[]{
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
                },  new Material(null));
                ArrayMesh[choose].setMaterial(new Material(PathArray[choose]));

            }else{
                ArrayMesh[choose] = new Mesh(new Vertex[]{
                        //Back face
                        new Vertex(new Vector3f(0.0f, 1.0f, 0.0f), new Vector2f(0.0f, 0.0f)),
                        new Vertex(new Vector3f(0.0f, 0.0f, 0.0f), new Vector2f(0.0f, 1.0f)),
                        new Vertex(new Vector3f(1.0f, 0.0f, 0.0f), new Vector2f(1.0f, 1.0f)),
                        new Vertex(new Vector3f(1.0f, 1.0f, 0.0f), new Vector2f(1.0f, 0.0f)),

                        // Front face
                        new Vertex(new Vector3f(0.0f, 1.0f, 1.0f), new Vector2f(0.0f, 0.0f)),
                        new Vertex(new Vector3f(0.0f, 0.0f, 1.0f), new Vector2f(0.0f, 1.0f)),
                        new Vertex(new Vector3f(1.0f, 0.0f, 1.0f), new Vector2f(1.0f, 1.0f)),
                        new Vertex(new Vector3f(1.0f, 1.0f, 1.0f), new Vector2f(1.0f, 0.0f)),

                        // Right face
                        new Vertex(new Vector3f(1.0f, 1.0f, 0.0f), new Vector2f(0.0f, 0.0f)),
                        new Vertex(new Vector3f(1.0f, 0.0f, 0.0f), new Vector2f(0.0f, 1.0f)),
                        new Vertex(new Vector3f(1.0f, 0.0f, 1.0f), new Vector2f(1.0f, 1.0f)),
                        new Vertex(new Vector3f(1.0f, 1.0f, 1.0f), new Vector2f(1.0f, 0.0f)),

                        // Left face
                        new Vertex(new Vector3f(0.0f, 1.0f, 0.0f), new Vector2f(0.0f, 0.0f)),
                        new Vertex(new Vector3f(0.0f, 0.0f, 0.0f), new Vector2f(0.0f, 1.0f)),
                        new Vertex(new Vector3f(0.0f, 0.0f, 1.0f), new Vector2f(1.0f, 1.0f)),
                        new Vertex(new Vector3f(0.0f, 1.0f, 1.0f), new Vector2f(1.0f, 0.0f)),

                        // Top face
                        new Vertex(new Vector3f(0.0f, 1.0f, 1.0f), new Vector2f(0.0f, 0.0f)),
                        new Vertex(new Vector3f(0.0f, 1.0f, 0.0f), new Vector2f(0.0f, 1.0f)),
                        new Vertex(new Vector3f(1.0f, 1.0f, 0.0f), new Vector2f(1.0f, 1.0f)),
                        new Vertex(new Vector3f(1.0f, 1.0f, 1.0f), new Vector2f(1.0f, 0.0f)),

                        // Bottom face
                        new Vertex(new Vector3f(0.0f, 0.0f, 1.0f), new Vector2f(0.0f, 0.0f)),
                        new Vertex(new Vector3f(0.0f, 0.0f, 0.0f), new Vector2f(0.0f, 1.0f)),
                        new Vertex(new Vector3f(1.0f, 0.0f, 0.0f), new Vector2f(1.0f, 1.0f)),
                        new Vertex(new Vector3f(1.0f, 0.0f, 1.0f), new Vector2f(1.0f, 0.0f))
                }, new int[]{
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
                }, new Material(null));
                ArrayMesh[choose].setMaterial(new Material(PathArray[choose]));
            }


        }
    }



    public static Mesh returnMesh(BLOCK E){

        int index = E.getIndex();
        createMesh(index);
            return ArrayMesh[index];



        }
    public static void InitAlltexture(){
        int x = 0;
        for (Mesh E : ArrayMesh){

            if(ArrayActive[x] != 0) {
                E.create();
            }
            x++;
        }
    }
    }



