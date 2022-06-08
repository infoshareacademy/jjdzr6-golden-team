package com.infoshareacademy.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Player {
    private String name;
    private String mail;
    private String password;

    public Player(String name, String mail) {
        this.name = name;
        this.mail = mail;
    }

    public Player() {

    }

    //region Getters&Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

    //endregion

    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }
}
