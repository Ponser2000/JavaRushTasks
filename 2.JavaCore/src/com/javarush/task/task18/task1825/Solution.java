package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> fileList = new ArrayList<>();
        String filename=null;
        while(true){
            filename = reader.readLine();
            if (filename.equals("end")) {
                break;
            }
            fileList.add(filename);
        }

        reader.close();

        int size = fileList.size();
        String filename1 = fileList.get(size-1).split(".part")[0];

        FileOutputStream outputStream = new FileOutputStream(filename1);
        FileInputStream inputStream;

        for(int i=1; i<=size; i++) {
            inputStream = new FileInputStream(filename1+".part"+i);
            byte[] b = new byte[inputStream.available()];
            inputStream.read(b);
            outputStream.write(b);
            inputStream.close();
        }

        outputStream.close();


    }
}
