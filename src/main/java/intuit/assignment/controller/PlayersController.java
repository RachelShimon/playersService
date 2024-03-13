package intuit.assignment.controller;


import intuit.assignment.entities.Player;
import intuit.assignment.exception.InvalidRequestException;
import intuit.assignment.exception.PlayerNotFoundException;
import intuit.assignment.services.IPlayerService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/players")
public class PlayersController {

    private IPlayerService playerService;

    /**
     * Retrieves all players.
     *
     * @return ResponseEntity containing a list of all players or an empty list if none found.
     */
    @GetMapping
    @Operation(summary = "Get all players")
    public ResponseEntity<List<Player>> getAllPlayers() {
        List<Player> players = playerService.getAllPlayers();
        if (players.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(players);
        }
    }

    /**
     * Retrieves a player by ID.
     *
     * @param playerId The ID of the player to retrieve.
     * @return ResponseEntity containing the player if found, or ResponseEntity.notFound() if not found.
     */
    @GetMapping("/{playerId}")
    @Operation(summary = "Get player by ID")
    public ResponseEntity<Optional<Player>> getPlayerById(@PathVariable String playerId) {
        if (playerId == null || playerId.isEmpty()) {
            throw new InvalidRequestException("Player ID must be provided");
        }
        Optional<Player> player = playerService.getPlayerById(playerId);
        if (player.isPresent()) {
            return ResponseEntity.ok(player);
        } else {
            throw new PlayerNotFoundException(playerId);
        }
    }
}

