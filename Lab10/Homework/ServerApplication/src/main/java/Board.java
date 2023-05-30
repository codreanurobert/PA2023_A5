public class Board {
    private static final int SIZE = 15;
    private char[][] cells;

    public Board() {
        cells = new char[SIZE][SIZE];
        clear();
    }

    public void clear() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                cells[row][col] = '-';
            }
        }
    }

    public boolean isValidMove(int row, int column) {
        return row >= 0 && row < SIZE && column >= 0 && column < SIZE && cells[row][column] == '-';
    }

    public void makeMove(int row, int column, char symbol) {
        cells[row][column] = symbol;
    }

    public boolean isWinningMove(int row, int column) {
        char symbol = cells[row][column];

        //orizontal
        int count = 0;
        for (int c = column - 4; c <= column + 4; c++) {
            if (c >= 0 && c < SIZE && cells[row][c] == symbol) {
                count++;
                if (count == 3) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        // vertical
        count = 0;
        for (int r = row - 4; r <= row + 4; r++) {
            if (r >= 0 && r < SIZE && cells[r][column] == symbol) {
                count++;
                if (count == 3) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        // diagonale
        count = 0;
        for (int d = -4; d <= 4; d++) {
            int r = row + d;
            int c = column + d;
            if (r >= 0 && r < SIZE && c >= 0 && c < SIZE && cells[r][c] == symbol) {
                count++;
                if (count == 3) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        count = 0;
        for (int d = -4; d <= 4; d++) {
            int r = row - d;
            int c = column + d;
            if (r >= 0 && r < SIZE && c >= 0 && c < SIZE && cells[r][c] == symbol) {
                count++;
                if (count == 3) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        return false;
    }

    public boolean isFull() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (cells[row][col] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                sb.append(cells[row][col]).append(' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }

}