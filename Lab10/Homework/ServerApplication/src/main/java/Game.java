import java.util.Timer;
import java.util.TimerTask;
import java.net.Socket;

public class Game {
    private Board board;
    private Player[] players;
    private int currentPlayerIndex;
    private boolean gameStarted;
    private boolean gameOver;
    private int timeLimitSeconds;
    private long turnStartTime;
    private int currentPlayerTimeRemaining;
    private Timer turnTimer;


    public Game() {
        board = new Board();
        players = new Player[2];
        currentPlayerIndex = 0;
        gameOver = false;
        gameStarted = false;
        timeLimitSeconds = 10;
    }

    private boolean isPlayerTurn(Player player) {
        return player == players[currentPlayerIndex];
    }

    public synchronized boolean join(Player player) {
        if (isPlayerNameTaken(player.getName())) {
            return false;
        }

        if (players[0] == null) {
            players[0] = player;
        } else if (players[1] == null) {
            players[1] = player;
            notifyAll();
            return true;
        }
        return false;
    }

    private boolean isPlayerNameTaken(String playerName) {
        for (Player player : players) {
            if (player != null && player.getName().equalsIgnoreCase(playerName)) {
                return true;
            }
        }
        return false;
    }


    public synchronized boolean isFull() {
        return players[0] != null && players[1] != null;
    }

    public synchronized void makeMove(Player player, int row, int col) {
        if (!gameOver && isPlayerTurn(player) && board.isValidMove(row, col)) {
            board.makeMove(row, col, player.getSymbol());
            players[currentPlayerIndex].notifyMove(row, col);

            // Check if the move resulted in a win
            if (board.isWinningMove(row, col)) {
                players[currentPlayerIndex].notifyWin();
                players[1 - currentPlayerIndex].notifyLoss();
                gameOver = true;
            }
            else if (board.isFull()) {
                players[currentPlayerIndex].notifyDraw();
                players[1 - currentPlayerIndex].notifyDraw();
                gameOver = true;
            }

            else {
                currentPlayerIndex = 1 - currentPlayerIndex;
                long elapsedTime = System.currentTimeMillis() - turnStartTime;
                currentPlayerTimeRemaining = players[currentPlayerIndex].getTimeRemaining() - (int) (elapsedTime / 1000);
                if (currentPlayerTimeRemaining <= 0) {
                    players[currentPlayerIndex].notifyTimeout();
                    players[1 - currentPlayerIndex].notifyWin();
                    gameOver = true;
                } else {
                    players[currentPlayerIndex].notifyTurn();
                }
                turnStartTime = System.currentTimeMillis();
            }
        }
    }

    public synchronized boolean isAvailable() {
        return players[0] != null && players[1] == null;
    }

    public synchronized boolean isNotCreated() {
        return players[0] == null;
    }

    public synchronized void start() {
        while (!isFull()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        gameStarted = true;
        notifyAll();

        // Set initial turn start time
        turnStartTime = System.currentTimeMillis();

        // Start the turn-based timer
        turnTimer = new Timer();
        currentPlayerTimeRemaining = players[currentPlayerIndex].getTimeRemaining();
        turnTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                currentPlayerTimeRemaining--;
                if (currentPlayerTimeRemaining <= 0) {
                    players[currentPlayerIndex].notifyTimeout();
                    players[1 - currentPlayerIndex].notifyWin();
                    gameOver = true;
                }
            }
        }, 1000, 1000);
    }

    public synchronized boolean isGameOver() {
        return gameOver;
    }

    public synchronized boolean isStarted() {
        return gameStarted;
    }

    public synchronized Player getCurrentPlayer() {
        return players[currentPlayerIndex];
    }

    public synchronized void removePlayer(Player player) {
        player.remove();
    }

    public synchronized Player getPlayerBySocket(Socket socket) {
        for (Player player : players) {
            if (player.getSocket() == socket) {
                return player;
            }
        }
        return null;
    }
}