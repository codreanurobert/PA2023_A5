import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class GameServer {
    private int port;
    private ServerSocket serverSocket;
    private boolean running;
    private Game game;
    private List<ClientHandler> clientThreads;

    public GameServer(int port) {
        this.port = port;
        this.running = true;
        this.game = new Game();
        this.clientThreads = new ArrayList<>();
    }

    public static void main(String[] args) {
        GameServer gameServer = new GameServer(3000);
        gameServer.start();
    }

    public void start() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Game server started on port " + port);
            while (running && !game.isGameOver()) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());
                ClientHandler clientThread = new ClientHandler(clientSocket, this);
                clientThreads.add(clientThread);
                clientThread.start();
            }
        } catch (IOException e) {
            if (running) {
                System.err.println("Error starting server on port " + port + ": " + e.getMessage());
            }
        } finally {
            stop();
            System.out.println("Server closed.");
        }
    }

    public synchronized void handleCommand(ClientHandler clientThread, String command)  {
        String[] parts = command.split(" ");
        String action = parts[0];

        if (action.equalsIgnoreCase("create")) {
            if (game.isNotCreated()) {
                Player player = new Player(parts[1], 'X', clientThread.getClientSocket());
                game.join(player);
                clientThread.sendResponse("Game created.");
                System.out.println("Player " + player.getName() + " joined the game: " + player.getSymbol());
                broadcastMessage("Player " + player.getName() + " joined the game: " + player.getSymbol());
            } else {
                clientThread.sendResponse("Game unavailable.");
            }
        } else if (action.equalsIgnoreCase("join")) {
            if (game.isAvailable()) {
                Player player = new Player(parts[1], 'O', clientThread.getClientSocket());
                boolean joined = game.join(player);

                if (joined) {
                    clientThread.sendResponse("Joined game.");
                    // Send confirmation message to the client
                    System.out.println("Player " + player.getName() + " joined the game: " + player.getSymbol());
                    broadcastMessage("Player " + player.getName() + " joined the game: " + player.getSymbol());

                    if (game.isFull()) {
                        game.start();
                        Player currentPlayer = game.getCurrentPlayer();
                        System.out.println("Game started! It's " + currentPlayer.getName() + "'s turn.");
                        broadcastMessage("Game started! It's " + currentPlayer.getName() + "'s turn.");
                    }
                } else {
                    clientThread.sendResponse("Name is taken.");

                }
            } else if (game.isStarted()) {
                clientThread.sendResponse("GAME_ALREADY_STARTED");
            } else {
                clientThread.sendResponse("NO_GAME_AVAILABLE");
            }
        } else if (action.equalsIgnoreCase("move")) {
            if (game.isStarted()) {
                Player player = game.getCurrentPlayer();
                // Check if it's the current player's turn
                if (player.getSocket() == clientThread.getClientSocket()) {
                    int row = Integer.parseInt(parts[1]);
                    int col = Integer.parseInt(parts[2]);
                    System.out.println("Player " + player.getName() + " made a move at (" + row + ", " + col + ")");
                    broadcastMessage("Player " + player.getName() + " made a move at (" + row + ", " + col + ")");
                    game.makeMove(player, row, col);
                    if (game.isGameOver()) {
                        clientThread.sendResponse("EXIT");
                        stop();
                    }
                } else {
                    // it's not the current player's turn, send an error message
                    clientThread.sendResponse("NOT_YOUR_TURN");
                }
            }
        } else if (action.equalsIgnoreCase("exit")) {
            // Handle client exit
            Player player = game.getPlayerBySocket(clientThread.getClientSocket());
            if (player != null) {
                game.removePlayer(player);
                System.out.println("Player " + player.getName() + " has left the game");
                broadcastMessage("Player " + player.getName() + " has left the game");
            }
            clientThread.sendResponse("EXIT");
            clientThread.close();
            clientThreads.remove(clientThread);


            if (clientThreads.isEmpty()) {
                stop();
            }
        }
    }
    private void broadcastMessage(String message) {
        for (ClientHandler clientThread : clientThreads) {
            clientThread.sendResponse(message);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        running = false;
        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (IOException e) {
            System.err.println("Error stopping server on port " + port + ": " + e.getMessage());
        }
    }

}

