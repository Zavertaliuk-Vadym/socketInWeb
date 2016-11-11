import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

class RouterImp implements Router {
    //    static HttpRequest httpRequest = new HttpRequest();
//    static void getParameters(StringBuilder builder, String parameters) throws UnsupportedEncodingException {
//        if (parameters.contains("/calendar")) {
//            builder.append(getPrint()).append(footer);
//        }
//        if (parameters.contains("/new")) {
//            builder.append(header);
//            if (parameters.contains("name")) {
//                builder.append("Hello").append(httpRequest.getPath(parameters)).append(migrationForm);
//            }
//            builder.append(footer);
//            return;
//        }
//        if (parameters.contains("/hello_world")) {
//            builder.append(header).append(headerForHelloWorld).append(migrationForm).append(footer);
//        } else {
//            builder.append(header).append(migrationForm).append(footer);
//        }
//    }
    private static Map<String, Function<HttpRequest, Handler>> routes = new HashMap<>();

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

    @Override
    public void register(String path, Function<HttpRequest, Handler> handlerFactory) {
        routes.put(path, handlerFactory);
    }

    @Override
    public String dispatch(HttpRequest httpRequest) {
        Handler handler;
        System.out.println("httpRequest.getPath()="+httpRequest.getPath());
        try {

            handler = routes.get(httpRequest.getPath()).apply(httpRequest);
            System.out.println(handler);
            System.out.println("ok");
            System.out.println("handler.print(httpRequest)=!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println(routes.get(httpRequest.getPath()).apply(httpRequest));
//            return routes.get(httpRequest.getPath()).apply(httpRequest);
            return handler.print(httpRequest);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }


}