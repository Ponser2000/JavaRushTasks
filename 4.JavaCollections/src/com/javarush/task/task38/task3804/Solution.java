package com.javarush.task.task38.task3804;

/* 
Фабрика исключений
*/

public class Solution {
    public static Class getFactoryClass() {
        return FactoryExeption.class;
    }

    public static void main(String[] args) {
        FactoryExeption.getException(ApplicationExceptionMessage.SOCKET_IS_CLOSED);
    }
}