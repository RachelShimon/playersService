package intuit.assignment.controllers;

import intuit.assignment.controller.PlayersController;
import intuit.assignment.entities.Player;
import intuit.assignment.exception.PlayerNotFoundException;
import intuit.assignment.services.IPlayerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class PlayersControllerTest {

    @Mock
    private IPlayerService playerService;

    private  PlayersController playersController;

    private Player player1;
    private final List<Player> players = new ArrayList<>();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        playersController = new PlayersController(playerService);

        player1 = new Player(
                "1", "1990", "01", "15", "USA", "CA", "Los Angeles",
                null, null, null, null, null, null,
                "John", "Doe", "John Michael Doe",
                "180", "6'2\"", "Right", "Right",
                "2010-07-15", "2015-09-30",
                "doe01", "doe01"
        );

        Player player2 = new Player(
                "2", "1988", "05", "20", "Canada", "ON", "Toronto",
                null, null, null, null, null, null,
                "Alice", "Smith", "Alice Marie Smith",
                "170", "5'8\"", "Left", "Left",
                "2012-04-01", "2018-10-15",
                "smith01", "smita02"
        );

        players.add(player1);
        players.add(player2);
    }


    /**
     * Test case to verify the retrieval of all players.
     */
    @Test
    void givenListPlayerMockWhenCallGetAllPlayersThenAllPlayersWillReturn() {

        when(playerService.getAllPlayers()).thenReturn(players);

        ResponseEntity<List<Player>> responseEntity = playersController.getAllPlayers();

        assertEquals(2, Objects.requireNonNull(responseEntity.getBody()).size());
        assertEquals(players, responseEntity.getBody());
        assertEquals(200, responseEntity.getStatusCode().value());

        verify(playerService, times(1)).getAllPlayers();
        verifyNoMoreInteractions(playerService);
    }

    /**
     * Test case to verify the retrieval of a player by ID.
     */
    @Test
    void givenMockPlayerWhenCallGetByIDThenReturnTheActualPlayer() {

        Player player = player1;
        Optional<Player> optionalPlayer = Optional.of(player);

        when(playerService.getPlayerById("1")).thenReturn(optionalPlayer);

        ResponseEntity<Player> responseEntityFound = playersController.getPlayerById("1");

        assertEquals(player, Objects.requireNonNull(responseEntityFound.getBody()));
        assertEquals(200, responseEntityFound.getStatusCode().value());

        verify(playerService, times(1)).getPlayerById("1");
        verifyNoMoreInteractions(playerService);
    }

    @Test
    void givenMockPlayerWhenCallGetByIDWithIDNotExistThenThrowsPlayerNotFoundException() {

        when(playerService.getPlayerById("2")).thenReturn(Optional.empty());

        assertThrows(PlayerNotFoundException.class,()->playersController.getPlayerById("2"));

        verify(playerService, times(1)).getPlayerById("2");
        verifyNoMoreInteractions(playerService);
    }
}

