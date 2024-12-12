package com.guolug.FivePice.Init;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class ChessPieces {
    // 阵营
    private int camp = 0;
    private int isCamp = 0;
    // 位置
    private int locationX;
    private int locationY;
    // 是否已经下了
    private boolean state = false;
    private Circle circle;

    public ChessPieces(int locationX, int locationY, Circle circle) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.circle = circle;
        // 设置棋子状态
        // 棋子的大小
        int radius = 12;
        this.circle.setRadius(radius);
        this.circle.setStroke(Color.TRANSPARENT);
        this.circle.setFill(Color.TRANSPARENT);
        this.circle.setLayoutX(this.locationX);
        this.circle.setLayoutY(this.locationY);
    }

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public int getCamp() {
        return camp;
    }

    public void setCamp(int camp) {
        if (camp != 0 && camp % 2 == 0) {
            if (!this.state) {
                this.circle.setStyle("-fx-Fill: #cccccc;");
                this.circle.setStroke(Color.BLACK);
                this.setState(true);
                this.state = true;
                this.isCamp = 2;
            }
        } else if (camp % 2 == 1) {
            if (!this.state) {
                this.circle.setStroke(Color.BLACK);
                this.circle.setFill(Color.BLACK);
                this.setState(true);
                this.state = true;
                this.isCamp = 1;
            }
        }
        this.camp = camp;
    }

    public int getLocationX() {
        return locationX;
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getIsCamp() {
        return isCamp;
    }

    public void setIsCamp(int isCamp) {
        this.isCamp = isCamp;
    }



    @Override
    public String toString() {
        return "ChessPieces{" +
                "isCamp=" + isCamp +
                ", state=" + state +
                '}';
    }
}
