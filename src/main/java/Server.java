import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final Integer PORT = 8888;

    public static void main(String[] args) throws IIOException {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println(String.format("Start server. Port: %d", PORT));
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
                ) {
                     String infoFromClient = in.readLine();
                    System.out.printf("New client is connect. Info: %s\nclient port: %d",
                            infoFromClient, clientSocket.getPort());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
