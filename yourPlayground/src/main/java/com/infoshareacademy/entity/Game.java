package com.infoshareacademy.entity;

import com.infoshareacademy.utils.GameType;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@EqualsAndHashCode

@javax.persistence.Entity
@Table(name = "games")

public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    @Enumerated(EnumType.STRING)
    private GameType type;

    @Column
    private int maxNumberOfPlayers;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "game_player_jointable",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn( name = "player_id")
    )
    private Set<Player> players;

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location gameLocation;

    @Column
    private LocalDateTime dateOfGame;

    @ManyToOne
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
