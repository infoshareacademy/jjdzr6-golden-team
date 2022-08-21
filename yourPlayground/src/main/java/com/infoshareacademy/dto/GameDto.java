package com.infoshareacademy.dto;

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

    private String town;
    private double latitude;
    private double longitude;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @FutureOrPresent
    private LocalDateTime dateTime;

    private Player gameOwner;

}
