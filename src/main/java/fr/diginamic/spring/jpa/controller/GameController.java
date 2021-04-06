package fr.diginamic.spring.jpa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.spring.jpa.model.Game;
import fr.diginamic.spring.jpa.service.GameService;

@RestController
@RequestMapping("/api/games")
@Validated
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

	// Methode effectuée lors d'une requete HTTP GET sur
	// http://<server_url>/api/games
	@PostMapping
	public Game create(@Valid @RequestBody Game game) {
		return gameService.create(game);
	}

	// Methode effectuée lors d'une requete HTTP GET sur
	// http://<server_url>/api/games/:id -> Body = JSON
	@PutMapping("{id}")
	public Game update(@PathVariable(name = "id") Long id, @RequestBody Game game) {
		game.setId(id);
		return gameService.update(game);
	}
}
