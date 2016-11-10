import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URISyntaxException;

public class Server {
    public static void main(String args[]) throws IOException, URISyntaxException {
        run();

    }

    private static void run() throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Listening for connection on port 8080 ....");
        while (true) {
            StringBuilder builder = new StringBuilder();
            Socket socket = server.accept();
            Handler.fillingPage(builder, socket);
            socket.getOutputStream().write(builder.toString().getBytes("UTF-8"));
        }
    }
}

