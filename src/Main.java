import java.io.IOException;

/**
 * Created by employee on 11/10/16.
 */
public class Main {

    Router router =  new RouterImp();
    Parser parser = new ParserImpl();
    static Server server = new Server();
    public static void main(String[] args) throws IOException {
        server.run();
    }
}
