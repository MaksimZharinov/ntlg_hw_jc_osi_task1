import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (Socket clientSocket = new Socket("localhost", Server.PORT);
             PrintWriter writer = new PrintWriter(clientSocket.getOutputStream())
        ) {
            writer.println("test connect");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
