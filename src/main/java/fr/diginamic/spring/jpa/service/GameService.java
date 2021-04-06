package fr.diginamic.spring.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.diginamic.spring.jpa.model.Game;
import fr.diginamic.spring.jpa.repository.GameRepository;

@Transactional
@Service
public class GameService {

	private final GameRepository gameRepository;

	@Autowired
	public GameService(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}

	public List<Game> findAll() {
		return gameRepository.findAll();
	}

	public Game findById(Long id) {
		return gameRepository.findById(id);
	}

	public List<Game> findAllByNameLike(String name) {
		return gameRepository.findByName(name);
	}

	public Game create(Game game) {
		return gameRepository.create(game);
	}

	public Game update(Game game) {
		return gameRepository.update(game);
	}

//	public void delete(Game game) {
//		gameRepository.delete(game);
//	}

	public void deleteById(Long id) {
		Game game = gameRepository.findById(id);
		gameRepository.delete(game);
	}

	// @Transactional
	public void deleteAllGamesStartingWith(String str) {
		// List<Game> games = gameRepository.findAllByNameStartingWith(str);
		// for (game g : games) {
		// gameRepository.delete(g);
		// }
	}
}
