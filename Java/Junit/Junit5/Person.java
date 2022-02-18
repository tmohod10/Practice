package com.company;

public class Person {
    private String name;

    // other way for fall backString conversion
    // if a class have a static method which takes a single
    // String parameter as an argument
    // When doing this remove the constructor
    public static Person valueOf(String name) {
        Person person = new Person();
        person.name = name;
        return person;
    }

//    public Person(String name) {
//        this.name = name;
//    }

    public String getName() {
        return name;
    }
}
