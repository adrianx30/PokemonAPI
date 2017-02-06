package co.com.psl.pokemon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.psl.pokemon.model.Type;

public interface TypeRepository extends JpaRepository<Type, Long>{
	
	List<Type> findByNameContaining(String name);

}
