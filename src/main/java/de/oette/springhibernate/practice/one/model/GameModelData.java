package de.oette.springhibernate.practice.one.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("ALL")
public class GameModelData {

    public final Integer id;
    public final String looser;
    public final Set<String> playerNames = new HashSet<>();

    public GameModelData(Game game) {
        this.id = game.getId();
        this.looser = game.getLooser();
        this.playerNames.addAll(game.getPlayers());
    }

    public GameModelData() {
        this.id = null;
        this.looser = null;
    }
}
