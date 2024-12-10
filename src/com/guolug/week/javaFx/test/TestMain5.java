package com.guolug.week.javaFx.test;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TestMain5 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // 创建一个组件
        Label label = new Label("这是我创建的Label");
        // 设置组件的大小
        label.setPrefSize(120,30);
        // 设置组件在容器里的位置
        label.setLayoutX(190);
        label.setLayoutY(300);
        // 设置组件的样式
        label.setStyle("-fx-background-color: red;" +
                " -fx-border-color: black;" +
                " -fx-border-style: solid;" +
                "-fx-border-width: 1px;" +
                "-fx-alignment:center;" +
                "-fx-text-alignment: center");
        // 让文本居中
        label.setAlignment(Pos.CENTER);
        // 让控制不显示(默认是显示的)
//        label.setVisible(false);
        label.setVisible(true);
        // 设置透明度
        label.setOpacity(0.5);
        // 设置旋转度数
        label.setRotate(70);
        // 设置平移
        label.setTranslateX(100);
        label.setTranslateY(100);
        // 获取父节点
        System.out.println(label.getParent());
        // 获取当前场景
        System.out.println(label.getScene());
        // 创建一个容器
        AnchorPane anchorPane = new AnchorPane();
        // 组件添加到容器里
        anchorPane.getChildren().addAll(label);
        // 创建一个场景,将容器放进去
        Scene scene = new Scene(anchorPane,500,630);
        // 将场景放到窗口中
        stage.setScene(scene);
        // 设置窗口的图标
        stage.getIcons().add(new Image("image/雪花.png"));
        // 显示窗口
        stage.show();
    }
}
