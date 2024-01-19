import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Server {

    static int PORT=8080;

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is running on port 8080. Press Ctrl+C to stop.");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepting client");
                new Thread(() -> handleClient(clientSocket)).start();
            }
        }
    }

    private static void handleClient(Socket clientSocket) {
        try (
            Socket socket = clientSocket;
            OutputStream outputStream = socket.getOutputStream()
        ) {
            String response = "HTTP/1.1 200 OK\r\n" +
                    "Content-Type: text/plain\r\n" +
                    "\r\n" +
                    "Hello, this is a simple HTTP server response.";

            outputStream.write(response.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
