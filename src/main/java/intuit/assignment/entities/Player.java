package intuit.assignment.entities;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a baseball player.
 */

@Getter
@Setter
@AllArgsConstructor
public class Player {
    @CsvBindByName
    private String playerID;

    @CsvBindByName
    private String birthYear;

    @CsvBindByName
    private String birthMonth;

    @CsvBindByName
    private String birthDay;

    @CsvBindByName
    private String birthCountry;

    @CsvBindByName
    private String birthState;

    @CsvBindByName
    private String birthCity;

    @CsvBindByName
    private String deathYear;

    @CsvBindByName
    private String deathMonth;

    @CsvBindByName
    private String deathDay;

    @CsvBindByName
    private String deathCountry;

    @CsvBindByName
    private String deathState;

    @CsvBindByName
    private String deathCity;

    @CsvBindByName
    private String nameFirst;

    @CsvBindByName
    private String nameLast;

    @CsvBindByName
    private String nameGiven;

    @CsvBindByName
    private String weight;

    @CsvBindByName
    private String height;

    @CsvBindByName
    private String bats;

    @CsvBindByName
    private String throwsType;

    @CsvBindByName
    private String debut;

    @CsvBindByName
    private String finalGame;

    @CsvBindByName
    private String retroID;

    @CsvBindByName
    private String bbrefID;

    public Player(){
        // Default constructor for CSV parsing library
    }

}
