package com.example.demo.model;

public class User {
    private String fname;
    private String lname;
    private int age;
    //Default constructor
    public User(String fname, String lname, int age){
        this.fname = fname;
        this.lname = lname;
        this.age = age;

    }

    //Configure all the getters
    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public int getAge() {
        return age;
    }
}
