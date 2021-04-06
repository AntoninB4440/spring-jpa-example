package fr.diginamic.spring.jpa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.spring.jpa.exception.BadRequestException;
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
	// http://<server_url>/api/games/search
	@GetMapping("search")
	public List<Game> findbyName(@RequestParam(required = true) String name) {
		return gameService.findAllByNameLike(name);
	}

	// Methode effectuée lors d'une requete HTTP POST sur
	// http://<server_url>/api/games
	@PostMapping
	public Game create(@Valid @RequestBody Game game, BindingResult br) {
		if (!br.getAllErrors().isEmpty()) {
			System.out.println(br.getAllErrors());
			throw new BadRequestException();
		}
		return gameService.create(game);

	}

	// Methode effectuée lors d'une requete HTTP PUT sur
	// http://<server_url>/api/games/:id -> Body = JSON
	@PutMapping("{id}")
	public Game update(@PathVariable(name = "id") Long id, @RequestBody Game game) {
		game.setId(id);
		return gameService.update(game);
	}

	// Methode effectuée lors d'une requete HTTP Delete sur
	// http://<server_url>/api/games/:id -> Body = JSON
	// @Transactional
	@DeleteMapping("{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		// Game gameFound = gameService.findById(id);
		gameService.deleteById(id);
	}

}
