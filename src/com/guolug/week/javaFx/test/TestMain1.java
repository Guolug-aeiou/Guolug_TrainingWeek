package com.guolug.week.javaFx.test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * JavaFX 应用程序的主类。
 * 该应用程序创建一个简单的窗口，显示 "hello world!!!" 文本。
 */
public class TestMain1 extends Application {

    /**
     * JavaFX 应用程序的入口点。
     * 使用 launch 方法启动 JavaFX 运行时并调用 start 方法。
     *
     * @param args 命令行参数（通常为空）
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

    /**
     * 当 JavaFX 应用程序启动时调用此方法。
     * 在这里设置窗口 (Stage) 和场景 (Scene)，并添加 UI 组件。
     *
     * @param stage 应用程序的主要窗口
     * @throws Exception 如果初始化过程中出现问题，则抛出异常
     */
    @Override
    public void start(Stage stage) throws Exception {
        // 创建一个新的 Label 控件，并设置其文本为 "hello world!!!"
        Label label = new Label("hello world!!!");

        // 创建一个新的 BorderPane 布局容器，并将 Label 添加到中心位置
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(label); // 将 Label 放置在 BorderPane 的中心

        // 创建一个新的 Scene，指定布局容器和尺寸（宽度400px，高度400px）
        Scene scene = new Scene(borderPane, 400, 400);

        // 设置窗口的标题
        stage.setTitle("hello world!!!");

        // 将 Scene 设置给 Stage，这样当窗口显示时会展示这个场景
        stage.setScene(scene);

        // 显示窗口及其内容
        stage.show();
        System.out.println("start");
    }

    @Override
    public void init() throws Exception {
        // init 方法可以做一些链接数据库和初始化等操作供 start 使用
        super.init();
        System.out.println("init");
    }

    @Override
    public void stop() throws Exception {
        // stop 方法做一些资源回收的工资
        super.stop();
        System.out.println("stop");
    }
}