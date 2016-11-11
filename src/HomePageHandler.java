/**
 * Created by employee on 11/11/16.
 */
public class HomePageHandler implements Handler {
    static String header = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "<title>Page Title</title>\n" +
            "</head>\n" +
            "<body>\n";
    static String footer =
            "</body>\n" +
                    "</html>";

//http://greater.local:8080/calendar?day=12&month=10&year=2016&dayOfWeek=5&weekends=6,1
    static String formForCalendar =
            " <form action=\"http://greater.local:8080/calendar\">\n" +
                    "  <input type=\"text\" day=\"name\" \n<Br>\n" +
                    "  <input type=\"text\" month=\"name\" \n<Br>\n" +
                    "  <input type=\"text\" year=\"name\" \n<Br>\n" +
                    "  <input type=\"text\" dayOfWeek=\"name\" \n<Br>\n" +
                    "  <input type=\"text\" weekends=\"name\" \n<Br>\n" +

//                    "  <input type=\"text\" day=\"day\"\n<Br>\n" +
//                    "  <input type=\"text\" month=\"month\"\n<Br>\n" +
//                    "  <input type=\"text\" year=\"year\"\n<Br>\n" +
//                    "  <input type=\"text\" dayOfWeek=\"dayOfWeek\"\n<Br>\n" +
//                    "  <input type=\"text\" weekends=\"weekends\"\n<Br>\n" +
                    "  <p><input type=\"submit\"value=\"Calendar\"></p>\n" +
                    " </form>\n";

    static String headerForMyCalendar =
            "<form action=\"http://greater.local:8080/calendar?\">\n" +
                    "  <p><b>Введите вариант</b></p>\n" +
//                    "  <input type=\"text\" name=\"name\" \n<Br>\n" +
                    "  <p><input type=\"submit\"value=\"Let's go!\"></p>\n" +
                    " </form>\n";

    static String headerForHelloWorld =
            " <form action=\"http://greater.local:8080/hello_world?\">\n" +
                    "  <p><b>Введите вариант</b></p>\n" +
                    "  <input type=\"text\" name=\"name\" \n<Br>\n" +
                    "  <p><input type=\"submit\"value=\"Let's go!\"></p>\n" +
                    " </form>\n";

    public HomePageHandler(HttpRequest httpRequest) {
    }

    @Override
    public String print(HttpRequest httpRequest) {
        return header + formForCalendar + headerForHelloWorld + footer;
    }
}
