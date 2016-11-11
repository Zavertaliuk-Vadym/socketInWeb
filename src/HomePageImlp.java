/**
 * Created by employee on 11/11/16.
 */
public class HomePageImlp implements Handler {
    static String header = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "<title>Page Title</title>\n" +
            "</head>\n" +
            "<body>\n";
    static String footer =
            "</body>\n" +
                    "</html>";


    static String migrationForm =
            "<form method=\"LINK\" action=\"http://greater.local:8080/calendar?\">\n" +
                    "    <input type=\"submit\" value=\"Calendar\">\n" +
                    "</form>" +
                    "<form method=\"LINK\" action=\"http://greater.local:8080/hello_world?\">\n" +
                    "<input type=\"submit\" value=\"Hello World!\">\n" +
                    "</form>";

    public HomePageImlp(HttpRequest httpRequest) {
    }

    @Override
    public String print(HttpRequest httpRequest) {
        return header+migrationForm+footer;
    }
}
