package com.javarush.task.task18.task1824;

import java.io.*;
import java.util.ArrayList;

/* 
Файлы и исключения
*/

public class Solution extends Thread{
    public static void main(String[] args) throws FileNotFoundException,IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<FileInputStream> fileInputStreams = new ArrayList<>();
        String filename=null;

        while (true) {

            try {
                filename = reader.readLine();
               fileInputStreams.add(new FileInputStream(filename));
            }
            catch (FileNotFoundException e) {
                for(FileInputStream fileInputStream : fileInputStreams) {
                    fileInputStream.close();
                }

               // System.out.println(e.getMessage());
                System.out.println(filename);
                return;
            }

        }
    }
}
