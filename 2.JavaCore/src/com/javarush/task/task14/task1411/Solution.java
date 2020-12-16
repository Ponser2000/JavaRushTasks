package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
User, Loser, Coder and Proger
*/

public class Solution{
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = "no";
        String str = null;

        while(true) {

            str = reader.readLine();

            switch (str)
            {
                case "user" : {
                    person = new Person.User();
                    key="yes";
                    doWork(person);
                    break;
                }
                case "loser" : {
                    person = new Person.Loser();
                    key="yes";
                    doWork(person);
                    break;
                }
                case "coder" : {
                    person = new Person.Coder();
                    key="yes";
                    doWork(person);
                    break;
                }
                case "proger" : {
                    person = new Person.Proger();
                    key="yes";
                    doWork(person);
                    break;
                }
                default: {
                    key="no";
                }
            }

            if (key.equals("no")) {
                break;
            }
        }
    }

    public static void doWork(Person person) {
        if (person instanceof Person.User) {
            ((Person.User) person).live();
        } else if (person instanceof Person.Loser) {
            ((Person.Loser) person).doNothing();
        } else if (person instanceof Person.Coder) {
            ((Person.Coder) person).writeCode();
        } else if (person instanceof Person.Proger) {
            ((Person.Proger) person).enjoy();
        }
    }
}
