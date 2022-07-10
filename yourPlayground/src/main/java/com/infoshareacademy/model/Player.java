package com.infoshareacademy.model;

import com.google.gson.GsonBuilder;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode

public class Player {
    private String name;
    private String mail;

    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }
}
