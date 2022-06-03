package com.infoshareacademy.model;

public class Player {
    private String name;
    private String mail;

    public Player(String name, String mail) {
        this.name = name;
        this.mail = mail;
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

    //endregion

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
