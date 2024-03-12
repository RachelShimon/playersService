package intuit.assignment.services;

import intuit.assignment.entities.Player;

import java.util.List;

/**
 * An interface for reading player data.
 */
public interface IReader {
    /**
     * Reads player data and returns a list of Player objects.
     *
     * @return A list of Player objects.
     */
    List<Player> read();
}
