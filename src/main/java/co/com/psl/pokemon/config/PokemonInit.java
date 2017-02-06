package co.com.psl.pokemon.config;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.psl.pokemon.model.Pokemon;
import co.com.psl.pokemon.model.Type;
import co.com.psl.pokemon.repository.PokemonRepository;
import co.com.psl.pokemon.repository.TypeRepository;

@Component
public class PokemonInit { 

	@Autowired
	private PokemonRepository pokemonDto;

	@Autowired
	private TypeRepository typeDto;

	@PostConstruct
	public void pokemonSetUp(){
		System.out.println("Starting setup");
		typeDto.save(new Type("normal"));
		typeDto.save(new Type("electric"));
		typeDto.save(new Type("ground"));
		typeDto.save(new Type("grass"));
		typeDto.save(new Type("poison"));
		typeDto.save(new Type("fire"));
		typeDto.save(new Type("ice"));
		typeDto.save(new Type("flying"));
		typeDto.save(new Type("physic"));
		typeDto.flush();
		List<Type> typePikachu = new ArrayList<Type>();		
		List<Type> weaknessPikachu = new ArrayList<Type>();

		typePikachu.add(typeDto.findOne(1L));
		weaknessPikachu.add(typeDto.findOne(2L));

		pokemonDto.save(new Pokemon("Pikachu",
				typePikachu, weaknessPikachu , 0, "http://www.dondevive.org/wp-content/uploads/2016/07/pikachu.jpg"));

		List<Type> typeBulb = new ArrayList<Type>();		
		List<Type> weaknessBulb = new ArrayList<Type>();

		typeBulb.add(typeDto.findOne(3L));
		typeBulb.add(typeDto.findOne(4L));
		weaknessBulb.add(typeDto.findOne(5L));
		weaknessBulb.add(typeDto.findOne(6L));
		weaknessBulb.add(typeDto.findOne(7L));
		weaknessBulb.add(typeDto.findOne(8L));
		pokemonDto.save(new Pokemon("Bulbasaur",
				typeBulb, weaknessBulb , 0, "http://www.dondevive.org/wp-content/uploads/2016/07/pikachu.jpg"));

		pokemonDto.flush();
	}

}
