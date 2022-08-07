package com.infoshareacademy.dto;

import com.infoshareacademy.model.Location;
import com.infoshareacademy.model.Player;
import com.infoshareacademy.utils.GameType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameDto {
    //location rozbic na 3 itp.

    private String name;
   /* private GameType type;
    private int maxNumberOfPlayers;
    private Set<Player> players;
    private Location gameLocation;
    private LocalDateTime dateOfGame;
    private Player gameOwner;*/

}
