package com.javarush.task.task30.task3002;

/* 
Осваиваем методы класса Integer
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        Integer result;

        if (s.startsWith("0x")) {
            result = Integer.parseInt(s.substring(2), 16);
        } else if (s.startsWith("0b")) {
            result = Integer.parseInt(s.substring(2), 2);
        } else if (s.startsWith("0")) {
            result = Integer.parseInt(s.substring(1), 8);
        } else {
            return s;
        }

        return result.toString();
    }
}
