package co.com.psl.pokemon.controller;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ResourceProperties.Content;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PokemonControllerTest {

	@Autowired
	private MockMvc mockMvc;


	@Test
	public void paramPokemonShouldReturnPokemonFound() throws Exception {
		mockMvc.perform(get("/pokemon").param("name", "kach"))
		.andDo(print()).andExpect(status().isOk())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$").exists())
		.andExpect(jsonPath("$[0].id").value("1"))
		.andExpect(jsonPath("$[0].name").value("Pikachu")
				);
	}

	@Test
	public void getAllShouldReturnAllPokemon() throws Exception {
		mockMvc.perform(get("/pokemon"))
		.andDo(print()).andExpect(status().isOk())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(2)))
		.andExpect(jsonPath("$[0].id").exists())
		.andExpect(jsonPath("$[0].name").exists())
		.andExpect(jsonPath("$[0].type").exists())
		.andExpect(jsonPath("$[0].weakness").exists())
		.andExpect(jsonPath("$[0].evolutionId").exists())
		.andExpect(jsonPath("$[0].image").exists()
				);
	}

	@Test
	public void getPokemonByIdShouldReturnPokemon() throws Exception {
		mockMvc.perform(get("/pokemon/1"))
		.andDo(print()).andExpect(status().isOk())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$").exists())
		.andExpect(jsonPath("$.id").value("1"))
		.andExpect(jsonPath("$.name").value("Pikachu")
				);
	}

	/*@Test
	public void searchForNonExistingPokemonShouldReturnNothing() throws Exception {
		String expected = "";
		mockMvc.perform(get("/pokemon/400"))
		.andDo(print()).andExpect(status().isOk())
		.andExpect(content().json(expected)		
				);
	}*/

	@Test
	public void getTypesShouldReturnAllTypes() throws Exception {
		mockMvc.perform(get("/pokemon/types"))
		.andDo(print()).andExpect(status().isOk())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(9)))
		.andExpect(jsonPath("$[0].id").exists())
		.andExpect(jsonPath("$[0].name").exists()
				);
	}

	@Test
	public void paramTypesShouldReturnTypeFound() throws Exception {
		mockMvc.perform(get("/pokemon/types").param("name", "oi"))
		.andDo(print()).andExpect(status().isOk())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(1)))
		.andExpect(jsonPath("$[0].id").value("5"))
		.andExpect(jsonPath("$[0].name").value("poison")
				);
	}


	@Test
	public void getTypesByIdShouldReturnType() throws Exception {
		mockMvc.perform(get("/pokemon/types/1"))
		.andDo(print()).andExpect(status().isOk())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$").exists())
		.andExpect(jsonPath("$.id").value("1"))
		.andExpect(jsonPath("$.name").value("normal")
				);
	}
}
