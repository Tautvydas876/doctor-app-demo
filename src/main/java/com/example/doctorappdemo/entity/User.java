package com.example.doctorappdemo.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "data")
    private String data;

    @Column(name = "username")
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    public User() {
    }

    public User(String data, String userName, String email, String password) {
        this.data = data;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public User(int id, String data, String userName, String email, String password) {
        this.id = id;
        this.data = data;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", data='" + data + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", pass='" + password + '\'' +
                '}';
    }
}
