package com.guolug.week.javaFx.test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ChessBoard extends Application {
    private static final int TILE_SIZE = 40;
    private static final int BOARD_SIZE = 19;

    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(TILE_SIZE * BOARD_SIZE, TILE_SIZE * BOARD_SIZE);
        drawBoard(canvas);
        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> handleMouseClick(e, canvas));
        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root);
        primaryStage.setTitle("ChessBoard");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private void drawBoard(Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);
        for (int i = 0; i < BOARD_SIZE; i++) {
            // Draw vertical lines
            gc.strokeLine(i * TILE_SIZE, 0, i * TILE_SIZE, BOARD_SIZE * TILE_SIZE);
            // Draw horizontal lines
            gc.strokeLine(0, i * TILE_SIZE, BOARD_SIZE * TILE_SIZE, i * TILE_SIZE);
        }
    }


    private void handleMouseClick(MouseEvent e, Canvas canvas) {
        int x = (int) (e.getX() / TILE_SIZE);
        int y = (int) (e.getY() / TILE_SIZE);
        placeStone(canvas, x, y);
    }


    private void placeStone(Canvas canvas, int x, int y) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK); // You can alternate between black and white for different players
        gc.fillOval(x * TILE_SIZE - TILE_SIZE / 2, y * TILE_SIZE - TILE_SIZE / 2, TILE_SIZE, TILE_SIZE);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
