package de.oette.springhibernate.practice.one.controller;

import de.oette.springhibernate.practice.one.model.GameModelData;
import de.oette.springhibernate.practice.one.services.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@RequestMapping("/game")
@Controller
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/start-new")
    public RedirectView startNewGame() {
        GameModelData modelData = gameService.createNewGame();
        return new RedirectView(String.valueOf(modelData.id));
    }

    @PostMapping("{gameId}/add-player")
    public RedirectView startNewGame(@PathVariable Integer gameId, @RequestParam String name) {
        GameModelData modelData =gameService.addPlayer(gameId, name);
        return new RedirectView(String.format("/game/%s", modelData.id));
    }

    @GetMapping("/{gameId}")
    public Object displayGame(@PathVariable Integer gameId) {
        Optional<GameModelData> modelData = gameService.loadGame(gameId);
        if (modelData.isPresent()) {
            return createIndexView(modelData.get());
        } else {
            return new RedirectView("empty");
        }
    }

    @PostMapping("/{gameId}/finish")
    public ModelAndView finishGame(@PathVariable Integer gameId) {
        GameModelData modelData = gameService.finish(gameId);
        return createIndexView(modelData);
    }

    @GetMapping("/empty")
    public ModelAndView getEmptyGame() {
       return createIndexView(new GameModelData());
    }

    private ModelAndView createIndexView(GameModelData data) {
        ModelAndView modelAndView =  new ModelAndView("index");
        modelAndView.addObject("gameData", data);
        return modelAndView;
    }
}
