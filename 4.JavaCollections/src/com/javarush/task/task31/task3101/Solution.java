package com.javarush.task.task31.task3101;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

/* 
Проход по дереву файлов
*/

public class Solution {
    public static void main(String[] args) {
        //получаем список файлов размером менее 50 байт из всех каталогов
        Queue<File> queue = new PriorityQueue<>();
        ArrayList<File> list = new ArrayList<>();
        File fileDirectory = new File(args[0]);
        File destinationOldName = new File(args[1]);

        File destinationNewName = new File(destinationOldName.getParent() + "/"+"allFilesContent.txt");
        FileUtils.renameFile(destinationOldName, destinationNewName);

        Collections.addAll(queue, fileDirectory.listFiles());

        while (!queue.isEmpty()) {
            File currentFile = queue.remove();
            if(currentFile.isDirectory()){
                Collections.addAll(queue, currentFile.listFiles());
            } else if(currentFile.length() <= 50){
                list.add(currentFile);
            }
        }

        //делаем сортировку по имени файлов
        Collections.sort(list, (o1, o2) -> o1.getName().compareTo(o2.getName()));
/*
        for(File str : list) {
            System.out.println(str.toString());
        }*/




        //записываем содержимое файлов в файл
        try(FileOutputStream file = new FileOutputStream(destinationNewName, true);
            BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(file, "UTF8") )) {
            for(File str : list){
                FileInputStream in = new FileInputStream(str);
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String line = null;
                while((line = br.readLine()) != null){
                    wr.write(line);
                    wr.newLine();
                }
                //wr.newLine();
                wr.flush();
                in.close();
                br.close();
            }
        }catch(FileNotFoundException e){
            e.getMessage();
        }catch(IOException e){
            e.getMessage();
        }


    }
}