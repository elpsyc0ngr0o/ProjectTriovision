package com.isep.triofinal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Game extends Application {
    private FXMLLoader fxmlLoader;
    private Scene scene;
    private Stage stage;
    private Operation operation;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        this.fxmlLoader = new FXMLLoader(Game.class.getResource("launching.fxml"));
        this.scene = new Scene(fxmlLoader.load(), 1100, 700);
        this.operation = new Operation(this);
        Controller controller = this.fxmlLoader.getController();
        controller.init(operation);
        this.stage.setTitle("Projet Triovision");
        this.stage.setScene(scene);
        this.stage.show();
    }
    public Controller sceneSwitch(String fxmlFile) throws IOException {
        this.fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = this.fxmlLoader.load();
        Controller controller = this.fxmlLoader.getController();
        this.scene = new Scene(root,1201,720);
        controller.init(this.operation);
        this.stage.setScene(this.scene);
        this.stage.setScene(scene);
        this.stage.show();
        return controller;
    }
    public static void main(String[] args) {
        launch();
    }
    public Scene getScene() {
        return scene;
    }
}