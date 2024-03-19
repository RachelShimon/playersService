package intuit.assignment.entities;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a player.
 */

@Getter
@Setter
@NoArgsConstructor
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

    @CsvBindByName(column = "throws")
    private String throwsType;

    @CsvBindByName
    private String debut;

    @CsvBindByName
    private String finalGame;

    @CsvBindByName
    private String retroID;

    @CsvBindByName
    private String bbrefID;

}
