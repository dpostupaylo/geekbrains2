package com.gb.postupaylo.quarter.two.homework3;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    private String[] names = new String[] {
            "Andrey",
            "Evgeniy",
            "Alexey",
            "Dmitry",
            "Stepan",
            "Dmitry",
            "Alexander",
            "Andrey",
            "Alexander",
            "Michail",
            "Evgeniy",
            "Nikolay",
            "Nikolay",
            "Alexey",
            "Alexey",
            "Alexey",
            "Alexey"
    };

    public static void main(String[] args) {
        Application application = new Application();
        application.task1();
        application.task2();
    }


    public void task1() {
        System.out.println("******************************************");

        List<String> uniqueNames = Arrays.stream(names).distinct().collect(Collectors.toList());
        uniqueNames.forEach(System.out::println);

        Map<String, Integer> amount = new HashMap<>();

        for (String name : names) {
            if (amount.containsKey(name))
                amount.put(name, amount.get(name) + 1);
            else
                amount.put(name, 1);
        }

        System.out.println("******************************************");

        amount.forEach( (name, count) -> System.out.println(String.format("%s - %d ", name, count)));


        System.out.println("******************************************");
        System.out.println();
    }

    public void task2(){
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Ivanov", "+7937794777");
        phoneBook.add("Ivanov", "+7937794778");
        phoneBook.add("Ivanov", "+7937794779");
        phoneBook.add("Petrov", "+7937794789");
        phoneBook.add("Petrov", "+7937794788");
        phoneBook.add("Petrov", "+7937794787");
        phoneBook.add("Sidorov", "+7937794787");
        phoneBook.add("Nikolaev", "+7937794787");
        phoneBook.add("Petrov", "+7937794687");
        phoneBook.add("Petrov", "+7937795787");
        phoneBook.add("Petrov", "+7937784787");
        phoneBook.add("Petrov", "+7937694787");


        System.out.println(phoneBook.get("Petrov"));
    }
}
