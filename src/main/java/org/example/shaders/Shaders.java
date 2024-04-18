package org.example.shaders;

import java.io.BufferedReader;
import java.io.IOException;

public abstract class Shaders {
    private int vertexShaderID,fragmentShaderID,programID;
    public String vertexFile,fragmentFile;
    Shaders(String vertexFile,String fragmentFile){
        this.vertexFile =  vertexFile;
        this.fragmentFile = fragmentFile;

    }
    public void create(){

    }
    public  void blind(){

    }
    public void remowe(){

    }
    private void readFile(String file){
        BufferedReader reader = null;
        StringBuilder stringBuilder = new StringBuilder();
      //  try {

            String line;

     //   }catch (IOException e){

        //}
    }
}
