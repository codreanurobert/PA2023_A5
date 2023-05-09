/*

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class GameServer {
    private ServerSocket serverSocket;
    private ArrayList<ClientThread> clientThreads;

    public GameServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);
            clientThreads = new ArrayList<ClientThread>();

        } catch (Exception e) {
            System.out.println("Error starting server on port " + port);
            System.exit(1);
        }
    }

    public void start() {
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                ClientThread clientThread = new ClientThread(clientSocket, this);
                clientThreads.add(clientThread);
                clientThread.start();
            } catch (IOException e) {
                System.out.println("Error accepting client connection" + e.getMessage());
            }
        }
    }

    public void stop() {
        try {
            serverSocket.close();
            System.out.println("Server stopped");

            for (ClientThread clientThread : clientThreads) {
                clientThread.interrupt();
            }
        } catch (Exception e) {
            System.out.println("Error stopping server");
        }
    }

    public synchronized void removeClientThread(ClientThread clientThread) {
        clientThreads.remove(clientThread);
    }

    public synchronized void broadcast(String message) {
        for (ClientThread clientThread : clientThreads) {
            clientThread.sendMessage(message);
        }
    }

}
*/

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// Server class
public class GameServer {
    public static void main(String[] args) {
        ServerSocket server = null;

        try {
            server = new ServerSocket(1234);
            server.setReuseAddress(true);
            System.out.println("Server started");

            while (true) {
                Socket client = server.accept();
                System.out.println("New client connected " + client.getInetAddress().getHostAddress());

                ClientHandler clientSock = new ClientHandler(client);

                new Thread(clientSock).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
