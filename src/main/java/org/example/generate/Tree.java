package org.example.generate;

import org.example.Texture.BLOCK;
import org.example.Texture.Texture;
import org.example.math.Vector3f;
import org.example.object.GameObject;

import java.util.Random;

public class Tree {

    private int CentralMap;
    private  int DistanceForCentralMap;
    private int Box;
    private int Maxheight;

    private final int TreeInBoxtatic = 2;

    Random random;

    public Tree(int przestrzen,int distanceForCentralMap, int box,int height) {
        CentralMap = przestrzen ;
        DistanceForCentralMap = distanceForCentralMap;
        Box = box;
        Maxheight = height;
    }


    public void genereteTree(){
        random = new Random();

        for (int i = CentralMap-DistanceForCentralMap+10; i < CentralMap + DistanceForCentralMap-Box-10; i += Box){
            for (int j =  CentralMap-DistanceForCentralMap+10; j < CentralMap + DistanceForCentralMap-Box-10; j += Box){
                int TreInbox = random.nextInt(TreeInBoxtatic);
                for(int d = 0;d < TreInbox;d++){
                    int x = random.nextInt(Box)+ i ;
                    int z = random.nextInt(Box)+ j ;
                    for (int y = 0; y < Maxheight; y ++){
                        if(Generate_World.flat_WordX.get(x) ==  null || Generate_World.flat_WordX.get(x).get(z) == null || Generate_World.flat_WordX.get(x).get(z).get(y) == null){
                            Vector3f vector3f = new Vector3f(x,y,z);
                            Tree1(vector3f);
                            break;
                        }

                    }
                }
            }
        }
    }
    private void Tree1(Vector3f vector3f){


        int heightTre = random.nextInt(3) + 5;

            int x = (int)vector3f.getX();
            int y = (int)vector3f.getY();
            int z = (int)vector3f.getZ();

        int SkyTree =  (heightTre + y );
        float FskyTree = heightTre  ;

        for(int i =0;i<heightTre;i++)
             Generate_World.flat_WordX.get(x).get(z).put(y+i,new GameObject(new Vector3f(vector3f.getX(),vector3f.getY()+(float)i,vector3f.getZ()), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), Texture.returnMesh(BLOCK.WOOD)));

        if(Generate_World.flat_WordX.get(x).get(z).get(SkyTree) == null);
        Generate_World.flat_WordX.get(x).get(z).put(SkyTree,new GameObject(new Vector3f(vector3f.getX(),vector3f.getY()+ FskyTree,vector3f.getZ()), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), Texture.returnMesh(BLOCK.LEAVES)));

        if(Generate_World.flat_WordX.get(x+1).get(z).get(SkyTree) == null);
        Generate_World.flat_WordX.get(x+1).get(z).put(SkyTree,new GameObject(new Vector3f(vector3f.getX() + 1f,vector3f.getY()+ FskyTree,vector3f.getZ()), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), Texture.returnMesh(BLOCK.LEAVES)));

       if(Generate_World.flat_WordX.get(x-1).get(z).get(SkyTree) == null);
        Generate_World.flat_WordX.get(x-1).get(z).put(SkyTree,new GameObject(new Vector3f(vector3f.getX() - 1f,vector3f.getY()+ FskyTree,vector3f.getZ()), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), Texture.returnMesh(BLOCK.LEAVES)));

        if(Generate_World.flat_WordX.get(x).get(z+1).get(SkyTree) == null);
        Generate_World.flat_WordX.get(x).get(z+1).put(SkyTree,new GameObject(new Vector3f(vector3f.getX(),vector3f.getY()+ FskyTree,vector3f.getZ() + 1f), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), Texture.returnMesh(BLOCK.LEAVES)));

       if(Generate_World.flat_WordX.get(x).get(z-1).get(SkyTree) == null);
       Generate_World.flat_WordX.get(x).get(z-1).put(SkyTree,new GameObject(new Vector3f(vector3f.getX(),vector3f.getY()+ FskyTree,vector3f.getZ() - 1f), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), Texture.returnMesh(BLOCK.LEAVES)));





        if(Generate_World.flat_WordX.get(x+1).get(z).get(SkyTree-1) == null);
        Generate_World.flat_WordX.get(x+1).get(z).put(SkyTree-1,new GameObject(new Vector3f(vector3f.getX() + 1f,vector3f.getY()+ FskyTree -1f,vector3f.getZ()), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), Texture.returnMesh(BLOCK.LEAVES)));

        if(Generate_World.flat_WordX.get(x-1).get(z).get(SkyTree-1) == null);
        Generate_World.flat_WordX.get(x-1).get(z).put(SkyTree-1,new GameObject(new Vector3f(vector3f.getX() - 1f,vector3f.getY()+ FskyTree - 1f,vector3f.getZ()), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), Texture.returnMesh(BLOCK.LEAVES)));

        if(Generate_World.flat_WordX.get(x).get(z+1).get(SkyTree-1) == null);
        Generate_World.flat_WordX.get(x).get(z+1).put(SkyTree-1,new GameObject(new Vector3f(vector3f.getX(),vector3f.getY()+ FskyTree-1f,vector3f.getZ() + 1f), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), Texture.returnMesh(BLOCK.LEAVES)));

        if(Generate_World.flat_WordX.get(x).get(z-1).get(SkyTree-1) == null);
        Generate_World.flat_WordX.get(x).get(z-1).put(SkyTree-1,new GameObject(new Vector3f(vector3f.getX(),vector3f.getY()+ FskyTree-1f,vector3f.getZ() - 1f), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), Texture.returnMesh(BLOCK.LEAVES)));



        if(Generate_World.flat_WordX.get(x-1).get(z-1).get(SkyTree-1) == null);
        Generate_World.flat_WordX.get(x-1).get(z-1).put(SkyTree-1,new GameObject(new Vector3f(vector3f.getX()-1f,vector3f.getY()+ FskyTree-1f,vector3f.getZ() - 1f), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), Texture.returnMesh(BLOCK.LEAVES)));

        if(Generate_World.flat_WordX.get(x+1).get(z-1).get(SkyTree-1) == null);
        Generate_World.flat_WordX.get(x+1).get(z-1).put(SkyTree-1,new GameObject(new Vector3f(vector3f.getX()+1f,vector3f.getY()+ FskyTree-1f,vector3f.getZ() - 1f), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), Texture.returnMesh(BLOCK.LEAVES)));

        if(Generate_World.flat_WordX.get(x-1).get(z+1).get(SkyTree-1) == null);
        Generate_World.flat_WordX.get(x-1).get(z+1).put(SkyTree-1,new GameObject(new Vector3f(vector3f.getX()-1f,vector3f.getY()+ FskyTree-1f,vector3f.getZ() + 1f), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), Texture.returnMesh(BLOCK.LEAVES)));

        if(Generate_World.flat_WordX.get(x+1).get(z+1).get(SkyTree-1) == null);
        Generate_World.flat_WordX.get(x+1).get(z+1).put(SkyTree-1,new GameObject(new Vector3f(vector3f.getX()+1f,vector3f.getY()+ FskyTree-1f,vector3f.getZ() + 1f), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), Texture.returnMesh(BLOCK.LEAVES)));

for(float height = 3;height>1;height--)
        for(float h=0;h<5;h++){
            for (float g =0;g<5;g++){
                if(Generate_World.flat_WordX.get(x-2+(int)g).get(z-2+(int)h).get(SkyTree-(int)height) == null);
                Generate_World.flat_WordX.get(x-2+(int)g).get(z-2+(int)h).put(SkyTree-(int)height,new GameObject(new Vector3f(vector3f.getX()-2f+g,vector3f.getY()+ FskyTree-height,vector3f.getZ()-2+h), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), Texture.returnMesh(BLOCK.LEAVES)));
            }
        }
    }



}


