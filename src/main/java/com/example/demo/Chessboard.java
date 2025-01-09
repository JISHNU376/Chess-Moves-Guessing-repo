package com.example.demo;

public class Chessboard {
    private String[][] board;

    public Chessboard() {
        // Initialize the chessboard
        board = new String[8][8];

        // Place pawns
        for (int i = 0; i < 8; i++) {
            board[1][i] = "WP"; // White Pawns
            board[6][i] = "BP"; // Black Pawns
        }

        // Place rooks
        board[0][0] = "WR"; // White Rook
        board[0][7] = "WR";
        board[7][0] = "BR"; // Black Rook
        board[7][7] = "BR";

        // Place knights
        board[0][1] = "WN"; // White Knight
        board[0][6] = "WN";
        board[7][1] = "BN"; // Black Knight
        board[7][6] = "BN";

        // Place bishops
        board[0][2] = "WB"; // White Bishop
        board[0][5] = "WB";
        board[7][2] = "BB"; // Black Bishop
        board[7][5] = "BB";

        // Place queens
        board[0][3] = "WQ"; // White Queen
        board[7][3] = "BQ"; // Black Queen

        // Place kings
        board[0][4] = "WK"; // White King
        board[7][4] = "BK"; // Black King

        // Fill empty spaces
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = "--"; // Empty squares
            }
        }
    }

    public String[][] getBoard() {
        return board;
    }
}
