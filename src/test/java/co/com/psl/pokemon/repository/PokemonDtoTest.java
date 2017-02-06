package co.com.psl.pokemon.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.psl.pokemon.model.Pokemon;
import co.com.psl.pokemon.model.Type;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PokemonDtoTest {

	@Autowired
	private PokemonRepository pokemonRepository;

	@Autowired TypeRepository typeRepository;

	
	@Test
	public void pokemonShouldPersist() {
		Pokemon pokemon = new Pokemon("Charmander", typeRepository.findByNameContaining("fire"), typeRepository.findByNameContaining("water"), 0, "http://cartoonbros.com/wp-content/uploads/2016/11/Charmander-3.png");
		long id = pokemon.getId();
		pokemonRepository.save(pokemon);
		Assert.assertNotEquals(id, pokemon.getId());
	}
	
	@Test
	public void typeShouldPersist() {
		Type type = new Type("dragon");
		long id = type.getId();
		typeRepository.save(type);
		Assert.assertNotEquals(id, type.getId());
	}

	

}
