package com.javarush.task.task20.task2017;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* 
Десериализация
*/

public class Solution {
    public A getOriginalObject(ObjectInputStream objectStream) {
        A o;
        try {
            o =(A) objectStream.readObject();
        } catch (ClassNotFoundException e) {
            //e.printStackTrace();
            return null;
        } catch (Exception e) {
            // e.printStackTrace();
            return null;
        }
        return o;
    }

    public class A implements Serializable{
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) {

    }
}
