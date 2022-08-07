package com.infoshareacademy.model;

public interface Entity<Id> {

    Id getId();

    void setId(Id id);
}
