package com.javarush.task.task17.task1710;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        switch (args[0]) {
            case "-u" : {
                Person person = allPeople.get(Integer.parseInt(args[1]));
                person.setName(args[2]);

                if (args[3].equals("м")) {
                    person.setSex(Sex.MALE);
                } else if (args[3].equals("ж")) {
                    person.setSex(Sex.FEMALE);
                }



                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                try {
                    person.setBirthDate(formatter.parse(args[4]));
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                allPeople.set(Integer.parseInt(args[1]),person);
                break;
            }
            case "-d" : {
                 Person person = allPeople.get(Integer.parseInt(args[1]));
                 person.setName(null);
                 person.setSex(null);
                 person.setBirthDate(null);
                 allPeople.set(Integer.parseInt(args[1]),person);
                break;
            }
            case "-c" : {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

                Date birthDate = new Date();

                try {
                    birthDate =  formatter.parse(args[3]);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }

                if (args[2].equals("м")) {
                    allPeople.add(Person.createMale(args[1], birthDate));
                } else if (args[2].equals("ж")) {
                    allPeople.add(Person.createFemale(args[1], birthDate));
                }

                System.out.println(allPeople.size()-1);
                break;
            }
            case "-i" : {
                Person person = allPeople.get(Integer.parseInt(args[1]));
                SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH);
                String sex;
                if (person.getSex() == Sex.MALE) {
                    sex = "м";
                } else {
                    sex = "ж";
                }
                System.out.printf("%s %s %s",person.getName(),sex,formatForDateNow.format(person.getBirthDate()));
                break;
            }
        }
    }
}
