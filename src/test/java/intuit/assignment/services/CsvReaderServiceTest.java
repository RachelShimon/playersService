package intuit.assignment.services;

import com.opencsv.bean.CsvToBean;
import intuit.assignment.entities.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Collections;
import java.util.List;

import static intuit.assignment.utils.Constants.FILE_PATH;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
class CsvReaderServiceTest {


    @Mock
    private ResourceLoader resourceLoader;

    @Mock
    private Resource resource;

    @Mock
    private Reader reader;

    @Mock
    private CsvToBean<Player> csvToBean;

    private CsvReaderService csvReaderService;

    /**
     * Sets up the necessary mocks and initializes the CsvReaderService instance before each test method.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        csvReaderService = new CsvReaderService();
    }

    /**
     * Tests the successful reading of player data from a CSV file.
     *
     * @throws IOException if an I/O error occurs
     */

    @Test
    void testRead() throws IOException {
        // Arrange
        when(resourceLoader.getResource(anyString())).thenReturn(resource);
        when(csvToBean.parse()).thenReturn(Collections.emptyList());

        long csvRows = countRows();
        // Act
        List<Player> players = csvReaderService.read();

        // Assert
        assertNotNull(players);
        assertEquals(csvRows-1,players.size());

        // Verify no more interactions
        verifyNoMoreInteractions(resourceLoader, resource, csvToBean);
    }



    /**
     * Counts the number of rows in a CSV file.
     *
     * @return The number of rows in the CSV file.
     * @throws IOException if an I/O error occurs
     */
    public static int countRows() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new ClassPathResource(FILE_PATH).getFile()))) {
            int rowCount = 0;
            while (reader.readLine() != null) {
                rowCount++;
            }
            return rowCount;
        }
    }
}
