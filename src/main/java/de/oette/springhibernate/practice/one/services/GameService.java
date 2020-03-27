package de.oette.springhibernate.practice.one.services;

import de.oette.springhibernate.practice.one.model.Game;
import de.oette.springhibernate.practice.one.model.GameModelData;
import de.oette.springhibernate.practice.one.model.GameRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public GameModelData createNewGame() {
        Game game = gameRepository.save(new Game());
        return new GameModelData(game);
    }

    @Transactional
    public GameModelData addPlayer(Integer gameId, String name) {
        Optional<Game> gameOptional = gameRepository.findById(gameId);
        if (gameOptional.isPresent()) {
            Game game = gameOptional.get();
            game.addPlayer(name);
            return new GameModelData(game);
        } else {
            throw new RuntimeException("Game not found");
        }
    }

    @Transactional
    public Optional<GameModelData> loadGame(Integer gameId) {
        Optional<Game> gameOptional = gameRepository.findById(gameId);
        return gameOptional.map(GameModelData::new);
    }

    @Transactional
    public GameModelData finish(Integer gameId) {
        Game game = gameRepository.findById(gameId)
                .orElseThrow(() -> new RuntimeException("Id not found"));
        game.pickRandomLooser();
        return new GameModelData(game);
    }
}