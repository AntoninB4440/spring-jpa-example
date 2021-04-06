package fr.diginamic.spring.jpa.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String name;

	@Positive
	private Integer price;

	@Min(value = 0)
	@Max(value = 100L, message = "Le rating doit être inférieur à 100")
	private Integer rating;

	@Enumerated(EnumType.STRING)
	private GameCategory category;

	public Game() {
	}

	public Game(String name, Integer price, GameCategory category, Integer rating) {
		this.name = name;
		this.price = price;
		this.category = category;
		this.rating = rating;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public GameCategory getCategory() {
		return category;
	}

	public void setCategory(GameCategory category) {
		this.category = category;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Game{" + "id=" + id + ", name='" + name + '\'' + ", price=" + price + ", category=" + category + '}';
	}
}
