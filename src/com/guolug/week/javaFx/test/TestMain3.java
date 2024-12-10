package com.guolug.week.javaFx.test;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Optional;


public class TestMain3 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Button button1 = new Button("按钮1");

        // 添加按钮事件
        button1.setOnAction(e -> {
            Stage stage_son = new Stage();
            stage_son.setHeight(200);
            stage_son.setWidth(300);
            // 设置父窗口
            stage_son.initOwner(stage);
            // 设置子窗口的形态
            stage_son.initModality(Modality.NONE);//默认
//            stage_son.initModality(Modality.APPLICATION_MODAL);//只有当前窗口可以使用
//            stage_son.initModality(Modality.WINDOW_MODAL);//兄弟窗口可以使用,父窗口不能使用
            stage_son.show();
        });

        // 取消窗口默认退出事件
        Platform.setImplicitExit(false);
        stage.setOnCloseRequest(e -> {
            // 取消窗口关闭
            e.consume();
            // 提示弹窗
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("退出程序");
            alert.setHeaderText(null);
            alert.setContentText("是否要退出程序?");
            Optional <ButtonType> result = alert.showAndWait();
            if (result .get()== ButtonType.OK){
                Platform.exit();// 程序一并结束
                stage.close(); // 关闭窗口不退出程序
            }
        });

        // 创建 HBox 容器，并将两个按钮添加进去
        HBox hBox = new HBox(button1);
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(hBox);
        Scene scene = new Scene(borderPane, 400, 400);

        // 添加场景到窗口
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
