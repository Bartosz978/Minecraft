package org.example.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileUtils {
    public static String LoadString(String path){
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Class.class.getResourceAsStream(path)))){
            String line = "";
            while ((line = bufferedReader.readLine()) != null){
                stringBuilder.append(line).append("\n");
            }
        }catch (IOException e){
        System.err.println(e.getMessage());
        }
        return  stringBuilder.toString();
    }
}
