package co.com.psl.pokemon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.psl.pokemon.model.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Long>{

	List<Pokemon> findByNameContaining(String name);
}
