package com.example.demo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ChessGameApp extends Application {
    private Chessboard chessboard;
    private ChessMovePredictor movePredictor;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        chessboard = new Chessboard();
        movePredictor = new ChessMovePredictor();

        GridPane grid = new GridPane();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Text text = new Text(chessboard.getBoard()[i][j]);
                text.setStyle("-fx-font-size: 20;");
                grid.add(text, j, i);
            }
        }

        String predictedMove = movePredictor.predictNextMove(chessboard.getBoard());

        Text predictionText = new Text("Predicted Move: " + predictedMove);
        predictionText.setStyle("-fx-font-size: 16;");
        grid.add(predictionText, 0, 9, 8, 1); // Display prediction below the board

        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setTitle("Chess Moves Predictor");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
