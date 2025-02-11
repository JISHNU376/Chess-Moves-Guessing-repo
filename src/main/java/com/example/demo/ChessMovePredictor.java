package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class ChessMovePredictor {
    private static int executionCount = 0; // Use static to persist across instances

    public String predictNextMove(String[][] board) {
        executionCount++; // Increment execution count

        // Only show prediction on even executions
        if (executionCount % 2 != 0) {
            return ""; // Return empty on odd executions
        }

        MoveEvaluation bestMove = getBestMove(board, 2); // Depth 2 minimax
        if (bestMove == null || bestMove.move.isEmpty()) {
            return "No valid moves.";
        }

        // Extract piece from the starting position
        String[] parts = bestMove.move.split(" -> ");
        int startRow = 8 - Character.getNumericValue(parts[0].charAt(1));
        int startCol = parts[0].charAt(0) - 'a';
        String piece = board[startRow][startCol];

        return "Predicted Move: " + piece + " " + bestMove.move; // Include piece name in output
    }

    private MoveEvaluation getBestMove(String[][] board, int depth) {
        List<String> validMoves = getAllValidMoves(board);
        MoveEvaluation bestMove = new MoveEvaluation("", Integer.MIN_VALUE);

        for (String move : validMoves) {
            String[][] newBoard = makeMove(board, move);
            int moveScore = minimax(newBoard, depth - 1, false);
            
            if (moveScore > bestMove.score) {
                bestMove.move = move;
                bestMove.score = moveScore;
            }
        }
        return bestMove;
    }

    private int minimax(String[][] board, int depth, boolean isMaximizing) {
        if (depth == 0) return evaluateBoard(board);

        List<String> validMoves = getAllValidMoves(board);
        int bestScore = isMaximizing ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        for (String move : validMoves) {
            String[][] newBoard = makeMove(board, move);
            int score = minimax(newBoard, depth - 1, !isMaximizing);

            bestScore = isMaximizing ? Math.max(bestScore, score) : Math.min(bestScore, score);
        }
        return bestScore;
    }

    private int evaluateBoard(String[][] board) {
        int score = 0;
        for (String[] row : board) {
            for (String piece : row) {
                score += getPieceValue(piece);
            }
        }
        return score;
    }

    private List<String> getAllValidMoves(String[][] board) {
        List<String> moves = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (!board[i][j].equals("--")) {
                    moves.addAll(getValidMovesForPiece(board[i][j], i, j, board));
                }
            }
        }
        return moves;
    }

    private List<String> getValidMovesForPiece(String piece, int row, int col, String[][] board) {
        List<String> moves = new ArrayList<>();

        if (piece.equals("WP")) { // White Pawn
            if (row > 0 && board[row - 1][col].equals("--")) {
                moves.add(formatMove(piece, row, col, row - 1, col));
            }
        }

        if (piece.equals("WN")) { // White Knight
            int[][] knightMoves = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2},
                                   {1, -2}, {1, 2}, {2, -1}, {2, 1}};
            for (int[] move : knightMoves) {
                int newRow = row + move[0], newCol = col + move[1];
                if (isValidSquare(newRow, newCol)) {
                    moves.add(formatMove(piece, row, col, newRow, newCol));
                }
            }
        }
        return moves;
    }

    private String[][] makeMove(String[][] board, String move) {
        String[][] newBoard = new String[8][8];
        for (int i = 0; i < 8; i++) {
            System.arraycopy(board[i], 0, newBoard[i], 0, 8);
        }

        String[] parts = move.split(" -> ");
        int startRow = 8 - Character.getNumericValue(parts[0].charAt(1));
        int startCol = parts[0].charAt(0) - 'a';
        int endRow = 8 - Character.getNumericValue(parts[1].charAt(1));
        int endCol = parts[1].charAt(0) - 'a';

        newBoard[endRow][endCol] = newBoard[startRow][startCol];
        newBoard[startRow][startCol] = "--";
        return newBoard;
    }

    private int getPieceValue(String piece) {
        switch (piece) {
            case "WP":
            case "BP":
                return 1;
            case "WN":
            case "BN":
            case "WB":
            case "BB":
                return 3;
            case "WR":
            case "BR":
                return 5;
            case "WQ":
            case "BQ":
                return 9;
            case "WK":
            case "BK":
                return 1000;
            default:
                return 0;
        }
    }
    

    private boolean isValidSquare(int row, int col) {
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }

    private String formatMove(String piece, int startRow, int startCol, int endRow, int endCol) {
        char startFile = (char) ('a' + startCol);
        char endFile = (char) ('a' + endCol);
        return startFile + "" + (8 - startRow) + " -> " + endFile + "" + (8 - endRow);
    }

    private static class MoveEvaluation {
        String move;
        int score;

        MoveEvaluation(String move, int score) {
            this.move = move;
            this.score = score;
        }
    }
}
