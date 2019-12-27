package com.ifi.trainer_ui.controller;

import com.ifi.trainer_ui.pokemonTypes.bo.PokemonType;
import com.ifi.trainer_ui.pokemonTypes.service.PokemonTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PokemonTypeController {

    @Autowired
    private PokemonTypeService pokemonTypeService;

    @GetMapping("/pokedex")
    public ModelAndView pokedex(){
        List<PokemonType> pokemons = this.pokemonTypeService.listPokemonsTypes();
        return new ModelAndView("pokedex", "pokemonTypes", pokemons);
    }

    void setPokemonTypeService(PokemonTypeService pokemonTypeService) {
        this.pokemonTypeService = pokemonTypeService;
    }
}
