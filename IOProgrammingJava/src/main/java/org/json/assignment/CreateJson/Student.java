package org.json.assignment.CreateJson;
import java.util.List;

public class Student{
    String name;
    int age;
    List<String> subjects;

    Student(String name, int age, List<String> subjects){
        this.name=name;
        this.age=age;
        this.subjects=subjects;
    }
}
