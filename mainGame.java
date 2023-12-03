package com.example.demo13;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class mainGame extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(mainGame.class.getResource("menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),614,457);
//        menuScreenController Controller = fxmlLoader.getController();
//        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
////            @Override
////            public void handle(KeyEvent keyEvent) {
////
////            }
//        });
        stage.setTitle("Stick Hero");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}