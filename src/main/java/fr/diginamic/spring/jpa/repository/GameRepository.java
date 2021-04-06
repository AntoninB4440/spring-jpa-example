package fr.diginamic.spring.jpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.diginamic.spring.jpa.model.Game;

@Transactional
@Repository
public class GameRepository {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Finds all games.
	 * 
	 * @return The list of all games.
	 */
	public List<Game> findAll() {
		TypedQuery<Game> query = entityManager.createQuery("from Game", Game.class);
		return query.getResultList();
	}

	/**
	 * Finds a game by its id.
	 * 
	 * @param id The id.
	 * @return
	 */
	public Game findById(Long id) {
		return entityManager.find(Game.class, id);
	}

	/**
	 * Finds all game where name containing the given string/
	 * 
	 * @param name The string.
	 * @return The list of matching games
	 */
	public List<Game> findByName(String name) {
		TypedQuery<Game> query = entityManager.createQuery("from Game where name like ?1", Game.class);
		query.setParameter(1, "%" + name + "%");
		return query.getResultList();
	}

	/**
	 * Creates a game.
	 * 
	 * @param game The game to create.
	 * @return The created game, with its id fed.
	 */
	public Game create(Game game) {
		entityManager.persist(game);
		return game;
	}

	/**
	 * Updates a game.
	 * 
	 * @param game The game to update.
	 * @return The updated game.
	 */
	public Game update(Game game) {
		entityManager.merge(game);
		return game;
	}

	/**
	 * Deletes a game.
	 * 
	 * @param game The game to delete.
	 */
	public void delete(Game game) {
		entityManager.remove(game);
	}
}
