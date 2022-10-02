package com.infoshareacademy.mappers;

import com.infoshareacademy.dto.PlayerDto;
import com.infoshareacademy.entity.Player;
import com.infoshareacademy.entity.Role;
import com.infoshareacademy.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PlayerMapper {

    private final RoleRepository roleRepository;

    public PlayerDto toDto(Player player) {
        return PlayerDto.builder()
                .id(player.getId())
                .username(player.getUsername())
                .mail(player.getMail())
                .rolesNames(player.getRoles().stream().map(Role::getName).collect(Collectors.toSet()))
                .build();
    }

    public Player toEntity(PlayerDto playerDto) {

        Set<Role> roleSet = new HashSet<>();

        for (String role : playerDto.getRolesNames()) {
            if (roleRepository.findByName(role).isPresent()) {
                roleSet.add(roleRepository.findByName(role).get());
            }
        }

        return Player.builder()
                .id(playerDto.getId())
                .username(playerDto.getUsername())
                .mail(playerDto.getMail())
                .password(playerDto.getPassword())
                .roles(roleSet)
                .build();
    }
}
