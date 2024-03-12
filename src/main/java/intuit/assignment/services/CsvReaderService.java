package intuit.assignment.services;


import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
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
}
