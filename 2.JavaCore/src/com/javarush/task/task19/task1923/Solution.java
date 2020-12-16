package com.javarush.task.task19.task1923;

import java.io.*;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));

        String res="";
        String s1;
        while((s1 = reader.readLine()) != null) {
            String[] str = s1.split(" ");
            for(String s : str) {
                if(s.matches(".+[0-9].+")) {
                    res = res + s + " ";
                }
            }
        }

        res = res.trim();
        writer.write(res);

        reader.close();
        writer.close();

    }
}
