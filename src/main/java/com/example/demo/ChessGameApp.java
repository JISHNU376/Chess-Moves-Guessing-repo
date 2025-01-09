package com.example.demo;

public class ChessGameApp {
    private Chessboard chessboard;
    private ChessMovePredictor movePredictor;

    public static void main(String[] args) {
        ChessGameApp app = new ChessGameApp();
        app.run();
    }

    public ChessGameApp() {
        chessboard = new Chessboard();
        movePredictor = new ChessMovePredictor();
    }

    public void run() {
        System.out.println("=== Chess Moves Predictor ===");
        
        // Display the chessboard
        displayChessboard();

        // Predict the next move
        String predictedMove = movePredictor.predictNextMove(chessboard.getBoard());
        System.out.println("Predicted Move: " + predictedMove);
    }

    private void displayChessboard() {
        String[][] board = chessboard.getBoard();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
