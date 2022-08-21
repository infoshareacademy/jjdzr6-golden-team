package com.infoshareacademy.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerDto {

    private Integer id;
    private String username;
    private String mail;
    private List<String> roles;

}
