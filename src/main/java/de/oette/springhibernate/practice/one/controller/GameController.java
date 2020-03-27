package de.oette.springhibernate.practice.one.controller;

import de.oette.springhibernate.practice.one.services.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RequestMapping("/game")
@Controller
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/start-new")
    public RedirectView startNewGame() {
        Integer id = gameService.createNewGame();
        return new RedirectView(String.valueOf(id));
    }

    @GetMapping("/{gameId}")
    public ModelAndView displayGame() {
        return new ModelAndView("index");
    }
}
