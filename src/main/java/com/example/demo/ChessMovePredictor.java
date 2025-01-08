package com.example.demo;
public class ChessMovePredictor {
    public String predictNextMove(String[][] board) {
        // A simple placeholder move prediction based on basic piece position
        // For simplicity, it guesses the first valid move found for the white pawns

        for (int i = 1; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j].equals("P")) {  // Looking for white pawns
                    // If a pawn is at row 1, move it forward
                    if (board[i + 1][j].equals(".")) {
                        return "Move Pawn from " + (char)('A' + j) + (i + 1) + " to " + (char)('A' + j) + (i + 2);
                    }
                }
            }
        }

        return "No move predicted"; // In case no valid move is found
    }
}
