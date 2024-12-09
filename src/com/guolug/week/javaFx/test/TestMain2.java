package com.guolug.week.javaFx.test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class TestMain2 extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Button button = new Button("跳转百度");
        BorderPane borderPane = new BorderPane(button);
        button.setOnAction(e -> {
            getHostServices().showDocument("www.baidu.com");
        });
        Scene scene = new Scene(borderPane,400,500);
        stage.setScene(scene);
        stage.setTitle("跳转网页");
        stage.show();

    }
}
