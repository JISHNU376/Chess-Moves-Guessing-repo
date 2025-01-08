package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ChessGameTests {

    @Test
    void testChessboardInitialization() {
        Chessboard chessboard = new Chessboard();
        String[][] board = chessboard.getBoard();

        // Check if the board is properly initialized with pieces
        assertNotNull(board, "Board should not be null");
        assertEquals(8, board.length, "Board should have 8 rows");
        assertEquals(8, board[0].length, "Board should have 8 columns");

        // Check if the first row contains white pieces
        assertEquals("R", board[0][0], "First square should be a white rook");
        assertEquals("N", board[0][1], "Second square should be a white knight");

        // Check if the seventh row contains black pawns
        assertEquals("p", board[6][0], "First square in the seventh row should be a black pawn");
    }

    @Test
    void testMovePrediction() {
        Chessboard chessboard = new Chessboard();
        ChessMovePredictor movePredictor = new ChessMovePredictor();

        // Predict the next move based on the current chessboard state
        String predictedMove = movePredictor.predictNextMove(chessboard.getBoard());

        // Check that the prediction is not null or empty
        assertNotNull(predictedMove, "Predicted move should not be null");
        assertFalse(predictedMove.isEmpty(), "Predicted move should not be empty");

        // In this simple case, the first move might be from pawn (based on your logic)
        assertTrue(predictedMove.contains("Move Pawn"), "Predicted move should contain 'Move Pawn'");
    }
}
