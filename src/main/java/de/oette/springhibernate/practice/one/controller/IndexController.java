package de.oette.springhibernate.practice.one.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

public class IndexController {

    @GetMapping(value = "/")
    public ModelAndView displayIndexPage() {
        return new ModelAndView("index.html");
    }
}
