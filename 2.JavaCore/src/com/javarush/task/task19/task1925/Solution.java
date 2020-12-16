package com.javarush.task.task19.task1925;

import java.io.*;
import java.util.ArrayList;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String filename1 = args[0];
        String filename2 = args[1];

        BufferedReader reader = new BufferedReader(new FileReader(filename1));

        BufferedWriter writer = new BufferedWriter(new FileWriter(filename2));

        String str,res="";
        while((str = reader.readLine()) != null) {
            String[] words = str.split(" ");
            for(String word: words) {
                if(word.length()>6) {
                    res=res+word+",";
                }
            }
        }

        reader.close();

        res = res.substring(0,res.length()-1);

        writer.write(res);

        writer.close();


    }
}
