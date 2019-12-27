package com.ifi.trainer_ui.controller;

import com.ifi.trainer_ui.trainers.bo.Trainer;
import com.ifi.trainer_ui.trainers.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TrainerController {

    @Autowired
    private TrainerService trainerService;

    @GetMapping("/trainers")
    public ModelAndView trainers(){
        List<Trainer> trainers = trainerService.listTrainers();
        return new ModelAndView("trainers", "trainers", trainers);
    }

    void setTrainerService(TrainerService trainerService) {
        this.trainerService = trainerService;
    }
}