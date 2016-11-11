import print.Print;
import print.PrintInWeb;

/**
 * Created by employee on 11/11/16.
 */
public class CalendarHandler implements Handler {
    private HttpRequest request;

    public CalendarHandler(HttpRequest request) {
        this.request = request;
    }

    @Override
    public String print(HttpRequest httpRequest) {
        System.out.println("IT's calendar=!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1"+httpRequest);
        Print print = new PrintInWeb();
        return print.print();
    }
}
