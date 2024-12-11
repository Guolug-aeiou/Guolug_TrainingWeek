package com.guolug.FivePice.util;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


public class draw extends Application {
    static int zoomCircle = 60;// 图片位置
    static Image iconImage = new Image("image/五子棋-线.png");
    static Image imgCircleNot = new Image("image/未选中圆圈.png");
    static Image imgCircleOn = new Image("image/选中.png");
    //    static Image iconSet = new Image("image/围棋.png");
    static String whiteSide = "  | 白方-请落子";
    static String blackSide = "  | 黑方-请落子";
    static String whiteSideWait = "  | 白方";
    static String blackSideWait = "  | 黑方";
    static Button startButton = new Button("开始游戏");
    static boolean flag = true;
    static final int LINEAMOUNT = 23; // 行数
    static Circle[][] circles = new Circle[21][21];

    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane root = new AnchorPane();
        Scene scene = new Scene(root, 900, 800);
        Line[] linesRow = new Line[LINEAMOUNT];
        Line[] linesCol = new Line[LINEAMOUNT];
        // 软件图标
        stage.getIcons().add(iconImage);
        // 中间图标
//        ImageView imageView = new ImageView(iconSet);
//        imageView.setFitHeight(80);
//        imageView.setFitWidth(80);
//        imageView.setLayoutX(730);
//        imageView.setLayoutY(350);
//        root.getChildren().add(imageView);
        // ⬇️init 画Row和Col线条
        for (int i = 0; i < linesRow.length; i++) {
            linesRow[i] = new Line();
            linesCol[i] = new Line();
        }
        for (int i = 0; i < linesRow.length; i++) {
            linesRow[i].setStartX(50);
            linesRow[i].setStartY(i * 30 + 60);
            linesRow[i].setEndX(710);
            linesRow[i].setEndY(i * 30 + 60);
            linesCol[i].setStartX(i * 30 + 50);
            linesCol[i].setStartY(60);
            linesCol[i].setEndX(i * 30 + 50);
            linesCol[i].setEndY(720);
            root.getChildren().add(linesRow[i]);
            root.getChildren().add(linesCol[i]);
        }
        // 在棋盘交叉点上绘制小点
        int lineRow = 80;
        int lineCol = 90;
        for (int i = 0; i < circles[0].length; i++) {
            for (int j = 0; j < circles[0].length; j++) {
                circles[i][j] = new Circle();
                circles[i][j].setRadius(9);
                circles[i][j].setLayoutX(lineRow);
                circles[i][j].setLayoutY(lineCol);
                circles[i][j].setStroke(Color.BLACK); // 边框颜色
                circles[i][j].setFill(Color.BLACK); // 中间颜色
                root.getChildren().add(circles[i][j]);
                lineRow += 30;
            }
            lineRow = 80;
            lineCol += 30;

        }

        // 插入图片 - 白方
        ImageView imageView1 = new ImageView(imgCircleNot);
        imageView1.setFitHeight(zoomCircle);
        imageView1.setFitWidth(zoomCircle);
        Label label1 = new Label(whiteSideWait, imageView1);
        label1.setLayoutX(scene.getWidth() - 160);
        label1.setLayoutY(100);
        // 插入图片 - 黑方
        ImageView imageView2 = new ImageView(imgCircleNot);
        imageView2.setFitHeight(zoomCircle);
        imageView2.setFitWidth(zoomCircle);
        Label label2 = new Label(blackSideWait, imageView2);
        label2.setLayoutX(scene.getWidth() - 160);
        label2.setLayoutY(scene.getHeight() - 170);
        root.getChildren().add(label1);
        root.getChildren().add(label2);
        // 按钮
        startButton.prefHeight(50);
        startButton.prefWidth(100);
        startButton.setLayoutY(scene.getHeight() / 2 - 25);
        startButton.setLayoutX(scene.getWidth() - 130);
        root.getChildren().add(startButton);
        // ⬆️
        // 按钮事件
        // 开始游戏
        startButton.setOnAction(e -> {
            if (flag) {
                label2.setText(blackSide);
                imageView2.setImage(imgCircleOn);
                label1.setText(whiteSideWait);
                imageView1.setImage(imgCircleNot);
                flag = !flag;
            } else {
                label1.setText(whiteSide);
                imageView1.setImage(imgCircleOn);
                label2.setText(blackSideWait);
                imageView2.setImage(imgCircleNot);
                flag = !flag;
            }
        });
        stage.setScene(scene);
        stage.show();
    }
}
