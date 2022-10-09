package com.infoshareacademy.entity;

import com.google.gson.GsonBuilder;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import java.util.List;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private double longitude;
    @Column
    private double latitude;
    @Column
    @NotEmpty
    private String town;

    public Location(double longitude, double latitude, String town) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.town = town;
    }
}
