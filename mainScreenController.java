package com.example.demo13;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Box;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class mainScreenController<Player> {
    @FXML
    AnchorPane Anchorpane = new AnchorPane();
    @FXML
    ImageView backgroundView;
    Image background = new Image(getClass().getResourceAsStream("main.jpg"));
    @FXML
    ImageView charView;
    Image character = new Image(getClass().getResourceAsStream("Game.png"));
    @FXML
    Rectangle rectangle = new Rectangle();
    private Line line;
    private double lineLength;
    private Timeline timeline;
    private boolean stickRotated;
    private boolean stickExtended;
    private Timeline rotateTimeline;
    private int count;
    private Rotate rotate;

    public void mainSceneControllerc(Line line) {
        this.line = line;
        lineLength = 0;
        this.line.setStrokeWidth(2.0);
        this.count = 1;
        rotate = new Rotate();
        line.getTransforms().add(rotate);
    }

    public boolean isStickExtended() {
        return stickExtended;
    }

    public void setStickExtended(boolean stickExtended) {
        this.stickExtended = stickExtended;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;

    }

    public double getLineLength() {
        return lineLength;
    }

    public void setLineLength(double lineLength) {
        this.lineLength = lineLength;
    }
    public Timeline getTimeline() {
        return timeline;
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }
    public void setLineCoordinates() {
        line.setStartX(101.0);
        line.setStartY(200.0);
        line.setEndX(101.0);
        line.setEndY(200.0);
    }
    public void extendLine(Stage stage, Player player, Scene scene, Box first, Box second) {
        this.stickExtended = false;
        scene.setOnMousePressed(e -> {
            this.growStick(stage,player,scene);
        });
        scene.setOnMouseReleased(e -> {
            timeline.stop();
        });
    }
    private void growStick(Stage stage, Player player, Scene scene) {
        if (this.isStickExtended()) {
            return;
        }
            this.setLineLength(0.0);
        this.setLineCoordinates();
        timeline = new Timeline(
                new KeyFrame(Duration.millis(10), e -> {
                    lineLength+=1.0;
                    line.setEndY(line.getStartY() - lineLength);
                })
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public void handleKeyPress(KeyEvent keyEvent) {
    }

    public void handleKeyRelease(KeyEvent keyEvent) {
    }
}