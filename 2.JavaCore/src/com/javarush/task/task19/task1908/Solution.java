package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        reader.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename1));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename2));
        String str_out="";

        while (bufferedReader.ready()) {
            String[] s = bufferedReader.readLine().split(" ");
            for (int i=0; i< s.length; i++){
                try {
                    int c = Integer.parseInt(s[i]);
                    str_out = str_out + s[i] +" ";
                } catch (NumberFormatException e) {
                    continue;
                }
            }
        }

        str_out = str_out.trim();
        bufferedWriter.write(str_out);
        bufferedReader.close();
        bufferedWriter.close();


    }
}
