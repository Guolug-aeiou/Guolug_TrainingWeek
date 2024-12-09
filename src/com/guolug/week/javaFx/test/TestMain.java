package com.guolug.week.javaFx.test;

import javafx.application.Application;
import javafx.stage.Stage;

public class TestMain extends Application {
    public static void main(String[] args) {
        //
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // 设置标题
        stage.setTitle("hello world!!!");
        stage.show();
    }
}
