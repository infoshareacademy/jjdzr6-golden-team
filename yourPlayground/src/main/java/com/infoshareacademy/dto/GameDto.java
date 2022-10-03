package com.infoshareacademy.dto;

import com.infoshareacademy.entity.Location;
import com.infoshareacademy.entity.Player;
import com.infoshareacademy.utils.GameType;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameDto {

    private Integer id;

    private String name;
    private GameType type;
    private int maxNumberOfPlayers;
    private Set<PlayerDto> players;

    private Location gameLocation;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @FutureOrPresent
    private LocalDateTime dateOfGame;

    private PlayerDto gameOwner;
}
