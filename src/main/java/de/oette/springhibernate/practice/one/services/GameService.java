package de.oette.springhibernate.practice.one.services;

import de.oette.springhibernate.practice.one.model.Game;
import de.oette.springhibernate.practice.one.model.GameRepository;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Integer createNewGame() {
        Game game = gameRepository.save(new Game());
        return game.getId();
    }

}
