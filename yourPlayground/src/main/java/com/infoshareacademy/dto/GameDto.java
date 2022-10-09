package com.infoshareacademy.dto;

import com.infoshareacademy.entity.Location;
import com.infoshareacademy.entity.Player;
import com.infoshareacademy.utils.GameType;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameDto {

    private Integer id;

    @NotEmpty
    private String name;

    @NotNull
    private GameType type;

    @Positive
    private int maxNumberOfPlayers;
    private Set<PlayerDto> players;

    @NotNull
    private Location gameLocation;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @FutureOrPresent
    @NotNull
    private LocalDateTime dateOfGame;

    private PlayerDto gameOwner;
}
