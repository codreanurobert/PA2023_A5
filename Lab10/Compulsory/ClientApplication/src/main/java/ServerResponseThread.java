import java.io.BufferedReader;
import java.io.IOException;

public class ServerResponseThread implements Runnable {
    private BufferedReader input;
    public ServerResponseThread(BufferedReader input) {
        this.input = input;
    }
    public void run() {
        try {
            String response;
            while ((response = input.readLine()) != null) {
                System.out.println("Server response: " + response);
            }
        } catch (IOException e) {
            System.out.println("Server disconnected");
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                // do nothing
            }
        }
    }
}
