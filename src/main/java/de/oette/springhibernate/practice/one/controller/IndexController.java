package de.oette.springhibernate.practice.one.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class IndexController {

    @GetMapping(value = "/")
    public RedirectView displayIndexPage() {
        return new RedirectView("/game/empty");
    }
}
