package org.example.generate;

import org.example.math.Vector3f;
import org.example.object.Camera;
import org.example.object.GameObject;

import java.util.HashMap;

public class Colison {

    public static boolean changeCollision(Vector3f vector3f) {
        int newX = (int) (vector3f.getX());
        int newY = (int)    (vector3f.getY());
        int newZ = (int) (vector3f.getZ());
       if(newX<0 && newZ<0){
           newX--;
           newZ--;

       } else if (newX<0 && newZ>0) {
           newX--;
       }
     else if (newX >0  && newZ<0) {
        newZ--;
    }
        System.out.println(newX + " "+ newZ + " " + newY);
        GameObject set1 = Generate_World.flat_WordX.get(newX).get(newZ).get(newY);
        //GameObject set2 = Generate_World.flat_WordX.get(newX).get(newZ).get(newY+1);
            if (set1 != null ) {
                return false; // Kolizja, blok jest zajęty
            }

        return true; // Brak kolizji, blok jest wolny
    }



}
