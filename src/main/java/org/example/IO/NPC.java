package org.example.IO;

import org.example.generate.Generate_World;
import org.example.math.Vector3f;
import org.example.object.Camera;
import org.example.object.GameObject;

public class NPC {
private  static int distance=5;


    public static boolean checkRayHitsBlock() {

      //  Vector3f currentPos = new Vector3f(Camera.position.getX(),Camera.position.getY(),Camera.position.getZ());
 //   int x = (int)currentPos.getX();
 //   int z = (int) currentPos.getZ();
  //  int y = (int)currentPos.getY();
      //  Generate_World.flat_WordX.get(x+1).get(z).put(y,null);
     //   Generate_World.flat_WordX.get(x).get(z).remove(y);


            return false; // Promień nie trafia w żaden blok
    }


}





