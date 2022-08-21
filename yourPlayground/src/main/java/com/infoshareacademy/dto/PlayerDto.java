package com.infoshareacademy.dto;

import com.infoshareacademy.entity.Role;
import lombok.*;

import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerDto {

    private Integer id;
    private String username;
    private String mail;
    private Set<Role> roles;

}
