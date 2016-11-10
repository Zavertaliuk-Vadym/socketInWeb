import print.Print;
import print.PrintInWeb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

class Handler {
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
    static String migrationForm=
            "<form method=\"LINK\" action=\"http://greater.local:8080/calendar\">\n" +
                    "    <input type=\"submit\" value=\"Calendar\">\n" +
                    "</form>" +
                    "<form method=\"LINK\" action=\"http://greater.local:8080/hello_world\">\n" +
                    "<input type=\"submit\" value=\"Hello World!\">\n" +
                    "</form>"
            ;

    static String fillingPage(StringBuilder builder, Socket socket) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String parameters = reader.readLine().split(" ")[1];
        if (isContains(parameters, "/calendar")) {
            builder.append(getPrint()).append(footer).append(migrationForm);
        } else if (isContains(parameters, "/new")) {
            builder.append(header);
            if (isContains(parameters, "name")) {
                builder.append("Hello").append(ParserUrl.parseUrl(parameters));
                builder.append(migrationForm);
            }
            builder.append(footer);
        } else if (isContains(parameters, "/hello_world")) {
            builder.append(header);
            builder.append(headerForHelloWorld);
            builder.append(migrationForm);
            builder.append(footer);
        } else {
            builder.append(header);
            builder.append(migrationForm);
            builder.append(footer);
        }
        return builder.toString();
    }
    private static String getPrint() {
        Print calendar = new PrintInWeb();
        return calendar.print();
    }

    static boolean isContains(String parameters, String s) {
        return parameters.contains(s);
    }
}