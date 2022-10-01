package com.infoshareacademy.dto;

import com.infoshareacademy.utils.GameType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FindGameDto {

    private String name;
    private String type;
    private String town;
    private LocalDate dateOfGame;
}
