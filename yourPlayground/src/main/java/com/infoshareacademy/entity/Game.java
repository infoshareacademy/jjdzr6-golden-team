package com.infoshareacademy.entity;

import com.infoshareacademy.utils.GameType;
import lombok.*;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor

@javax.persistence.Entity
@Table(name = "games")

public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private GameType type;

    @Column
    private int maxNumberOfPlayers;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "game_player_jointable",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn( name = "player_id")
    )
    private Set<Player> players;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location gameLocation;

    @Column
    private LocalDateTime dateOfGame;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private Player gameOwner;

    public Game() {
        this.setPlayers(new HashSet<>());
    }

    public Game(String name, int maxNumberOfPlayers, GameType gameType) {
        this.name = name;
        this.maxNumberOfPlayers = maxNumberOfPlayers;
        this.type = gameType;
    }
}
