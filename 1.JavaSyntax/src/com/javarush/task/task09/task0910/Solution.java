package com.javarush.task.task09.task0910;

import java.util.ArrayList;

/* 
Исключение при работе с коллекциями List
*/

public class Solution {
    public static void main(String[] args) {
        try {

        ArrayList<String> list = new ArrayList<String>();
        String s = list.get(18);
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println(e.getClass());
        }
        //напишите тут ваш код
    }
}