package com.example.jmh;


import jakarta.persistence.*;

@Entity
@Table(name = "User", schema = "test")
public class User {

    @Id
    private int id;
    private String name;
    private String email;

    public User(int i, String s, String s1) {
        id = i;
        name = s;
        email = s1;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}