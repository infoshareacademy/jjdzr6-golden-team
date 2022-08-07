package com.infoshareacademy.dto;

import com.infoshareacademy.model.Player;
import com.infoshareacademy.utils.GameType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameDto {

    private Integer id;

    private String name;
    private String type;
    private int maxNumberOfPlayers;
    //private Set<Player> players;

    private String town;
    private double latitude;
    private double longitude;

    private String date;
    private String time;

    private String playerName;
    private String email;

}
