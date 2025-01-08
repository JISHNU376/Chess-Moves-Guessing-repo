package com.example.demo;

public class Chessboard {

    private String[][] board;

    public Chessboard() {
        // Initialize the board with pieces (simplified version)
        board = new String[8][8];
        initializeBoard();
    }

    public String[][] getBoard() {
        return board;
    }

    private void initializeBoard() {
        // Initialize the board with some sample pieces
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 0) {
                    board[i][j] = (j == 0 || j == 7) ? "R" : (j == 1 || j == 6) ? "N" : null;
                } else if (i == 6) {
                    board[i][j] = "p";
                } else {
                    board[i][j] = null;
                }
            }
        }
    }
}
