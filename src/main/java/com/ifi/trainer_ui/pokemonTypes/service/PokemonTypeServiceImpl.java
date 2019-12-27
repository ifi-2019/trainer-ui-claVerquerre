package com.ifi.trainer_ui.pokemonTypes.service;

import com.ifi.trainer_ui.pokemonTypes.bo.PokemonType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService{

    private RestTemplate restTemplate;
    private String pokemonServiceUrl;

    @Override
    public List<PokemonType> listPokemonsTypes() {
        String url = pokemonServiceUrl + "/pokemon-types/";
        var pokemons = restTemplate.getForObject(url, PokemonType[].class);
        if (pokemons != null) {
            return Arrays.asList(pokemons);
        }
        return new ArrayList<>();
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${pokemonType.service.url}")
    void setPokemonTypeServiceUrl(String pokemonServiceUrl) {
        this.pokemonServiceUrl = pokemonServiceUrl;
    }
}
