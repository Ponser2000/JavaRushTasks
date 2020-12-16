package com.javarush.task.task17.task1711;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {

        switch (args[0]) {

            case "-u": {
                synchronized (allPeople) {
                    Person person;
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

                    for (int i = 1; i < args.length; i += 4) {

                        person = allPeople.get(Integer.parseInt(args[i]));

                        person.setName(args[i + 1]);

                        if (args[i + 2].equals("м")) {
                            person.setSex(Sex.MALE);
                        } else if (args[i + 2].equals("ж")) {
                            person.setSex(Sex.FEMALE);
                        }

                        try {
                            person.setBirthDate(formatter.parse(args[i + 3]));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        allPeople.set(Integer.parseInt(args[i]), person);
                    }
                    break;
                }
            }

            case "-d": {
                synchronized (allPeople) {
                    Person person;
                    for (int i = 1; i < args.length; i++) {
                        person = allPeople.get(Integer.parseInt(args[i]));
                        person.setName(null);
                        person.setSex(null);
                        person.setBirthDate(null);
                        allPeople.set(Integer.parseInt(args[i]), person);
                    }
                    break;
                }
            }

            case "-c": {
                synchronized (allPeople) {
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

                    Date birthDate = new Date();

                    for (int i = 1; i < args.length; i += 3) {

                        try {
                            birthDate = formatter.parse(args[i + 2]);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        if (args[i + 1].equals("м")) {
                            allPeople.add(Person.createMale(args[i], birthDate));
                        } else if (args[2].equals("ж")) {
                            allPeople.add(Person.createFemale(args[i], birthDate));
                        }

                        System.out.println(allPeople.size() - 1);
                    }
                    break;
                }
            }

            case "-i": {
                synchronized (allPeople) {
                    Person person;
                    SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                    String sex;

                    for (int i = 1; i < args.length; i++) {
                        person = allPeople.get(Integer.parseInt(args[i]));

                        if (person.getSex() == Sex.MALE) {
                            sex = "м";
                        } else {
                            sex = "ж";
                        }
                        System.out.printf("%s %s %s\n", person.getName(), sex, formatForDateNow.format(person.getBirthDate()));
                    }
                    break;
                }
            }
        }
    }
}
