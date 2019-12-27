package com.ifi.trainer_ui.trainers.service;

import com.ifi.trainer_ui.pokemonTypes.bo.PokemonType;
import com.ifi.trainer_ui.pokemonTypes.service.PokemonTypeService;
import com.ifi.trainer_ui.trainers.bo.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService{

    private RestTemplate restTemplate;
    private String pokemonServiceUrl;

    @Override
    public List<Trainer> listTrainers() {
        String url = pokemonServiceUrl + "/trainers/";
        var trainers = restTemplate.getForObject(url, Trainer[].class);
        if (trainers != null) {
            return Arrays.asList(trainers);
        }
        return new ArrayList<>();
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${trainer.service.url}")
    void setTrainerServiceUrl(String trainerServiceUrl) {
        this.pokemonServiceUrl = pokemonServiceUrl;
    }
}
