package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;

/* 
Пунктуация
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        reader.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename1));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename2));
        String line="";
        String str_out="";
        while (bufferedReader.ready()){
            line = bufferedReader.readLine();
            line = line.replaceAll("\\p{Punct}","");
            line = line.replaceAll("\r","");
            line = line.replaceAll("\\.","");
            line = line.replaceAll(",","");
            line = line.replaceAll(":","");
            line = line.replaceAll(";","");
            line = line.replaceAll("!","");
            line = line.replaceAll("\\?","");

            str_out = str_out + line;
        }

        bufferedWriter.write(str_out);

        bufferedReader.close();
        bufferedWriter.close();
    }
}
