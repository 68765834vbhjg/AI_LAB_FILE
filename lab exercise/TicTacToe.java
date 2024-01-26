import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };

        char currentPlayer = 'X';
        boolean gameWon = false;

        while (true) {
            printBoard(board);
            int[] move = getPlayerMove(currentPlayer);
            int row = move[0];
            int col = move[1];

            if (isValidMove(board, row, col)) {
                board[row][col] = currentPlayer;
                gameWon = checkWin(board, currentPlayer);
                if (gameWon) {
                    printBoard(board);
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                } else if (isBoardFull(board)) {
                    printBoard(board);
                    System.out.println("It's a draw!");
                    break;
                }

                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    // Function to print the Tic-Tac-Toe board
    private static void printBoard(char[][] board) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    // Function to get the player's move
    private static int[] getPlayerMove(char currentPlayer) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Player " + currentPlayer + ", enter your move (row and column): ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        return new int[]{row, col};
    }

    // Function to check if the move is valid
    private static boolean isValidMove(char[][] board, int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }

    // Function to check if a player has won
    private static boolean checkWin(char[][] board, char player) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }

        // Check diagonals
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
            (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }

        return false;
    }

    // Function to check if the board is full
    private static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
