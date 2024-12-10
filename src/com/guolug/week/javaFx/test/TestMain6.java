package com.guolug.week.javaFx.test;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class TestMain6 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // 创建一个容器
        AnchorPane root = new AnchorPane();
        // 创建一个场景,并放入容器,和设置大小
        Scene scene = new Scene(root,500,500);
        // 创建一个组件
        Circle circle = new Circle();
        // 初始化位置
        circle.setCenterX(scene.getWidth()/2);
        circle.setCenterY(scene.getHeight()/2);
        circle.setRadius(60); //半径
        circle.setStroke(Color.BLACK); // 边框颜色
        circle.setFill(Color.WHITE); // 中间颜色
        // 绑定组件
        circle.centerXProperty().bind(scene.widthProperty().divide(2));
        circle.centerYProperty().bind(scene.heightProperty().divide(2));
        // 监听器绑定组件
        circle.centerXProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                System.out.println("旧值: " + number + "  新值: " + t1);
            }
        });
        // 将组件放到容器里
        root.getChildren().add(circle);
        // 将场景放到窗口里
        stage.setScene(scene);
        stage.show();
    }
}
