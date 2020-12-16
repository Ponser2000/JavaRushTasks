package com.javarush.task.task13.task1319;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter outFile = null;

        ArrayList<String> list = new ArrayList<>();

        try {
            String fileName=reader.readLine();
            while(true){
                String str = reader.readLine();
                if(str.equals("exit")){
                    list.add(str);
                    break;
                } else {
                    list.add(str);
                }
            }

            outFile = new BufferedWriter(new FileWriter(fileName));
            for(String str : list){
                outFile.write(str+ "\n");
            }
            outFile.close();
            reader.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
