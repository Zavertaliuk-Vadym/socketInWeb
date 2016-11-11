/**
 * Created by employee on 11/11/16.
 */
public class GreeterHandler implements Handler {
    static String header = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "<title>Page Title</title>\n" +
            "</head>\n" +
            "<body>\n";

    static String headerForHelloWorld =
            " <form method=\"LINK\" action=\"http://greater.local:8080/hello_world/new\">\n" +
                    "  <p><b>Введите вариант</b></p>\n" +
                    "  <input type=\"text\" name=\"name\" \n<Br>\n" +
                    "  <p><input type=\"submit\"value=\"Let's go!\"></p>\n" +
                    " </form>\n";
    static String footer =
            "</body>\n" +
                    "</html>";


    static String migrationForm =
            "<form method=\"LINK\" action=\"http://greater.local:8080/calendar?name=1234\">\n" +
                    "    <input type=\"submit\" value=\"Calendar\">\n" +
                    "</form>" +
                    "<form method=\"LINK\" action=\"http://greater.local:8080/hello_world\">\n" +
                    "<input type=\"submit\" value=\"Hello World!\">\n" +
                    "</form>";
    private HttpRequest request;

    GreeterHandler(HttpRequest httpRequest) {
        this.request=httpRequest;
    }

    @Override
    public String print(HttpRequest httpRequest) {
        StringBuilder builder = new StringBuilder();
        builder.append(header);
        builder.append("Hello "+httpRequest.getParam().get("name"));
        builder.append(migrationForm).append(footer);
        return builder.toString();
    }
}
