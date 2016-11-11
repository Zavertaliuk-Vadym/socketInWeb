/**
 * Created by employee on 11/11/16.
 */
public class CalendarHandler implements Handler {
    private HttpRequest request;

    public CalendarHandler(HttpRequest request) {
        this.request = request;
    }


    public String handle() {
        return null;
    }

    @Override
    public HttpRequest request() {
        return null;
    }

    @Override
    public String print(HttpRequest httpRequest) {
        return "Hello";
    }
}
