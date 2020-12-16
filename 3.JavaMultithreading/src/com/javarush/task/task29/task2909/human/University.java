package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> students  = new ArrayList<>();
    private String name;
    private int age;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double value) {
        //TODO:
        Student result = null;
        for(Student student:students){
            if(student.getAverageGrade() == value) {
                result = student;
                break;
            }
        }
        return result;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        Student result = null;
        double max = students.get(0).getAverageGrade();
        for(Student student:students){
            if(max <= student.getAverageGrade()) {
                result = student;
                max = student.getAverageGrade();
            }
        }
        return result;
    }

    public Student getStudentWithMinAverageGrade() {
        //TODO:
        Student result = null;
        double min = students.get(0).getAverageGrade();

        for(Student student:students){
            if(min >= student.getAverageGrade()) {
                result = student;
                min = student.getAverageGrade();
            }
        }
        return result;
    }


    public void expel(Student student) {
        //TODO:
        students.remove(student);
    }


    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}