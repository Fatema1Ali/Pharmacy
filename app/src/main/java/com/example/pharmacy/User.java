package com.example.pharmacy;

public class User {
    String name,username,password;
    int age;
    public  User(String name, String username,String password,int age){
        this.name=name;
        this.username=username;
        this.age=age;
        this.password=password;
    }
    public  User(String username,String password){
        this.username=username;
        this.password=password;
        this.age=-1;
        this.name="";

    }

}
