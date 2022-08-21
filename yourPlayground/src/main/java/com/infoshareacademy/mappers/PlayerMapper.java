package com.infoshareacademy.mappers;

import com.infoshareacademy.dto.PlayerDto;
import com.infoshareacademy.entity.Player;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class PlayerMapper {

    public PlayerDto toDto(Player player) {
        return PlayerDto.builder()
                .id(player.getId())
                .username(player.getUsername())
                .mail(player.getMail())
                .roles(new HashSet<>(player.getRoles()))
                .build();
    }

    public Player toEntity(PlayerDto playerDto) {
        return Player.builder()
                .id(playerDto.getId())
                .username(playerDto.getUsername())
                .mail(playerDto.getMail())
                .roles(new HashSet<>(playerDto.getRoles()))
                .build();
    }
}
