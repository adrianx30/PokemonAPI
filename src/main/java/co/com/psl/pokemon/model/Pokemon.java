package co.com.psl.pokemon.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pokemon {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(nullable=false)
	private String name;
	
	@OneToMany
	private List<Type> type;
	
	@OneToMany
	private List<Type> weakness;
	
	private long evolution;
	
	@Column(nullable=false)
	private String image;

	protected Pokemon(){}
	
	public Pokemon(String name, List<Type> type, List<Type> weakness, long evolution, String image) {
		super();
		this.name = name;
		this.type = type;
		this.weakness = weakness;
		this.evolution = evolution;
		this.image = image;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Type> getType() {
		return type;
	}

	public void setType(List<Type> type) {
		this.type = type;
	}

	public List<Type> getWeakness() {
		return weakness;
	}

	public void setWeakness(List<Type> weakness) {
		this.weakness = weakness;
	}

	public long getEvolutionId() {
		return evolution;
	}

	public void setEvolutionId(long evolutionId) {
		this.evolution = evolutionId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	

}
