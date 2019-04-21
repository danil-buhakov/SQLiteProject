package com.skillup.bigdig.databaseproject;

import android.support.annotation.NonNull;

public class Person {
    int id;
    String name;
    String email;

    public Person(String name, String email){
        this.name = name;
        this.email = email;
    }

    public Person(String name, String email, int id){
        this.name = name;
        this.email = email;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NonNull
    @Override
    public String toString() {
        return String.valueOf(id)+" "+name+" "+email;
    }
}
