package com.example.myapplication;


public class Student {

    private String id;
    private String name;
    private String email;
    private String telephone;


    public Student(
            String id,
            String name,
            String email,
            String telephone
    ){

        this.id = id;
        this.name = name;
        this.email = email;
        this.telephone = telephone;

    }


    public String getId(){

        return id;

    }


    public String getName(){

        return name;

    }


    public String getEmail(){

        return email;

    }


    public String getTelephone(){

        return telephone;

    }


}