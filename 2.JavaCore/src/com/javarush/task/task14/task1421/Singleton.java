package com.javarush.task.task14.task1421;

class Singleton {
    private static Singleton instance ;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }


}
