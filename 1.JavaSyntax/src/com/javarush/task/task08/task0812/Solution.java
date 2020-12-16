package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        int temp=1;
        List<Integer>list=new ArrayList<>();
        List<Integer> value =new ArrayList<>();

        for(int i=0;i<10;i++){
            int a=Integer.parseInt(reader.readLine()) ;
            list.add(a) ;
        }



        for(int i=0; i<list.size()-1; i++) {
            if(list.get(i).equals(list.get(i+1))){
                temp++;
            } else {
                value.add(temp);
                temp = 1;

            }
        }
        value.add(temp);

        Collections.sort(value);

        System.out.println(value.get(value.size()-1));
    }
}