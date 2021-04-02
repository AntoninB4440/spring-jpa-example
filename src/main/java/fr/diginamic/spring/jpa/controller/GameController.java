package fr.diginamic.spring.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.spring.jpa.model.Game;
import fr.diginamic.spring.jpa.service.GameService;

@RestController
@RequestMapping("/api/games")
public class GameController {

	private final GameService gameService;

	@Autowired
	public GameController(GameService gameService) {
		this.gameService = gameService;
	}

	// Methode effectuée lors d'une requete HTTP GET sur
	// http://<server_url>/api/games
	@RequestMapping(method = RequestMethod.GET)
	public List<Game> findAll() {
		return gameService.findAll();
	}
}
