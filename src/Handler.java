/**
 * Created by employee on 11/10/16.
 */
public interface Handler {
    HttpRequest request();

    String print(HttpRequest httpRequest);
}
