package com.guolug.FivePice.util;

import com.guolug.FivePice.Init.ChessPieces;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import java.util.Optional;


public class Draw extends Application {
    // 当前谁下棋
    static int camp = 1;
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
    static final int LINEAMOUNT = 23; // 行数
    static ChessPieces[][] chessPieces = new ChessPieces[21][21];
    static String winner;

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
            label2.setText(blackSide);
            imageView2.setImage(imgCircleOn);
            label1.setText(whiteSideWait);
            imageView1.setImage(imgCircleNot);
            // 在棋盘交叉点上绘制小点
            int lineX = 80;
            int lineY = 90;
            for (int i = 0; i < chessPieces[0].length; i++) {
                for (int j = 0; j < chessPieces[0].length; j++) {
                    chessPieces[i][j] = new ChessPieces(lineX, lineY, new Circle());
                    root.getChildren().add(chessPieces[i][j].getCircle());
                    lineX += 30;
                    final int row = i;
                    final int col = j;
                    chessPieces[row][col].getCircle().setOnMouseClicked(mouseEvent -> {
                        if (!chessPieces[row][col].isState()) {
                            chessPieces[row][col].setCamp(camp++);
                        }
                        if (camp % 2 == 0) {
                            label1.setText(whiteSide);
                            imageView1.setImage(imgCircleOn);
                            label2.setText(blackSideWait);
                            imageView2.setImage(imgCircleNot);
                        } else if (camp % 2 == 1) {
                            label2.setText(blackSide);
                            imageView2.setImage(imgCircleOn);
                            label1.setText(whiteSideWait);
                            imageView1.setImage(imgCircleNot);
                        }
                        if (decide(chessPieces)) {
                            // 取消窗口关闭
                            e.consume();
                            // 提示弹窗
                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//                            Stage stage1 = (Stage)alert.getDialogPane().getScene().getWindow();
//                            stage1.initStyle(StageStyle.TRANSPARENT);
                            alert.setTitle("退出程序");
                            alert.setHeaderText(null);
                            alert.setContentText(winner);
                            Optional<ButtonType> result = alert.showAndWait();
                            System.out.println(result);
                            if (result.get() == ButtonType.OK || result.get() == ButtonType.CANCEL) {
                                Platform.exit();// 程序一并结束
                                stage.close(); // 关闭窗口不退出程序
                            }
                        }
                    });
                }
                lineX = 80;
                lineY += 30;
            }
        });
        stage.setScene(scene);
        stage.show();
    }

    public boolean decide(ChessPieces[][] chessPieces) {
        // level
        switch (Check.level(chessPieces)) {
            case 1:
                winner = "黑方胜出!";
                return true;
            case 2:
                winner = "白方胜出!";
                return true;
        }
        // vertical
        switch (Check.vertical(chessPieces)) {
            case 1:
                winner = "黑方胜出!";
                return true;
            case 2:
                winner = "白方胜出!";
                return true;
        }
        // leadingDiagonal
        switch (Check.leadingDiagonal(chessPieces)) {
            case 1:
                winner = "黑方胜出!";
                return true;
            case 2:
                winner = "白方胜出!";
                return true;
        }
        // counterDiagonal
        switch (Check.counterDiagonal(chessPieces)) {
            case 1:
                winner = "黑方胜出!";
                return true;
            case 2:
                winner = "白方胜出!";
                return true;
            default :
                winner = null;
                return false;
        }
    }
}


