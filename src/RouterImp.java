import print.Print;
import print.PrintInWeb;

import java.io.UnsupportedEncodingException;

class RouterImp implements Router {
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
            "<form method=\"LINK\" action=\"http://greater.local:8080/calendar\">\n" +
                    "    <input type=\"submit\" value=\"Calendar\">\n" +
                    "</form>" +
                    "<form method=\"LINK\" action=\"http://greater.local:8080/hello_world\">\n" +
                    "<input type=\"submit\" value=\"Hello World!\">\n" +
                    "</form>";


    static HttpRequestImpl httpRequest = new HttpRequestImpl();
    static void getVariant(StringBuilder builder, String parameters) throws UnsupportedEncodingException {
        if (parameters.contains("/calendar")) {
            builder.append(getPrint()).append(footer);
        }
        if (parameters.contains("/new")) {
            builder.append(header);
            if (parameters.contains("name")) {
                builder.append("Hello").append(httpRequest.getPath(parameters)).append(migrationForm);
            }
            builder.append(footer);
            return;
        }
        if (parameters.contains("/hello_world")) {
            builder.append(header).append(headerForHelloWorld).append(migrationForm).append(footer);
        } else {
            builder.append(header).append(migrationForm).append(footer);
        }
    }

    private static String getPrint() {
        Print calendar = new PrintInWeb();
        return calendar.print();
    }
}