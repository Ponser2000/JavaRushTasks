package com.javarush.task.task06.task0612;

/* 
Калькулятор
*/

public class Calculator {
    public static int plus(int a, int b) {
        //напишите тут ваш код
        return a+b;
    }

    public static int minus(int a, int b) {
        //напишите тут ваш код
        return a-b;
    }

    public static int multiply(int a, int b) {
        //напишите тут ваш код
        return a*b;
    }

    public static double division(int a, int b) {
        double res = (a/1.0) / b;
        return res;
    }

    public static double percent(int a, int b) {
        //напишите тут ваш код
        return b*a/100.0;
    }

    public static void main(String[] args) {

    }
}