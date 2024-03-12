package intuit.assignment.services;

import intuit.assignment.entities.Player;

import java.util.List;
import java.util.Optional;

/**
 * Interface for managing player data.
 */
public interface IPlayerService {

    /**
     * Retrieves all players.
     *
     * @return A list of all players.
     */
    List<Player> getAllPlayers();

    /**
     * Retrieves a player by their ID.
     *
     * @param playerId The ID of the player to retrieve.
     * @return An Optional containing the player if found, or empty if not found.
     */
    Optional<Player> getPlayerById(String playerId);
}
