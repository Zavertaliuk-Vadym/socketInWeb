import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
class Server {
    private Parser parser = new ParserImpl();
    private Router router = new RouterImp();
    private Handler handler;
    int port = 8080;
     void run() throws IOException {
        ServerSocket server = new ServerSocket(port);
        System.out.println("Listening for connection on port 8080 ....");
        while (true) {
            Socket socket = server.accept();
            HttpRequest request = parser.parse(socket.getInputStream());
            String handler = router.dispatch(request).toString();
            System.out.println("handler===="+handler);
            String dispatch = router.dispatch(request);
//            parser.parse(socket.getInputStream());
//            System.out.println("Server"+parser.parse(socket.getInputStream()));
            socket.getOutputStream().write(dispatch.getBytes("UTF-8"));
        }
    }

//    private void dispatchRequest(HttpRequest request) {
//        String response = router.dispatch(request);
////      send response back to socket
//    }

}

