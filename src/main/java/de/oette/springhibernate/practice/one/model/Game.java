package de.oette.springhibernate.practice.one.model;

import org.apache.commons.lang3.RandomUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Game {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String looser;

    @ElementCollection
    private Set<String> players = new HashSet<>();

    public int getId() {
        return id;
    }

    public void addPlayer(String name) {
        players.add(name);
    }

    public Set<String> getPlayers() {
        return Collections.unmodifiableSet(players);
    }

    public String getLooser() {
        return looser;
    }

    public void pickRandomLooser() {
        int randomIndex = RandomUtils.nextInt(0,players.size());
        this.looser = new ArrayList<>(this.players).get(randomIndex);
    }
}
