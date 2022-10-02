package com.infoshareacademy.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateGameDto {


    private String name;
    private String type;
    private int maxNumberOfPlayers;
    private String town;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @FutureOrPresent
    private LocalDateTime dateOfGame;
    private PlayerDto gameOwner;

}
