package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание 1------------------------------------------------------------");
        List<String> list = new ArrayList<>(Arrays.asList("Ночь", "Компьютер", "Ночь", "Улица", "Компьютер", "Улица", "Ягода"));

        list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getValue)
                .map(maxCount -> list.stream()
                        .filter(word -> list.stream().filter(w -> w.equals(word)).count() == maxCount)
                        .distinct()
                        .sorted(Comparator.comparing(String::length))
                        .collect(Collectors.joining(", ")))
                .ifPresent(System.out::println);


        System.out.println("Задание 2------------------------------------------------------------");
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Will", "Smith", 3, 4.5),
                new Student("Ben", "Johnson", 2, 3.7),
                new Student("Robin", "Williams", 1, 2.8),
                new Student("Perris", "Jones", 3, 3.2),
                new Student("John", "Davis", 2, 2.5),
                new Student("Bob", "Davis", 2, 1.5),
                new Student("Seva", "Prilukov", 4, 3.0)
        ));
        printNOutsiders(students, 2);
    }
    public static void printNOutsiders(List<Student> students, int n) {
        System.out.println(students.stream()
                .sorted(Comparator.comparingDouble(Student::getAvgScore))
                .limit(Math.min(n, students.size()))
                .sorted(Comparator.comparingDouble(Student::getAvgScore).reversed())
                .map(student -> student.getFirstName() + " " + student.getSecondName())
                .collect(Collectors.joining(", ", n + " самых плохих студентов зовут: ", ";")));
    }
}