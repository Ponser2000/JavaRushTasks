package com.javarush.task.task19.task1907;

import java.io.*;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(filename);
        int count=0;
        String line="";
        while (fileReader.ready()){
            int n = fileReader.read();
            if (n != 32 && n != (int) '.' && n != (int) ',' && n != (int) '\n' && n != (int) '\r') {
                line=line+(char) n;
            } else {
                if (line.equals("world")) {
                    count++;
                }
                line="";
            }
        }
        if (line.equals("world")) {
            count++;
        }
        System.out.println(count);
        fileReader.close();
    }
}
