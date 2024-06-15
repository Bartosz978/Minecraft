package org.example.generate;

import org.example.math.Vector3f;
import org.example.object.GameObject;

public class Colison {

    private static float distanceBlock = 0.2f;


    public static boolean changeCollision(Vector3f newpPosition,Vector3f oldPosition) {


        Vector3f colliosnVector = new Vector3f(0,0,0);
        //float distanceBlockX = (float) Math.sin(Math.toRadians(rotation.getY())) * distanceBlock;
       // float distanceBlockZ  = (float) Math.sin(Math.toRadians(rotation.getY())) * distanceBlock;

        int newX = (int) (newpPosition.getX());
        int newY = (int)    (newpPosition.getY());
        int newZ = (int) (newpPosition.getZ());

        int X = 0,Y = 0,Z = 0;
        if(newpPosition.getX() > oldPosition.getX()){

            X = 1;
        }else {

        }
        if(newpPosition.getY() > oldPosition.getY()){
            Y = 1;
        }
        else {

        }
        if(newpPosition.getZ() > oldPosition.getZ()){
            Z = 1;
        }
        else {

        }

        GameObject set1 = Generate_World.flat_WordX.get(newX).get(newZ).get(newY);
            if (set1 != null ) {
                return false;
            }

        return true;
    }


/** gdyby uklad byl od 0.0
 *     if(newX<0 && newZ<0){
 *            newX--;
 *            newZ--;
 *
 *        } else if (newX<0 && newZ>0) {
 *            newX--;
 *        }
 *      else if (newX >0  && newZ<0) {
 *         newZ--;
 *     }
 */
}
