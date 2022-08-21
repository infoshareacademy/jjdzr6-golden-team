package com.infoshareacademy.entity;

import com.google.gson.GsonBuilder;
import lombok.*;

import javax.persistence.*;
import javax.persistence.Entity;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private double longitude;
    @Column
    private double latitude;
    @Column
    private String town;

    public Location(double longitude, double latitude, String town) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.town = town;
    }

    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }
}
