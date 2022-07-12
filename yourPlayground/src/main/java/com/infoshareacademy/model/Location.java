package com.infoshareacademy.model;

import com.google.gson.GsonBuilder;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode

public class Location {
    // Fields
    private double longitude;
    private double latitude;
    private String town;

    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }
}
