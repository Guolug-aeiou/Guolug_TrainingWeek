package com.guolug.week.javaFx.test;

import javafx.application.Application;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TestMain4 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // 创建 2 个按钮
        Button button1 = new Button("下一个场景");
        Button button2 = new Button("上一个场景");

        // 设置按钮大小
        button1.setPrefSize(200,50);
        Label label = new Label("这是一个按键跳转练习");
        button2.setPrefSize(200,50);

        // 设置位置
        label.setLayoutX(200);
        label.setLayoutY(250);

        // 创建容器
        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(button1);
        AnchorPane root_1 = new AnchorPane();
        root_1.getChildren().addAll(label,button2);

        // 创建场景
        Scene scene1 = new Scene(root,400,500);
        Scene scene2 = new Scene(root_1, 400, 500);

        // 设置场景的鼠标效果图
        scene1.setCursor(new ImageCursor(new Image("image/cursor1.png")));
        scene2.setCursor(new ImageCursor(new Image("image/cursor2.png")));
        // 按键事件
        button1.setOnAction(e->{
            stage.setScene(scene2);
        });
        button2.setOnAction(e->{
            stage.setScene(scene1);
        });

        // 添加场景到窗口
        stage.setScene(scene1);
        stage.show();
    }
}
