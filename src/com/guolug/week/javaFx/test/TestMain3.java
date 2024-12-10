package com.guolug.week.javaFx.test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;

public class TestMain3 extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 400, 400);
        stage.setScene(scene);
        // 设置标题
        stage.setTitle("Title");
        // 设置窗口图标
        stage.getIcons().add(new Image("image/雪花.png"));
        // 设置窗口的大小是否锁定
        stage.setResizable(false);
        // 设置窗口style
        stage.initStyle(StageStyle.DECORATED);//默认
//        StageStyle.DECORATED - 具有纯白色背景和平台装饰的舞台。
//        StageStyle.UNDECORATED - 具有纯白色背景且没有装饰的舞台。
//        StageStyle.TRANSPARENT - 具有透明背景且没有装饰的舞台。
//        StageStyle.UTILITY - 具有纯白色背景和最少平台装饰的舞台。
        stage.show();
    }
}
