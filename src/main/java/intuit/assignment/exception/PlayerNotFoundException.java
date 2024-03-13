package intuit.assignment.exception;

import org.webjars.NotFoundException;

public class PlayerNotFoundException extends NotFoundException {
    public PlayerNotFoundException(String playerId){
        super("Player not found with ID: " + playerId);
    }
}
