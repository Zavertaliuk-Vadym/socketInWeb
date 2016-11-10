import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
class Server {
    private Parser parser = new ParserImpl();
    private Router router = new RouterImp();
    int port = 8080;
     void run() throws IOException {
        ServerSocket server = new ServerSocket(port);
        System.out.println("Listening for connection on port 8080 ....");
        while (true) {
            StringBuilder builder = new StringBuilder();
            Socket socket = server.accept();
            parser.parse(socket.getInputStream());
            socket.getOutputStream().write(builder.toString().getBytes("UTF-8"));
        }
    }
}

