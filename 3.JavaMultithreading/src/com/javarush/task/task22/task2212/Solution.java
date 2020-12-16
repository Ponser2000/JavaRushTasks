package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/

public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        boolean result = false;

        if (telNumber == null)
            return result;

        String pattern = "^\\+[1-9][0-9]{10}[0-9]$|^[0-9]{10}$|^\\([0-9]{3}\\)[0-9]{7}$|^\\+[1-9][0-9]\\([0-9]{3}\\)[0-9]{7}$|^[0-9]{6}-[0-9]{4}$|^\\+{0,1}[0-9]{6,8}-[0-9]{2}-[0-9]{2}$";
        if (!telNumber.matches("\\w|-{1,2}")) {
            if (telNumber.matches(pattern)) {
                result = true;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(checkTelNumber("+380501234567"));
        System.out.println(checkTelNumber("+38(050)1234567"));
        System.out.println(checkTelNumber("+38050123-45-67"));
        System.out.println(checkTelNumber("050123-4567"));
        System.out.println(checkTelNumber("+38)050(1234567"));
        System.out.println(checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.println(checkTelNumber("050ххх4567"));
        System.out.println(checkTelNumber("050123456"));
        System.out.println(checkTelNumber("(0)501234567"));

    }
}
