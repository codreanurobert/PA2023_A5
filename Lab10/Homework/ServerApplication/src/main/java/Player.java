import java.io.PrintWriter;
import java.net.Socket;
import java.util.Timer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Player {
    private String name;
    private char symbol;
    private BufferedReader input;
    private PrintWriter output;
    private Socket socket;
    private Timer timer;
    private int timeRemaining;

    public Player(String name, char symbol, Socket socket) {
        this.name = name;
        this.symbol = symbol;
        this.socket = socket;
        try {
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            System.err.println("Error creating input/output streams for player: " + e.getMessage());
        }
        timer = new Timer();
        timeRemaining = 15;
    }

    public int getTimeRemaining() {
        return timeRemaining;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public Socket getSocket() {
        return socket;
    }

    public void notifyMove(int row, int col) {
        output.println("MOVE " + row + " " + col);
    }

    public void notifyTurn() {
        output.println("TURN");
    }

    public void notifyWin() {
        output.println("WIN");
    }

    public void notifyLoss() {
        output.println("LOSS");
    }

    public void notifyDraw() {
        output.println("DRAW");
    }

    public void notifyTimeout() {
        output.println("TIME_UP");
    }

    public void remove() {
        try {
            socket.close();
        } catch (IOException e) {
            System.err.println("Error closing player's socket: " + e.getMessage());
        }
    }
}