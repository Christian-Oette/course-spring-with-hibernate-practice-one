package de.oette.springhibernate.practice.one.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("ALL")
public class GameModelData {

    public final Integer id;
    public final String looser;
    public final Set<String> playerNames;

    public GameModelData(Game game) {
        this.id = game.getId();
        this.looser = game.getLooser();
        this.playerNames = game.getPlayers();
    }

    public GameModelData() {
        this.id = null;
        this.looser = null;
        this.playerNames = new HashSet<>();
    }
}
