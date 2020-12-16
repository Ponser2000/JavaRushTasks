package com.javarush.task.task13.task1326;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.io.*;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName;
            ArrayList<Integer> list = new ArrayList<>();

            try {
                fileName = reader.readLine();
                FileInputStream fileInputStream = new FileInputStream(fileName);
                BufferedReader bufferedInputStream = new BufferedReader(new InputStreamReader(fileInputStream));

                int i,j;
                String line;
                while ((line = bufferedInputStream.readLine())!= null) {
                    i = Integer.parseInt(line);
                    if ( i % 2 == 0)
                        list.add(i);
                }

                Integer[] ar = list.toArray(new Integer[list.size()]);

                for(i=0; i<ar.length; i++) {
                    for(j=i; j<ar.length; j++) {
                        if (ar[i]>ar[j]) {
                            int s = ar[i];
                            ar[i] = ar[j];
                            ar[j] = s;
                        }
                    }
                }
                for(Integer n : ar)
                    System.out.println(n);

                bufferedInputStream.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
}
