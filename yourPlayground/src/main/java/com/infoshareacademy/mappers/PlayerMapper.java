package com.infoshareacademy.mappers;

import com.infoshareacademy.dto.PlayerDto;
import com.infoshareacademy.entity.Player;
import com.infoshareacademy.entity.Role;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.stream.Collectors;

@Component
public class PlayerMapper {

    public PlayerDto toDto(Player player) {
        return PlayerDto.builder()
                .id(player.getId())
                .username(player.getUsername())
                .mail(player.getMail())
                .rolesNames(player.getRoles().stream().map(Role::getName).collect(Collectors.toSet()))
                .build();
    }

    public Player toEntity(PlayerDto playerDto) {
        return Player.builder()
                .id(playerDto.getId())
                .username(playerDto.getUsername())
                .mail(playerDto.getMail())
                .password(playerDto.getPassword())
                .build();
    }
}
