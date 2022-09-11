package com.infoshareacademy.service;

import com.infoshareacademy.dto.PlayerDto;
import com.infoshareacademy.entity.Player;
import com.infoshareacademy.mappers.PlayerMapper;
import com.infoshareacademy.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PlayerService implements UserDetailsService {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Player player = playerRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User: " + username + " does not exist"));
        return map(player);
    }

    public List<PlayerDto> getUsers() {
        return playerRepository.findAll().stream().map(this::map).map(this::toDto).toList();
    }

    public PlayerDto findByUsername(String username) {
        Optional<Player> player = playerRepository.findByUsername(username);

        return playerMapper.toDto(player.get());
    }

    private SecureUser map(Player player) {
        SecureUser secure = new SecureUser();
        secure.setId(player.getId());
        secure.setUsername(player.getUsername());
        secure.setPassword(player.getPassword());
        secure.setRoles(player.getRoles());
        return secure;
    }

    private PlayerDto toDto(SecureUser user) {
        PlayerDto dto = new PlayerDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setRoles(user.getRoles());
        return dto;
    }

    //TODO make save return true or false if saved or not
    public void savePlayer(PlayerDto playerDto) {
        playerRepository.save(playerMapper.toEntity(playerDto));
    }
}