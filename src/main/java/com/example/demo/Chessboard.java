package com.example.demo;

public class Chessboard {
    private String[][] board;

    public Chessboard() {
        initializeBoard();
    }

    public void initializeBoard() {
        board = new String[8][8];

        // Default chess setup
        board[0] = new String[]{"WR", "WN", "WB", "WQ", "WK", "WB", "WN", "WR"};
        board[1] = new String[]{"WP", "WP", "WP", "WP", "WP", "WP", "WP", "WP"};
        board[6] = new String[]{"BP", "BP", "BP", "BP", "BP", "BP", "BP", "BP"};
        board[7] = new String[]{"BR", "BN", "BB", "BQ", "BK", "BB", "BN", "BR"};

        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = "--"; // Empty spaces
            }
        }
    }

    public void setPiece(int row, int col, String piece) {
        board[row][col] = piece;
    }

    public boolean isValidMove(int row, int col, String piece) {
        return board[row][col].equals(piece);
    }

    public String[][] getBoard() {
        return board;
    }

    public void printBoard() {
        System.out.println("\n=== Chessboard ===");
        for (int i = 0; i < 8; i++) {
            System.out.print((8 - i) + " "); // Rank numbers
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("  a  b  c  d  e  f  g  h"); // File letters
    }
}
