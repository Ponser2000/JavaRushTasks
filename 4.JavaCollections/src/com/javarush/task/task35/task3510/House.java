package com.javarush.task.task35.task3510;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* 
Вход воспрещен!
*/

public class House<T> {

    private List<T> residents = new ArrayList();

    public void enter(T resident) {
        residents.add(resident);
        //checkConflicts();
    }

    public void leave(T resident) {
        residents.remove(resident);
    }

    /*
    private void checkConflicts() {
        boolean conflict = false;
        for (Object resident : residents) {
            if (resident instanceof Dog) {
                conflict = true;
            }
        }

        if (conflict) {
            Iterator iterator = residents.iterator();
            while (iterator.hasNext()) {
                Object resident = iterator.next();
                if (resident instanceof Cat) {
                    iterator.remove();
                }
            }
        }
    }
*/

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("В доме находятся:\n");
        for (T resident : residents) {
            builder.append(resident.toString()).append("\n");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Dog bruno = new Dog("Bruno");
        Puppy larsik = new Puppy("Larsik");
        Cat barsik = new Cat("Barsik");
        Kitten keksik = new Kitten("Keksik");

        House dogHouse = new House();
        dogHouse.enter(bruno);
        dogHouse.enter(larsik);
        //dogHouse.enter(barsik);
        System.out.println(dogHouse.toString());

        House catHouse = new House();
        catHouse.enter(barsik);
        catHouse.enter(keksik);
        //catHouse.enter(bruno);
        System.out.println(catHouse.toString());
    }
}
