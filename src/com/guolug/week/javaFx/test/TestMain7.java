package com.guolug.week.javaFx.test;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class TestMain7 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane root = new AnchorPane();
        Scene scene = new Scene(root, 600, 700);
        Button button = new Button("向上移动");
        button.setLayoutX(500);
        button.setLayoutY(350);
        button.setPrefSize(60, 30);
        Label label = new Label("hello world!!!");
        label.setLayoutX(10);
        label.setLayoutY(350);
        label.setPrefSize(70, 30);
        root.getChildren().add(button);
        root.getChildren().add(label);
        // 组件按下事件
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                label.setLayoutY(label.getLayoutY() - 10);
            }
        });
        //键盘按钮事件
        scene.setOnKeyReleased(event -> {
            KeyCode code = event.getCode();
            if (code.equals(KeyCode.DOWN)) {
                label.setLayoutY(label.getLayoutY() + 10);
            } else if (code.equals(KeyCode.UP)) {
                label.setLayoutY(label.getLayoutY() - 10);
            }
        });
        stage.setScene(scene);
        stage.show();
    }
}
