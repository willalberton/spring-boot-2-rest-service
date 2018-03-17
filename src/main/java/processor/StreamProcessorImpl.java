package processor;

import br.com.cinq.exception.NotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author William
 */
public class StreamProcessorImpl implements StreamProcessor {

    private static final Logger log = Logger.getLogger(StreamProcessorImpl.class.getName());

    @Override
    public List<String> readLines(String filePath) {

        List<String> lines = new ArrayList<>();

        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            String line = reader.readLine();
            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }

        } catch (IOException ex) {

            String message = "Error while processing the inputstream " + ex.getMessage();
            log.severe(message);
            throw new NotFoundException(message);
        }

        return lines;
    }

}
