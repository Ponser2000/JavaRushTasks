package com.javarush.task.task29.task2909.human;

public class UniversityPerson extends Human{

    public UniversityPerson(String name, int age) {
        super(name, age);
        //this.university = university;
    }

    private University university;

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

}
