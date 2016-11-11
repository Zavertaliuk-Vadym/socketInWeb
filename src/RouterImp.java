import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

class RouterImp implements Router {
    private Map<String, Function<HttpRequest, Handler>> routes = new HashMap<>();

    @Override
    public void register(String path, Function<HttpRequest, Handler> handlerFactory) {
        routes.put(path, handlerFactory);
    }

    @Override
    public String dispatch(HttpRequest httpRequest) {
        Handler handler;
//        System.out.println("httpRequest.getPath()=" + httpRequest.getPath());
        try {
            handler = routes.get(httpRequest.getPath()).apply(httpRequest);
            return handler.print(httpRequest);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }
}