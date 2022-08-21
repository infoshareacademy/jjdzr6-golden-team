package com.infoshareacademy.entity;

import com.google.gson.GsonBuilder;
import com.infoshareacademy.service.GameServiceImpl;
import com.infoshareacademy.utils.GameType;
import lombok.*;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)

@javax.persistence.Entity
@Table(name = "games")

public class Game extends GameServiceImpl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private GameType type;

    @Column
    private int maxNumberOfPlayers;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "players_id", referencedColumnName = "id")
    private Set<Player> players;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location gameLocation;

    @Column
    private LocalDateTime dateOfGame;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
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

    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }
}
