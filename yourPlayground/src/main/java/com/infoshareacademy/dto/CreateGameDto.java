package com.infoshareacademy.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateGameDto {

    @NotEmpty
    private String name;

    @NotEmpty
    private String type;

    @Positive
    private int maxNumberOfPlayers;

    @NotEmpty
    private String town;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @FutureOrPresent
    @NotNull
    private LocalDateTime dateOfGame;
    private PlayerDto gameOwner;

}
