package org.example.IO;

import org.example.object.Camera;

public class NPC {
    public static int North = 0;
    public static int East = 0;
    public static int South = 0;
    public static int West = 0;
    private int distance = 6;

    public void direction(){

        if(Camera.newMouseX > Camera.oldMouseX ){
            North = 0;
            East = 1;
            South = 0;
            West = 0;

        } else if (Camera.newMouseX < Camera.oldMouseX ) {
            North = 0;
            East = 0;
            South = 0;
            West = 1;
        } else if (Camera.newMouseY > Camera.oldMouseY ) {
            North = 1;
            East = 0;
            South = 0;
            West = 0;

        } else if (Camera.newMouseY < Camera.oldMouseY ) {
            North = 0;
            East = 0;
            South = 1;
            West = 0;
            
        }
    }
    public void destroyBlock(){

    }


}
