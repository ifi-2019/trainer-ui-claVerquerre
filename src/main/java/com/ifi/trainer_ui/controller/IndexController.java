package com.ifi.trainer_ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping(path = "/registerTrainer")
    public ModelAndView registerNewTrainer(@RequestParam("trainerName") String name) {
        ModelAndView modelAndView = new ModelAndView("register");
        modelAndView.addObject("name", name);
        return modelAndView;
    }
}
