package com.javarush.task.task18.task1827;



import java.io.*;
import java.util.*;


/*
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(filename);
        BufferedReader reader1 = new BufferedReader(fileReader);
        List<String> data = readAllLines(reader1);

        reader1.close();
        fileReader.close();

        FileWriter fileWriter = new FileWriter(filename,true);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        if (args.length != 0 && args[0].equals("-c")) {

            int id = getMax(data);
            String product = args[1];
            if (args[1].length()>30) {
                product = args[1].substring(0, 30);
            }
            //float price = Float.parseFloat(args[2]);
            String price = args[2];
            //int count = Integer.parseInt(args[3]);
            String count = args[3];

            //String out_str = String.format("\n%-8d%-30s%-8.2f%-4d",id,product,price,count);
            String out_str = String.format("\n%-8d%-30s%-8s%-4s",id,product,price,count);
            writer.write(out_str);

        }
        writer.close();
        fileWriter.close();
    }

    public static int getMax(List<String> allLines) {
        int max=0;
        for(String line : allLines) {
            String id_s = line.substring(0,8);
            id_s = id_s.replaceAll(" ","");
            if (max < Integer.parseInt(id_s)) {
                max = Integer.parseInt(id_s);
            }
        }
        max++;
        return max;
    }

    public static List<String> readAllLines(BufferedReader reader) throws IOException {
        List<String> allLines = new ArrayList<String>();
        String line;
        while(( line = reader.readLine()) != null ) {
            allLines.add(line);
        }

        return allLines;

    }

}
