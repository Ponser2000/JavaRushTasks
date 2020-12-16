package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1;
        BufferedReader reader2;

        try {
            reader1 = new BufferedReader(new FileReader(reader.readLine()));
            reader2 = new BufferedReader(new FileReader(reader.readLine()));

            while (reader1.ready()) {
                allLines.add(reader1.readLine());
            }

            while (reader2.ready()) {
                forRemoveLines.add(reader2.readLine());
            }

        } catch (IOException e) {}

        try {
            new Solution().joinData();
        }
        catch (CorruptedDataException e) {

        }

    }

    public void joinData() throws CorruptedDataException {

        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            while (allLines.size()!=0) {
                allLines.remove(0);
            }
            throw new CorruptedDataException();
        }
    }
}
