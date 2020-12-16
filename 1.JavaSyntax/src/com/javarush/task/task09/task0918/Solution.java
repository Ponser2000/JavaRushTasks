package com.javarush.task.task09.task0918;

import java.io.*;
/* 
Все свои, даже исключения
*/

public class Solution {
    public static void main(String[] args) {
    }

    static class MyException extends FileNotFoundException{
    }
    static class MyException2 extends IOException {
    }
    static class MyException3 extends RuntimeException{
    }
    static class MyException4 extends IndexOutOfBoundsException{
    }
}

