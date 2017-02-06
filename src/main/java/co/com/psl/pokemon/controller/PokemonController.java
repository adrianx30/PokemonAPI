package co.com.psl.pokemon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.psl.pokemon.model.Pokemon;
import co.com.psl.pokemon.model.Type;
import co.com.psl.pokemon.repository.PokemonRepository;
import co.com.psl.pokemon.repository.TypeRepository;

@RestController
public class PokemonController {

	@Autowired
	private PokemonRepository pokemonDto;

	@Autowired
	private TypeRepository typeDto;

	@RequestMapping(value="/pokemon", method = RequestMethod.GET)
	public @ResponseBody List<Pokemon> getAllPokemon(@RequestParam(value = "name", required = false) String nameOrNull) {	
		if (nameOrNull == null || nameOrNull.isEmpty()){
			return pokemonDto.findAll();
		}else{
			return pokemonDto.findByNameContaining(nameOrNull);
		}
	}

	@RequestMapping(value="/pokemon/{pokemonId}", method = RequestMethod.GET)
	public @ResponseBody Pokemon getPokemonById(@PathVariable("pokemonId") long pokemonId) {	
		return pokemonDto.findOne(pokemonId);
	}

	@RequestMapping(value="/pokemon/types", method = RequestMethod.GET)
	public @ResponseBody List<Type> getAllTypesList(@RequestParam(value = "name", required = false)String nameOrNull) {	
		if (nameOrNull == null || nameOrNull.isEmpty()){
			return typeDto.findAll();
		}else{
			return typeDto.findByNameContaining(nameOrNull);
		}
	}

	@RequestMapping(value="/pokemon/types/{typeId}", method = RequestMethod.GET)
	public @ResponseBody Type getTypesListById(@PathVariable("typeId") long typeId) {	
		return typeDto.findOne(typeId);
	}

}
