package com.example.demo;

import java.util.Scanner;

public class ChessGameApp {
    public static void main(String[] args) {
        Chessboard chessboard = new Chessboard(); 
        ChessMovePredictor predictor = new ChessMovePredictor(); 
        Scanner scanner = new Scanner(System.in);

        // Initialize board
        chessboard.initializeBoard();
        chessboard.printBoard();

        while (true) {
            System.out.println("\nEnter your move (e.g., WP e7 e4) or 'exit' to quit:");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Game Over!");
                break;
            }

            String[] parts = input.split(" ");
            if (parts.length != 3) {
                System.out.println("Invalid format! Use 'Piece StartPos EndPos' (e.g., WP e2 e4)");
                continue;
            }

            String piece = parts[0];
            String startPos = parts[1];
            String endPos = parts[2];

            int startRow = 8 - Character.getNumericValue(startPos.charAt(1));
            int startCol = startPos.charAt(0) - 'a';
            int endRow = 8 - Character.getNumericValue(endPos.charAt(1));
            int endCol = endPos.charAt(0) - 'a';

            if (!chessboard.isValidMove(startRow, startCol, piece)) {
                System.out.println("Invalid move! No " + piece + " at " + startPos);
                continue;
            }

            // Move the piece
            chessboard.setPiece(endRow, endCol, piece);
            chessboard.setPiece(startRow, startCol, "--");

            // Print updated board
            chessboard.printBoard();

            // Predict next move
            String predictedMove = predictor.predictNextMove(chessboard.getBoard());
        System.out.println(" " + predictedMove);
        }

        scanner.close();
    }
}
