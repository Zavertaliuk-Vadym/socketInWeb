import java.io.IOException;
import java.io.InputStream;

/**
 * Created by employee on 11/10/16.
 */
interface Parser {
    void parse(InputStream inputStream) throws IOException;
}
