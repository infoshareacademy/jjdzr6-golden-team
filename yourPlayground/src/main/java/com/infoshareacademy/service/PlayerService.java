package com.infoshareacademy.service;

import com.infoshareacademy.dto.PlayerDto;
import com.infoshareacademy.entity.Player;
import com.infoshareacademy.entity.Role;
import com.infoshareacademy.entity.SecureUser;
import com.infoshareacademy.mappers.PlayerMapper;
import com.infoshareacademy.repository.PlayerRepository;
import com.infoshareacademy.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PlayerService implements UserDetailsService {

    private final PlayerRepository playerRepository;
    private final RoleRepository roleRepository;
    private final PlayerMapper playerMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Player player = playerRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User: " + username + " does not exist"));
        return map(player);
    }

    public List<PlayerDto> getUsers() {
        return playerRepository.findAll().stream().map(playerMapper::toDto).toList();
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
        secure.setRoles(player.getRoles().stream().map(r -> r.getName()).collect(Collectors.toSet()));
        return secure;
    }

    private PlayerDto toDto(SecureUser user) {
        PlayerDto dto = new PlayerDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setRolesNames(user.getRoles());
        return dto;
    }

    //TODO make save return true or false if saved or not
    public void savePlayer(PlayerDto playerDto) {
        Player entityToSave = playerMapper.toEntity(playerDto);
        Optional<Role> optionalRole = roleRepository.findByName("USER"); //TODO throw exc

        optionalRole.ifPresent(role -> entityToSave.setRoles(Set.of(role)));

        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder(); //TODO Autowire

        entityToSave.setPassword(encoder.encode(entityToSave.getPassword()));

        playerRepository.save(entityToSave);
    }
}