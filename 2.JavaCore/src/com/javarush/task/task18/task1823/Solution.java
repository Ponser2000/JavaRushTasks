package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();

        while (!filename.equals("exit")){
            ReadThread readThread  = new ReadThread(filename);
            readThread.run();
            filename = reader.readLine();
        }

    }

    public static class ReadThread extends Thread {
        private FileInputStream reader;
        private String filename;

        public ReadThread(String fileName) throws FileNotFoundException {
            this.reader = new FileInputStream(fileName);
            this.filename = fileName;

        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            byte[] data = new byte[256];
            for(int i=0; i<256; i++) {
                data[i]=0;
            }

            try {
            while (reader.available()>0){
                data[reader.read()]++;
            }

            int idx=0;
            int max = 0;

            for(int i=0; i<256; i++) {
                if (max< data[i]) {
                    max = data[i];
                    idx = i;
                }
            }

            Solution.resultMap.put(filename,idx);

            reader.close();
            } catch (IOException e) {}

        }
    }
}
