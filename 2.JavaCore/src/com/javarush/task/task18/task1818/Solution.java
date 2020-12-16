package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        String filename3 = reader.readLine();

        FileInputStream reader2 = new FileInputStream(filename2);
        FileInputStream reader3 = new FileInputStream(filename3);

        FileOutputStream writer = new FileOutputStream(filename1);

        while(reader2.available()>0) {
            writer.write(reader2.read());
        }

        writer.close();

        writer = new FileOutputStream(filename1,true);

        while(reader3.available()>0) {
            writer.write(reader3.read());
        }

        writer.close();
        reader.close();
        reader2.close();
        reader3.close();


    }
}
