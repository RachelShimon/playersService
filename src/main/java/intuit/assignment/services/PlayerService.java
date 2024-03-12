package intuit.assignment.services;

import intuit.assignment.entities.Player;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 * Service class for managing player data.
 */
@Service
@Log4j2
@AllArgsConstructor
public class PlayerService implements IPlayerService {


    private CsvReaderService csvReaderService;
    private List<Player> players;

    /**
     * Initializes the players list by reading data from CSV file.
     */
    @PostConstruct
    public void init() {
        players = csvReaderService.read();
        log.info("Initialized players list with {} players", players.size());
    }

    /**
     * Retrieves all players.
     *
     * @return A list of all players.
     */
    @Override
    public List<Player> getAllPlayers() {
        return players;
    }

    /**
     * Retrieves a player by their ID.
     *
     * @param playerId The ID of the player to retrieve.
     * @return An Optional containing the player if found, or empty if not found.
     */
    @Override
    public Optional<Player> getPlayerById(String playerId) {
        return players.stream()
                .filter(player -> player.getPlayerID().equals(playerId))
                .findFirst();
    }

}
