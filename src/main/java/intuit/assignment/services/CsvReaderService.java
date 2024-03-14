package intuit.assignment.services;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.MappingStrategy;
import com.opencsv.exceptions.*;
import intuit.assignment.entities.Player;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Collections;
import java.util.List;

import static intuit.assignment.utils.Constants.FILE_PATH;

/**
 * A service class responsible for reading player data from a CSV file.
 */
@Service
@Log4j2
public class CsvReaderService  implements IReader{

    /**
     * Reads player data from a CSV file and returns a list of Player objects.
     *
     * @return A list of Player objects parsed from the CSV file.
     */
    @Override
    public List<Player> read() {
        log.debug("Starting to read from CSV file");
        try (Reader reader = new FileReader(new ClassPathResource(FILE_PATH).getFile())) {
            CsvToBean<Player> csvToBean = createCsvToBean(reader);
            return csvToBean.parse();
        } catch (IOException e) {
            log.error("Error reading from CSV file", e);
            return Collections.emptyList();
        }
    }

    /**
     * Creates and configures a CsvToBean object for parsing CSV data.
     *
     * @param reader The Reader object for reading the CSV file.
     * @return Configured CsvToBean object.
     */
    private CsvToBean<Player> createCsvToBean(Reader reader) {
        return new CsvToBeanBuilder<Player>(reader)
                .withType(Player.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
    }

//    private MappingStrategy<Player> createMappingStrategy() {
//        return new MappingStrategy<Player>() {
//            @Override
//            public void captureHeader(CSVReader csvReader) throws IOException, CsvRequiredFieldEmptyException {
//
//            }
//
//            @Override
//            public String[] generateHeader(Player player) throws CsvRequiredFieldEmptyException {
//                return new String[0];
//            }
//
//            @Override
//            public Player populateNewBean(String[] line) throws CsvException {
//                try {
//                    // Check if the number of columns in the CSV matches the number of fields in the Player class
//                    if (line.length != Player.class.getDeclaredFields().length) {
//                        throw new CsvException("Number of columns in CSV doesn't match Player object");
//                    }
//
//                    // Create a new Player object and set its properties from the CSV data
//                    Player player = new Player();
//                    // Populate player object properties from CSV columns
//                    // Example: player.setPlayerID(line[0]);
//                    //         player.setBirthYear(line[1]);
//                    //         ...
//
//                    return player;
//                } catch (ArrayIndexOutOfBoundsException | TypeConversionException e) {
//                    throw new CsvException("Error mapping CSV to Player object", e);
//                }
//            }
//
//            @Override
//            public void setType(Class<? extends Player> aClass) throws CsvBadConverterException {
//
//            }
//
//            @Override
//            public String[] transmuteBean(Player player) throws CsvFieldAssignmentException, CsvChainedException {
//                return new String[0];
//            }
//
//            @Override
//            public String[] captureHeader(Reader reader) throws IOException {
//                // We don't need to capture headers for now
//                return null;
//            }
//        };
//    }
}
