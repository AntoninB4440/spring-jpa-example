package fr.diginamic.spring.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.diginamic.spring.jpa.model.Game;
import fr.diginamic.spring.jpa.model.GameCategory;
import fr.diginamic.spring.jpa.service.GameService;

@Component
public class MainBean {

	@Autowired
	private GameService gameService;

	@PostConstruct
	public void start() {
		System.out.println("Main bean started !");

		List<Game> games = new ArrayList<>();
		games.add(new Game("Hollow Knight", 10, GameCategory.METROIDVANIA, 100));
		games.add(new Game("Castelvania", 1, GameCategory.METROIDVANIA, 88));
		games.add(new Game("Crash Bandicoot", 40, GameCategory.PLATFORM, 85));
		games.add(new Game("Rocket League", 1, GameCategory.ROCKET_LEAGUE, 95));
		games.add(new Game("Need For Speed Heat", 70, GameCategory.RACING, 60));
		for (Game game : games) {
			gameService.create(game);
			System.out.println(game);
		}

		games = gameService.findAll();
		games.forEach(System.out::println);
	}
}
