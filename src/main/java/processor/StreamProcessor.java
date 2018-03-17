package processor;

import java.io.InputStream;
import java.util.List;

/**
 * @author William
 */
public interface StreamProcessor {

    public List<String> readLines(String filePath);

}
