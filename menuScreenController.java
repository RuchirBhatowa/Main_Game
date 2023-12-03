package com.example.demo13;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class menuScreenController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private AnchorPane anchorPane1;
    @FXML
    private ImageView myImageView1;
    private Image image1 = new Image(getClass().getResourceAsStream("main.jpg"));
    @FXML
    private AnchorPane anchorPane2;
    @FXML
    private Button clickToPlay;
    @FXML
    private Label label;
    public void switchToMainScreen(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("mainScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



}
