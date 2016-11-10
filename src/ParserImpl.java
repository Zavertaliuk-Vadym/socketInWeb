import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by employee on 11/10/16.
 */
class ParserImpl implements Parser {
    private HttpRequest request = new HttpRequestImpl();

    public void parse(InputStream stream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        String parameters = reader.readLine().split(" ")[1];
        request.getVariant(parameters);
    }
}

