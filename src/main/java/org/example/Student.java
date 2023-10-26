package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Student {
    public final String name;
    private final String secondName;
    private final int course;
    public final double avgScore;

    public double getAvgScore(){
        return avgScore;
    }
    public String getFirstName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getCourse() {
        return course;
    }

    public Student(String name, String secondName, int course, double avgScore) {
        this.name = name;
        this.secondName = secondName;
        this.course = course;
        this.avgScore = avgScore;
    }
}
